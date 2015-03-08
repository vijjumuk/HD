(function() {
    'use strict';

    angular
        .module('efs.location')
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
                state: 'location',
                config: {
                    url: '/location',
                    templateUrl: 'location/location.html',
                    controller: 'LocationCtrl',
                    title: 'location',
                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-dashboard"></i> Upload'
                    }
                }
            }
        ];
    }
})();

/*
(function() {
    'use strict';

    angular
        .module('efs.location')
        .run(appRun);

    appRun.$inject = ['routerHelper'];
    */
/* @ngInject *//*

    function appRun(routerHelper) {
    	var otherwise = '/';
        routerHelper.configureStates(getStates(), otherwise);
    }

    function getStates() {
        return [
            {
                state: 'location',
                config: {
                    url: '/location',
                    templateUrl: 'location/.html',
                    controller: 'LocationCtrl',
                    title: 'location',
                    settings: {
                        nav: 2,
                        content: '<i class="fa fa-dashboard"></i> Location'
                    }
                }
            }
        ];
    }
})();*/
