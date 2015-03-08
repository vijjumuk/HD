(function() {
    'use strict';

    angular.module('blocks.common')
        .constant('DEPARTMENT_SEPARATOR', '-')
        .constant('EMPTY_STRING', '')
        .constant('FIRST_BEFORE_SECOND', -1)
        .constant('SECOND_BEFORE_FIRST', 1)
        .constant('SAME', 0)
        .factory('locationTypeAheadSort', locationTypeAheadSort);

    function locationTypeAheadSort(isNumeric, DEPARTMENT_SEPARATOR, EMPTY_STRING, FIRST_BEFORE_SECOND, SECOND_BEFORE_FIRST, SAME) {
        return function (firstValue, secondValue) {

            if (isNumeric(firstValue) && isNumeric(secondValue)) {

                return firstValue - secondValue;

            } else {

                var firstValueNoSeparator, secondValueNoSeparator;

                firstValueNoSeparator = firstValue.replace(DEPARTMENT_SEPARATOR, EMPTY_STRING);
                secondValueNoSeparator = secondValue.replace(DEPARTMENT_SEPARATOR, EMPTY_STRING);

                if (isNumeric(firstValueNoSeparator) && isNumeric(secondValueNoSeparator)) {

                    return firstValueNoSeparator - secondValueNoSeparator;

                } else {
                    if (firstValue < secondValue) {

                        return FIRST_BEFORE_SECOND;

                    }
                    if (firstValue > secondValue) {

                        return SECOND_BEFORE_FIRST;

                    }
                    return SAME;

                }
            }
        };
    }
})();
