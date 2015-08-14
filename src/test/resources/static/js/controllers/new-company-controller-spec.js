describe("Controller: NewCompanyController", function() {
 var $rootScope, $scope, $controller, $httpBackend, document;
    beforeEach(module('registro-livre'));
    beforeEach(inject(function($injector) {
        $rootScope = $injector.get('$rootScope');
        $scope = $rootScope.$new();
        $controller = $injector.get('$controller');
        $httpBackend = $injector.get('$httpBackend');

    }));

    it('Should call factory when click method is triggered', inject(function(companies) {
        var spy = sinon.spy();
        var $scope = {};
        var controller = $controller('NewCompanyController', { $scope: $scope, companies: { newCompany: spy } });
        var company = { 
          cnpj: "231231",
          name: "Example Company"
        };
        controller.createCompany(company);

        spy.should.have.been.called.once;
    }));
});
