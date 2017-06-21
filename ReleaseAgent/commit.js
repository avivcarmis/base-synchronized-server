// conf

var common = require('./common');
if (process.argv.length < 3) {
    common.exit('commit message is required as process argument');
}
var data = common.getData();
var commitMsg = process.argv[2];

// script

console.log("Release Agent Commit Routine for message: " + commitMsg);
updateVersion();
updateData();
data.isNewRelease = false;
common.setData(data);
checkRelease();

// functions

function updateVersion() {
    var data = common.readVersion();
    var parts = data.split('.');
    if (parts.length != common.getVersionFormatStructure().length) {
        common.exit('Unexpected version format found in version file. Edit conf file or manually change version file to match 4 parts.');
    }
    var result = [];
    var incremented = false;
    for (var i = 0; i < common.getVersionFormatStructure().length; i++) {
        if (incremented) {
            result[i] = 0;
            continue;
        }
        parts[i] = parseInt(parts[i]);
        var condition = common.getVersionFormatStructure()[i];
        var shouldIncrement = false;
        if (typeof condition == "boolean") {
            shouldIncrement = condition;
        }
        else {
            for (var j = 0; j < condition.length; j++) {
                var search = "-" + condition[j].toUpperCase();
                if (commitMsg.toUpperCase().indexOf(search) != -1) {
                    shouldIncrement = true;
                }
            }
        }
        if (shouldIncrement) {
            result[i] = parts[i] + 1;
            incremented = true;
        }
        else {
            result[i] = parts[i];
        }
    }
    result = result.join('.');
    common.writeFile(common.getConf().versionFilePath, result);
    console.log('version: ' + result);
}

function checkRelease() {
    if (commitMsg.toUpperCase().indexOf("-R") != -1) {
        release();
    }
}

function release() {
    console.log("Release Agent Release Routine");
    createReleaseNotes();
    common.clearData();
    data.isNewRelease = true;
    common.setData(data);
}

function updateData() {
    for (var i = 0; i < common.getSupportedFlags().length; i++) {
        handleAttribute(common.getSupportedFlags()[i].flag, common.getSupportedFlags()[i].meaning);
    }
}

function handleAttribute(letter, as) {
    var search = "-" + letter.toUpperCase();
    var currentPos = 0;
    while (commitMsg.toUpperCase().indexOf(search, currentPos) != -1) {
        currentPos = commitMsg.toUpperCase().indexOf(search, currentPos) + 3;
        var finishIndex = currentPos + 2;
        while (commitMsg.length > finishIndex && commitMsg.charAt(finishIndex) != '\n' && !isFlag(commitMsg.toUpperCase().substr(finishIndex, 3))) {
            finishIndex++;
        }
        var msg = commitMsg.substring(currentPos, finishIndex).trim();
        common.writeData(as, msg);
        console.log('documented ' + as + ': ' + msg);
    }
}

function isFlag(str) {
    for (var i = 0; i < common.getSupportedFlags().length; i++) {
        var value = "-" + common.getSupportedFlags()[i].flag.toUpperCase() + " ";
        if (str.toUpperCase() == value) {
            return true;
        }
    }
    return false;
}

function createReleaseNotes() {
    var version = common.readVersion();
    var releaseFilename = common.replaceAll(version, ".", "-");
    var releaseFilepath = common.getConf().releaseDirPath + "/" + releaseFilename;
    common.validateFileNotExist(releaseFilepath, 'Release notes for this version already exist, if you wish to override them, remove the release notes file and run release routine again. (' + releaseFilepath + ')');
    var data = common.readAllData();
    var output = "Release Notes For Version: " + version + "\n";
    var date = new Date();
    output += "Release Date: " + date.toGMTString() + "\n";
    for (var attribute in data) {
        var list = data[attribute];
        output += "\n" + attribute.toUpperCase() + " LIST:\n------------------------------\n";
        if (list.length == 0) {
            output += "None\n";
            continue;
        }
        list.sort(function(a, b) {
            return a.date - b.date;
        });
        for (var i = 0; i < list.length; i++) {
            var entry = list[i];
            var entryDate = new Date();
            entryDate.setTime(entry.date);
            output += (i + 1) + ") " + entry.value + " (" + entryDate.toGMTString() + ")\n";
        }
    }
    common.validateDir(common.getConf().releaseDirPath);
    common.writeFile(releaseFilepath, output);
    console.log('created release file => ' + releaseFilepath + "\n" + output);
}