describe('Blocks Common: isNumeric tests:: ', function () {

    var isNumeric;

    beforeEach(angular.mock.module('efs'));
    beforeEach(angular.mock.inject(function (_isNumeric_) {
        isNumeric = _isNumeric_;
    }));

    it('isNumeric function exists', function () {
        expect(isNumeric).toBeDefined();
    });

    it('isNumeric function exists as an Angular factory function', function () {
        angular.mock.inject(function (_isNumeric_) {
            expect(_isNumeric_).toBeDefined();
        });
    });

    it('isNumeric considers an integer valid', function () {
        expect(isNumeric(22)).toBeTruthy();
    });

    it('isNumeric considers an integer passed in as a string valid', function () {
        expect(isNumeric('22')).toBeTruthy();
    });

    it('isNumeric considers an decimal valid', function () {
        expect(isNumeric(22.2)).toBeTruthy();
    });

    it('isNumeric considers an number with a trailing character invalid', function () {
        expect(isNumeric('22X')).toBeFalsy();
    });

    it('isNumeric considers a null invalid', function () {
        expect(isNumeric(null)).toBeFalsy();
    });

    it('isNumeric considers a empty string invalid', function () {
        expect(isNumeric('')).toBeFalsy();
    });

    it('isNumeric considers 0 to be a number', function () {
        expect(isNumeric(0)).toBeTruthy();
    });
});
