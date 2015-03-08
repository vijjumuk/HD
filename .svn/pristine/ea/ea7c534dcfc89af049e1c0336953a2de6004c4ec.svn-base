(function() {
    'use strict';

    angular.module('blocks.common')
        .constant('DEPARTMENT_SEPARATOR', '-')
        .constant('EMPTY_STRING', '')
        .constant('FIRST_BEFORE_SECOND', -1)
        .constant('SECOND_BEFORE_FIRST', 1)
        .constant('SAME', 0)
        .factory('locationCompare', locationCompare)
        .filter('locationSort', locationSort);

    function locationCompare(isNumeric, DEPARTMENT_SEPARATOR, EMPTY_STRING, FIRST_BEFORE_SECOND, SECOND_BEFORE_FIRST, SAME) {
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

    function locationSort(locationCompare) {
        return function (data, matcher) {
            var uppercaseMatcher = angular.uppercase(matcher);


            if (angular.isArray(data)) {
                var arraySorted = [],
                    arrayOfFirstValueMatches = [],
                    arrayOfExactMatchesInAnyLocation = [],
                    numberOfFirstValueMatches = 0,
                    uppercaseData = [];

                for (var k = 0; k < data.length; k++) {
                    uppercaseData[k] = angular.uppercase(data[k]);
                }

                var i1 = 0;
                for (var i = 0; i < uppercaseData.length; i++) {
                    if (uppercaseData[i].indexOf(uppercaseMatcher) === 0) {
                        arrayOfFirstValueMatches[i1] = uppercaseData[i];
                        i1++;
                        numberOfFirstValueMatches++;
                    }
                }

                var n;
                var i2 = 0;
                for (var i3 = 0; i3 < uppercaseData.length; i3++) {
                    n = uppercaseData[i3].indexOf(uppercaseMatcher);
                    if (n !== 0 && n !== -1) {
                        arrayOfExactMatchesInAnyLocation[i2] = uppercaseData[i3];
                        i2++;
                    }
                }

                arrayOfFirstValueMatches.sort(locationCompare);
                arrayOfExactMatchesInAnyLocation.sort(locationCompare);

                var indexNumber = 0;
                for (var i4 = 0; i4 < arrayOfFirstValueMatches.length && numberOfFirstValueMatches > 0;) {
                    arraySorted[i4] = arrayOfFirstValueMatches[i4];
                    i4 = i4 + 1;
                    indexNumber = i4;
                }

                var i5 = 0;
                for (var i6 = indexNumber; i6 < arrayOfExactMatchesInAnyLocation.length; i6++) {
                    arraySorted[i6] = arrayOfExactMatchesInAnyLocation[i5];
                    i5++;
                }

                return arraySorted;
            } else {

                return data;
            }

        }
    }
})();
