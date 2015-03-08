(function() {
    'use strict';

    angular
        .module('efs.upload')
        .controller('Message', Message);

    Message.$inject = ['efsUploadMessage'];

    function Message(efsUploadMessage) {
        var vm = this;

        vm.message = efsUploadMessage;

        vm.hide = false;

        vm.close = function() {
            vm.hide = true;
        }
    }

})();
