(function() {
    'use strict';

    angular.module('blocks.common')
        .factory('isNumeric', isNumeric);

    function isNumeric () {
        return function (value) {

            if(value != null) {

                if(value.toString().length === 0) {

                    return false;

                } else {

                    if(Number(value) === 0){

                        return true;

                    } else {

                        return  !isNaN(value);
                    }
                }
            } else {

                return false;
            }
        };
    }
})();

