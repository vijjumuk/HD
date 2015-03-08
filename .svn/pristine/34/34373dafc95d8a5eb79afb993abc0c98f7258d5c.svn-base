(function() {
    'use strict';

    angular
        .module('efs.route')
        .run(appRun);

    appRun.$inject = ['routerHelper'];
    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'route',
                config: {
                    url: '/route',
                    templateUrl: 'route/route.html',
                    controller: 'UploadTemplate',
                    title: 'route',
                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-dashboard"></i> Upload'
                    }
                }
            }
        ];
    }
})();