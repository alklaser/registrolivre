describe("Factory: companies", function() {

    var companies, $httpBackend;

    beforeEach(module('registro-livre'));
    beforeEach(inject(function($injector) {
        companies = $injector.get('companies');
        $httpBackend = $injector.get('$httpBackend');
    }));

    afterEach(function() {
        $httpBackend.verifyNoOutstandingRequest();
        $httpBackend.verifyNoOutstandingExpectation();
    });

    it("get all companies", function() {

        var expectedCompanies = [{ id: 1, cnpj: "2", tradeName: "trade name" }];

        $httpBackend.expectGET('/empresas').respond(expectedCompanies);

        companies.all().then(function(response){
            response.should.be.deep.equal(expectedCompanies);
        });
        $httpBackend.flush();

    });
});