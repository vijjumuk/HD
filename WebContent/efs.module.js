(function() {
    'use strict';

    angular.module('efs', [
        /*
         * Order is not important. Angular makes a
         * pass to register all of the modules listed.
         */

        /*
         * Everybody has access to these.
         * We could place these under every feature area,
         * but this is easier to maintain.
         */
        'ui.router',  
        'efs.core',
        'blocks.common',
        'blocks.router',
        'blocks.parser',

        /*
         * Feature areas
         */
        'efs.upload',
        'efs.route',
        'efs.location'
    ]);
})();


