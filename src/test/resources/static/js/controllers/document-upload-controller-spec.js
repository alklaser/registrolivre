describe("Controller: DocumentUploadController", function() {
 var $rootScope, $scope, $controller, $httpBackend, document;
    beforeEach(module('registro-livre'));
    beforeEach(inject(function($injector) {
        $rootScope = $injector.get('$rootScope');
        $scope = $rootScope.$new();
        $controller = $injector.get('$controller');
        $httpBackend = $injector.get('$httpBackend');
        document = $injector.get('documentUpload');

        $controller('DocumentUploadController', {
            '$scope': $scope,
             document: document
        });
    }));

    it('Should call documentUpload factory when uploadDocument is triggered', inject(function(documentUpload) {
        var spy = sinon.spy();
        var $scope = {};
        var controller = $controller('DocumentUploadController', { $scope: $scope, documentUpload: { sendDocument: spy } });
        $scope.uploadDocument();

        spy.should.have.been.called.once;
    }));
});
