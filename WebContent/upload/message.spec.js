describe('EFS upload: message tests:: ', function(){

    var controller;
    beforeEach(angular.mock.module('efs.upload'));
    beforeEach(angular.mock.module('efs.core'));

    beforeEach(angular.mock.inject(function($controller) {
        controller = $controller('Message');
    }));

    it('Message controller exists', function(){
        expect(controller).toBeDefined();
    });

    it('Message content exists', function() {
        expect(controller.message).toBeDefined();
    });

    it('Message hide behavior defaults to false', function() {
        expect(controller.hide).toBeFalsy();
    });

    it('Message hide behavior is set to true with close', function() {
        controller.close();
        expect(controller.hide).toBeTruthy();
    });

});