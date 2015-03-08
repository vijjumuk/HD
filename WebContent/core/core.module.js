(function() {
    'use strict';

    angular.module('efs.core', [
        /*
         * Angular modules
         */
        'ngResource',
        'ngSanitize',
        'ngAnimate',
        /*
         * 3rd Party modules
         */
        'ui.router',
        'mgcrea.ngStrap',
        'angularFileUpload',
        'ngTouch',
        'ui.grid',
        'ui.grid.resizeColumns',
        'ui.grid.moveColumns',
        'ui.grid.selection',
        'ui.grid.exporter'

        /*
         * Our reusable cross app code modules
         */
         
    ]);
})();
