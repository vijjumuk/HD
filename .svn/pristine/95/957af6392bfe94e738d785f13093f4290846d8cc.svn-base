describe('Blocks Common: locationSort filter tests:: ', function () {

    var locationCompare,
        filter;

    beforeEach(angular.mock.module('efs'));
    beforeEach(angular.mock.inject(function (_locationCompare_, $filter) {
        locationCompare = _locationCompare_;
        filter = $filter;
    }));

    it('sortDisplayNumbers function exists', function () {
        expect(locationCompare).toBeDefined();
    });

    it('sortDisplayNumbers function exists as an Angular factory function', function () {
        angular.mock.inject(function (_locationCompare_) {
            expect(_locationCompare_).toBeDefined();
        });
    });

    it('sortDisplayNumbers returns a positive number when first number is > second number', function () {
        expect(locationCompare(22, 18)).toEqual(4);
    });

    it('sortDisplayNumbers returns a negative number when first number is <  second number', function () {
        expect(locationCompare(18, 22)).toEqual(-4);
    });

    it('sortDisplayNumbers returns a zero numbers are the same', function () {
        expect(locationCompare(18, 18)).toEqual(0);
    });

    it(' A number array using sortDisplayNumbers should be sorted lowest to highest', function () {
        var test = [22, 18, 24];
        expect(test.sort(locationCompare)).toEqual([18, 22, 24]);
    });

    it('A number array with a dash between numbers using sortDisplayNumbers should be sorted lowest to highest', function () {
        var test = ['22-22', '18-30', '22-21'];
        expect(test.sort(locationCompare)).toEqual(['18-30', '22-21', '22-22']);
    });

    it('A non number value should be sorted alphabetically by position from left to right irregardless of length', function () {
        var test = ['124X', '123456Y', '3456768Z'];
        expect(test.sort(locationCompare)).toEqual(['123456Y', '124X', '3456768Z']);
    });

    it('Strings of the same values should be placed next to each other', function () {
        var test = ['124X', '123456Y', '124X'];
        expect(test.sort(locationCompare)).toEqual(['123456Y', '124X', '124X']);
    });

    it('Verify locationSort filter exists', function () {
        expect(filter('locationSort')).toBeDefined();
    });

    it('locationSort sorts by leading match first', function () {
        expect((filter('locationSort')(['123456', '3456768'], '345'))[0]).toBe('3456768');
    });

    it('locationSort sorts numbers in numeric order', function () {
        expect((filter('locationSort')(['123456', '124', '3456768'], '12'))[0]).toBe('124');
    });

    it('locationSort sorts strings in alphabetical order', function () {
        expect((filter('locationSort')(['124X', '123456Y', '3456768Z'], '12'))[0]).toBe('123456Y');
    });
    /*filter fix*/
    it('locationSort sorts strings in alphabetical order when matcher is lowcase', function () {
        expect((filter('locationSort')(['1Y24X', '123456Z', '3456768K'], 'y'))[0]).toBe('1Y24X');
    });

    it('locationSort sorts strings in alphabetical order when matcher is uppercase', function () {
        expect((filter('locationSort')(['124X', '123456Y', '3456768Z'], 'Y'))[0]).toBe('123456Y');
    });

    it('locationSort sorts strings in alphabetical order when matcher is uppercase and data is lowercase', function () {
        expect((filter('locationSort')(['124X', '1y23456', '3456768Z'], 'Y'))[0]).toBe('1Y23456');
    });

    it('locationSort returns data value if not array', function() {
        expect(filter('locationSort')('A')).toBe('A');
    });
    
});
