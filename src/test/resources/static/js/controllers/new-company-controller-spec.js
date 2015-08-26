describe("Controller: NewCompanyController", function() {
 var $rootScope, $scope, $controller, $httpBackend, document, messages;
    beforeEach(module('registro-livre'));
    beforeEach(inject(function($injector) {
        $rootScope = $injector.get('$rootScope');
        $scope = $rootScope.$new();
        $controller = $injector.get('$controller');
        $httpBackend = $injector.get('$httpBackend');
        messages = $injector.get('messages');
    }));

    it('should create a new company', inject(function(companies, messages) {
        var spy = sinon.spy();
        var newCompany = function(company) {
            return {
                then: spy
             };
        };

        var $scope = {};
        var controller = $controller('NewCompanyController', { $scope: $scope, companies: { newCompany: newCompany }, messages: messages});
        var company = { 
          cnpj: "231231",
          name: "Example Company"
        };
        controller.createCompany(company);

        spy.should.have.been.called.once;
    }));
});
