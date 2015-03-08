(function() {
    'use strict';

    angular
        .module('efs.upload')
        .run(appRun);

    appRun.$inject = ['routerHelper'];
    /* @ngInject */
    function appRun(routerHelper) {
    	var otherwise = '/';
        routerHelper.configureStates(getStates(), otherwise);
    }

    function getStates() {
        return [
            {
                state: 'upload',
                config: {
                    url: '/',
                    templateUrl: 'upload/upload.html',
                    controller: 'UploadTemplate',
                    title: 'upload',
                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-dashboard"></i> Upload'
                    }
                }
            }
        ];
    }
})();