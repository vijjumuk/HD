(function() {
    'use strict';

    angular
        .module('efs.upload')
        .controller('UploadError', UploadError);


    UploadError.$inject = ['uploadValidator'];

    function UploadError(uploadValidator) {
        var vm = this;

        vm.header = 'Alert';
        vm.uploadErrors = uploadValidator.getErrors();

        vm.message = function() {
            if(uploadValidator.showErrors()) {
                return uploadValidator.getErrors()[0].message;
            }
        };

        vm.show = function() {
            return uploadValidator.showErrors();
        };
    }

})();