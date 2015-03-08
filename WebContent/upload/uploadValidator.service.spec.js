describe('EFS upload: upload validator tests:: ', function () {

    var uploadValidator,
        UPLOAD_ERRORS;

    beforeEach(angular.mock.module('efs.upload'));
    beforeEach(angular.mock.module('efs'));

    beforeEach(angular.mock.inject(function (_uploadValidator_, _UPLOAD_ERRORS_) {
        uploadValidator = _uploadValidator_;
        UPLOAD_ERRORS = _UPLOAD_ERRORS_;
    }));

    it('expect uploadValidator service to exist', function () {
        expect(uploadValidator).toBeDefined();
    });

    it('expect isValidFile to be true on a good file name', function() {
        expect(uploadValidator.isValidFile({name: 'test.csv'})).toBeTruthy();
    });

    it('expect isValidFile to be false on empty file object', function() {
        expect(uploadValidator.isValidFile({name: 'test'})).toBeFalsy();
        expect(uploadValidator.getErrors()).toEqual([{message: UPLOAD_ERRORS['FILE_EXTENSION_ERROR']}]);
    });

    it('expect isValidFile error message to be a file extension error on empty file object', function() {
        uploadValidator.isValidFile({name: 'test'});
        expect(uploadValidator.getErrors()).toEqual([{message: UPLOAD_ERRORS['FILE_EXTENSION_ERROR']}]);
    });

    it('expect isValidFile show errors to be true on an empty file object', function() {
        uploadValidator.isValidFile({name: 'test'});
        expect(uploadValidator.showErrors()).toBeTruthy();
    });

    it('expect isValidFile show errors to be false when remove error is called for the only error in errors', function() {
        uploadValidator.isValidFile({name: 'test'});
        uploadValidator.removeError('FILE_EXTENSION_ERROR');
        expect(uploadValidator.showErrors()).toBeFalsy();
    });

    it('expect isValidFile error message to be a file space error', function() {
        uploadValidator.isValidFile({name: 'a test.csv'});
        expect(uploadValidator.getErrors()).toEqual([{message: UPLOAD_ERRORS['FILE_SPACE_ERROR']}]);
    });

    it('expect isValidFile error message to be a no special character error', function() {
        uploadValidator.isValidFile({name: 'a#test.csv'});
        expect(uploadValidator.getErrors()).toEqual([{message: UPLOAD_ERRORS['SPECIAL_CHARACTER_ERROR']}]);
    });

    it('expect isValidFile error message to be a file length error', function() {
        uploadValidator.isValidFile({name: 'areallyreallyreallyreallylongfilename.csv'});
        expect(uploadValidator.getErrors()).toEqual([{message: UPLOAD_ERRORS['FILE_LENGTH_ERROR']}]);
    });

    it('expect isValidFile error message to be a file length error', function() {
        uploadValidator.isValidFile({name: 'a_file.csv', size:20000001});
        expect(uploadValidator.getErrors()).toEqual([{message: UPLOAD_ERRORS['FILE_SIZE_ERROR']}]);
    });

});
