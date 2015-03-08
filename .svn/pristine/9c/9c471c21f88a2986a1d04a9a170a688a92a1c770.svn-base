describe('Blocks Common: locationTypeAhead tests:: ', function () {

    var locationTypeAheadSort;

    beforeEach(angular.mock.module('efs'));
    beforeEach(angular.mock.inject(function (_locationTypeAheadSort_) {
        locationTypeAheadSort = _locationTypeAheadSort_;
    }));

    it('sortDisplayNumbers function exists', function () {
        expect(locationTypeAheadSort).toBeDefined();
    });

    it('sortDisplayNumbers function exists as an Angular factory function', function () {
        angular.mock.inject(function (_locationTypeAheadSort_) {
            expect(_locationTypeAheadSort_).toBeDefined();
        });
    });

    it('sortDisplayNumbers returns a positive number when first number is > second number', function () {
        expect(locationTypeAheadSort(22, 18)).toEqual(4);
    });

    it('sortDisplayNumbers returns a negative number when first number is <  second number', function () {
        expect(locationTypeAheadSort(18, 22)).toEqual(-4);
    });

    it('sortDisplayNumbers returns a zero numbers are the same', function () {
        expect(locationTypeAheadSort(18, 18)).toEqual(0);
    });

    it(' A number array using sortDisplayNumbers should be sorted lowest to highest', function () {
        var test = [22, 18, 24];
        expect(test.sort(locationTypeAheadSort)).toEqual([18, 22, 24]);
    });

    it('A number array with a dash between numbers using sortDisplayNumbers should be sorted lowest to highest', function () {
        var test = ['22-22', '18-30', '22-21'];
        expect(test.sort(locationTypeAheadSort)).toEqual(['18-30', '22-21', '22-22']);
    });

    it('A non number value should be sorted alphabetically by position from left to right irregardless of length', function () {
        var test = ['124X', '123456Y', '3456768Z'];
        expect(test.sort(locationTypeAheadSort)).toEqual(['123456Y', '124X', '3456768Z']);
    });

    it('Strings of the same values should be placed next to each other', function () {
        var test = ['124X', '123456Y', '124X'];
        expect(test.sort(locationTypeAheadSort)).toEqual(['123456Y', '124X', '124X']);
    });
});
