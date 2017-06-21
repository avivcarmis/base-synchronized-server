var fs = require('fs');
var data = require('./data/data');
var supportedFlags = [
	{
		flag: 'f',
		meaning: 'feature'
	},
	{
		flag: 'b',
		meaning: 'bugfix'
	}
];
var versionFormatStructure = [
	false,
	['f', 'b'],
	true
];

var methods = {

	readVersion: function() {
		return fs.readFileSync(methods.getConf().versionFilePath).toString();
	},

	getSupportedFlags: function() {
		return supportedFlags;
	},

	getVersionFormatStructure: function() {
		return versionFormatStructure;
	},

	getConf: function() {
		return require('./conf');
	},
	
	validateFileNotExist: function(path, errorMessage) {
		if (fs.existsSync(path)) {
			methods.exit(errorMessage);
		}
	},
	
	writeData: function(dir, data) {
		dir = "./data/" + dir;
		methods.validateDir(dir);
		var date = methods.getDate();
		var hash = Math.random() + "";
		hash = hash.replace(".", "");
		var filename = date + '-' + hash;
		data = date + "\n" + data;
		methods.writeFile(dir + "/" + filename, data);
	},
	
	validateDir: function(dir) {
		if (!fs.existsSync(dir)) {
			fs.mkdirSync(dir);
		}
	},
	
	getDate: function() {
		var date = new Date();
		return date.getTime();
	},
	
	getData: function() {
		return data;
	},
	
	replaceAll: function(str, search, target) {
		while (str.indexOf(search) != -1) {
			str = str.replace(search, target);
		}
		return str;
	},
	
	readAllData: function() {
		var result = {};
		for (var i = 0; i < supportedFlags.length; i++) {
			var attribute = supportedFlags[i].meaning;
			result[attribute] = [];
			var dir = './data/' + attribute + '/';
            if (!fs.existsSync(dir)) {
            	continue;
			}
			var files = fs.readdirSync(dir);
			for (var j = 0; j < files.length; j++) {
				var data = fs.readFileSync(dir + files[j]).toString();
				data = data.split('\n');
				result[attribute].push({
					date: data[0],
					value: data[1]
				});
			}
		}
		return result;
	},
	
	clearData: function() {
		for (var i = 0; i < supportedFlags.length; i++) {
			var attribute = supportedFlags[i].meaning;
			var dir = './data/' + attribute;
			methods.clearDir(dir);
		}
	},
	
	clearDir: function(path) {
	    if (!fs.existsSync(path)) {
	        return;
        }
		var files = fs.readdirSync(path);
		for (var j = 0; j < files.length; j++) {
			fs.unlinkSync(path + '/' + files[j]);
		}
	},
	
	setData: function(data) {
		data = "module.exports = " + JSON.stringify(data) + ";";
		methods.writeFile('./data/data.js', data);
	},
	
	readFile: function(path, callback) {
		fs.readFile(path, 'utf8', function (err, data) {
			methods.validateError(err);
			callback(data);
		});
	},

	writeFile: function(path, data) {
		fs.writeFileSync(path, data);
	},

	validateError: function(err) {
		if (err) {
			methods.exit(err);
		}
	},

	exit: function(msg) {
		console.log(msg);
		process.exit(-1);
	}
	
};

module.exports = methods;