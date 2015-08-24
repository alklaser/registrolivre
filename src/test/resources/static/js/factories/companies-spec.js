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

    it("should get all registered companies", function() {

        var expectedCompanies = [{ id: 1, cnpj: "2", tradeName: "trade name" }];

        $httpBackend.expectGET('/empresas').respond(expectedCompanies);

        companies.all().then(function(response){
            response.should.be.deep.equal(expectedCompanies);
        });
        $httpBackend.flush();

    });

    it("should returns success message when creating new company with correct information", function() {
        var company = {
          cnpj: "2903902193",
          tradeName: "Fantasy Name"
        };

        var expectedResponse = 200;

        $httpBackend.expectPOST('/cadastro', company).respond(expectedResponse);

        companies.newCompany(company).then(function(response) {
          response.should.be.deep.equal(expectedResponse);
        });
        $httpBackend.flush();
    });

    it("should returns a company with an existing cnpj", function() {
        var company = {
            cnpj: "2903902193",
            tradeName: "Fantasy Name"
        };
        var expectedResponse = 200;
        $httpBackend.expectGET('/buscar-por-cnpj?cnpj=2903902193').respond(company);

        companies.getCompanyWithCnpj("2903902193").then(function(response) {
            response.data.should.be.deep.equal(company);
        });

        $httpBackend.flush();
    });
});
