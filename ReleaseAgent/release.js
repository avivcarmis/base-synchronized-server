// conf

var common = require('./common');
var data = common.getData();
var date = new Date();

// scripts

console.log("Release Agent Release Routine");
createReleaseNotes();
common.clearData();
data.isNewRelease = true;
common.setData(data);

// functions

function createReleaseNotes() {
	var version = common.readVersion();
	var releaseFilename = common.replaceAll(version, ".", "-");
	var releaseFilepath = common.getConf().releaseDirPath + "/" + releaseFilename;
	common.validateFileNotExist(releaseFilepath, 'Release notes for this version already exist, if you wish to override them, remove the release notes file and run release routine again. (' + releaseFilepath + ')');
	var data = common.readAllData();
	var output = "Release Notes For Version: " + version + "\n";
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