describe("Controller: CompaniesListController", function() {
    var $rootScope, $scope, $controller, $httpBackend, companies;

    beforeEach(module('registro-livre'));
    beforeEach(inject(function($injector) {
        $rootScope = $injector.get('$rootScope');
        $scope = $rootScope.$new();
        $controller = $injector.get('$controller');
        $httpBackend = $injector.get('$httpBackend');
        companies = $injector.get('companies');

        $controller('CompaniesListController', {
            '$scope': $scope,
             companies: companies
        });
    }));

    afterEach(function() {
        $httpBackend.verifyNoOutstandingRequest();
        $httpBackend.verifyNoOutstandingExpectation();
    });

    it("get companies list", function() {
        var expectedCompanies = [{id: 1, cnpj: "123456", tradeName: "Company One Ltda"}, {id: 2, cnpj: "654321", tradeName: "Company Two, Inc"}];

        $httpBackend.expectGET('/empresas').respond(expectedCompanies);

        $httpBackend.flush();

        $scope.companies.should.be.deep.equal(expectedCompanies);
    });
});