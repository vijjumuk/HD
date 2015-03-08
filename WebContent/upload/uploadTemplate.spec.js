describe('EFS upload: upload tests:: ', function () {

    var controller
        , UPLOAD_URL
        ,httpBackend
        ,$upload
        ,responseMessage;

    beforeEach(angular.mock.module('blocks.parser'));
    beforeEach(angular.mock.module('efs.upload'));
    beforeEach(angular.mock.module('efs.core'));
    //Probably need to just inject ui.router into efs.upload.  need to discuss
    beforeEach(angular.mock.module('ui.router'));

    //This is needed to stop our $otherwise routes from firing when httpBackend.flush is invoked
    beforeEach(module(function($urlRouterProvider) {
        $urlRouterProvider.deferIntercept();
    }));

    beforeEach(angular.mock.inject(function ($controller, _UPLOAD_URL_, $httpBackend, _$upload_) {
        controller = $controller('UploadTemplate');
        UPLOAD_URL = _UPLOAD_URL_;
        httpBackend = $httpBackend;  
        $upload = _$upload_;
    }));

    it('UploadTemplate controller exists', function () {
        expect(controller).toBeDefined(); 
    });

    it('upload function exists', function () {
        expect(controller.upload).toBeDefined();
    });

    it('validate upload submission', function () {
        
        httpBackend.whenPOST(UPLOAD_URL).respond(
            {
                'ResponseTO': {'returnCode': 0, 'returnMessage': 'Uploaded Successfully!'}
            }
        );
        $upload.upload({
            url: UPLOAD_URL,
            fields: {'userId': 'test'},
            file: {name:'testFile.csv'}
        }).success(function(data, status, headers, config){
            responseMessage = data.ResponseTO.returnMessage;
            expect(config.file.name).toEqual('testFile.csv');
        });
        httpBackend.flush();
        expect(responseMessage).toEqual('Uploaded Successfully!');
    })

});
