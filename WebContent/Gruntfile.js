/**
 * Created by HXH6025 on 10/18/2014.
 */

module.exports = function(grunt) {

    // Project configuration.
	grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        watch: {
            js: {
                files: [
                    'WebContent/**/*.js',
                    'Gruntfile.js',
                    "!**/node_modules/**/*",
                    "!**/coverage/**/*"
                ],
                tasks: ['karma:unit:run']
            },
            //run unit tests with karma (server needs to be already running)
            karma: {
                files: [
                    '**/*.js',
                    //ignore all the mode modules or else they will kill your machine
                    "!**/node_modules/**/*", 
                    "!**/coverage/**/*" 
                ],
                tasks: ['karma:unit:run']
            }
        },
        karma: {
            unit: {
                configFile: 'karma.conf.js',
                background: true
            }
        }
    });
 
	// Load the Grunt plugins.
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-run');
    grunt.loadNpmTasks('grunt-karma');
    grunt.registerTask('default', ['watch', 'karma']);
       
};