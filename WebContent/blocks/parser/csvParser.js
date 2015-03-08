(function() {
    'use strict';

    angular.module('blocks.parser')
        .value('Papa', Papa)
        .factory('csvParser', csvParser);

    function csvParser(Papa, $q) {

        var parser = {};

        parser.parseHeader = function(file) {
            var deferred = $q.defer();

            var headerOnlyConfig = {
                header: true,
                preview: 1,
                complete: complete,
                error: error
            };

            deferred.notify('Parsing file ' + file.name);
            Papa.parse(file, headerOnlyConfig);

            function complete(results, file) {
                deferred.resolve(results.meta.fields);
                console.log("Parsing of header complete:", results, file);
                /*this.header = results.meta.fields;
                 this.fileType = parser.getFileType(results.meta.fields);
                 console.log("parser results:",this.header,this.fileType);
                 console.log("headers:", results.meta.fields);*/
            }

            function error(error, file) {
                deferred.reject(error);
                console.log("Parsing of header complete fail:", error, file);
            }

            return deferred.promise;
        };

        return parser;

    }
})();
