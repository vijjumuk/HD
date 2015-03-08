(function () {
    angular
        .module('efs.upload')
        .constant('UPLOAD_URL', 'rs/EFSUploadResource/uploadFile')
        .controller('UploadTemplate', UploadTemplate);

    UploadTemplate.$inject = ['$upload', 'UPLOAD_URL', 'templateParser', 'uploadValidator'];

    function UploadTemplate($upload, UPLOAD_URL, templateParser, uploadValidator) {
        var vm = this;

        vm.username = 'nab04';

        vm.upload = function (files) {

            var SINGLE_FILE_SELECT = 0;
            vm.file = files[SINGLE_FILE_SELECT];

            if (uploadValidator.isValidFile(vm.file)) {

                templateParser.validateTemplate(vm.file).then(
                    function (value) {
                        console.log('Promise returns: ' + value);
                        vm.fileType = value;

                        return $upload.upload({
                            url: UPLOAD_URL,
                            fields: {
                                'userId': vm.username,
                                'fileType': vm.fileType
                            },
                            file: vm.file
                        })
                            .progress(progress)
                            .success(success);

                        function progress(evt) {
                            var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                            console.log('progress: ' + progressPercentage + '% ');
                        }

                        function success(data, status, headers, config) {
                            console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
                        }
                    },
                    function (value) {
                        console.log('Promise rejects: ' + value);
                        uploadValidator.addError('FILE_TYPE_UNKNOWN');
                    }
                );

            }
            console.log(angular.toJson(uploadValidator.getErrors()));
        };

    }
})();

