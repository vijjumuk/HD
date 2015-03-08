(function () {
    'use strict';

    angular
        .module('efs.upload')
        .constant('UPLOAD_ERRORS', {
            'SPECIAL_CHARACTER_ERROR': 'A file name cannot have special characters.',
            'FILE_LENGTH_ERROR': 'A file name (including the .csv) cannot be greater than 25 characters.',
            'FILE_SPACE_ERROR': 'A file name cannot have spaces.',
            'FILE_SIZE_ERROR': 'The file cannot be larger than 20mb.',
            'FILE_EXTENSION_ERROR': 'Only .csv files can be uploaded.',
            'FILE_TYPE_UNKNOWN':'The upload template is not recognized.'
        })
        .constant('MAX_FILE_NAME_LENGTH', 25)
        .constant('MAX_FILE_SIZE', 20000000)
        .constant('FILE_EXTENSION', 'csv')
        .factory('uploadValidator', uploadValidator);

    function uploadValidator(UPLOAD_ERRORS, MAX_FILE_NAME_LENGTH, MAX_FILE_SIZE, FILE_EXTENSION) {
        var validator = {
            errors: {}
        };

        validator.addError = function (field) {
            validator.errors[field] = field;
        };

        validator.removeError = function (field) {
            delete validator.errors[field];
        };

        validator.clearErrors = function () {
            validator.errors = {};
        };

        validator.showErrors = function () {
            return Object.keys(validator.errors).length > 0;
        };

        validator.getErrors = function () {

            var results = [];
            for (var property in validator.errors) {
                if (validator.errors.hasOwnProperty(property)) {
                    results.push({message: UPLOAD_ERRORS[property]})
                }
            }

            return results;
        };

        validator.specialCharacter = function (file) {

            var testAgainst = new RegExp('[^a-zA-Z0-9_.]');
            var result = !(testAgainst.test(file.name));
            if (!result) {
                validator.addError('SPECIAL_CHARACTER_ERROR');
            }
            return result
        };

        validator.fileNameLength = function (file) {
            var result = !(file.name.length > MAX_FILE_NAME_LENGTH);
            if (!result) {
                validator.addError('FILE_LENGTH_ERROR');
            }
            return result
        };

        validator.fileNameSpaces = function (file) {
            var result = !(file.name.indexOf(' ') >= 0);
            if (!result) {
                validator.addError('FILE_SPACE_ERROR');
            }
            return result;
        };

        validator.fileSize = function (file) {
            var result = !(file.size > MAX_FILE_SIZE);
            if (!result) {
                validator.addError('FILE_SIZE_ERROR');
            }
            return result
        };

        validator.fileExtension = function (file) {
            var ext = file.name.substring(file.name.lastIndexOf('.') + 1);
            var result = (ext === FILE_EXTENSION);
            if (!result) {
                validator.addError('FILE_EXTENSION_ERROR');
            }
            return result
        };

        validator.isValidFile = function (file) {

            validator.clearErrors();

            return validator.fileNameSpaces(file) &&
                validator.specialCharacter(file) &&
                validator.fileNameLength(file) &&
                validator.fileSize(file) &&
                validator.fileExtension(file);
        };

        return {
            isValidFile: validator.isValidFile,
            showErrors: validator.showErrors,
            getErrors: validator.getErrors,
            addError: validator.addError,
            removeError: validator.removeError
        };
    }
})();
