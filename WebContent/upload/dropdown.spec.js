describe('EFS upload: drop down tests:: ', function(){

    var controller;
    beforeEach(angular.mock.module('efs.upload'));
    beforeEach(angular.mock.module('efs.core'));

    beforeEach(angular.mock.inject(function($controller) {
        controller = $controller('Dropdown');
    }));

    it('Drop down controller exists', function(){
        expect(controller).toBeDefined();
    });

    it('Drop down settings exists', function() {
        expect(controller.data).toBeDefined();
    });

});
