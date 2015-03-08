describe('EFS upload: upload error tests:: ', function () {

    var UploadError,
        uploadValidator;

    beforeEach(angular.mock.module('efs.upload'));

    beforeEach(angular.mock.module('efs'));

    beforeEach(angular.mock.inject(function($controller, _uploadValidator_){
        UploadError = $controller('UploadError');
        uploadValidator = _uploadValidator_;
    }));

    it('UploadError controller exists', function(){
        expect(UploadError).toBeDefined();
    });

    it('UploadError show function exists', function(){
        expect(UploadError.show).toBeDefined();
    });

    it('UploadError show returns false when called without any errors defined', function(){
       expect(UploadError.show()).toBeFalsy();
    });

    it('UploadError show returns true when called with an error defined', function(){
        uploadValidator.addError('FILE_TYPE_UNKNOWN');
        expect(UploadError.show()).toBeTruthy();
    });

    it('UploadError message returns correct message when error is added', function(){
        uploadValidator.addError('FILE_TYPE_UNKNOWN');
        expect(UploadError.message()).toEqual('The upload template is not recognized.');
    });

    it('UploadError message does not exist when errors not present', function(){
        expect(UploadError.message()).toBeUndefined();
    });

});