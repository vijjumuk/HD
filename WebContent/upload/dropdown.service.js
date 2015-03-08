(function () {
    angular
        .module('efs.upload')
        .factory('uploadMenu', uploadMenu);

    function uploadMenu() {
        return {
            getMenu: 'Test'
        };
    }
})();
