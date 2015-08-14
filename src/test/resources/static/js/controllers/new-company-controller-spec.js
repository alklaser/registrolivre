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

    it('hasErrors() should be true when the server returns anything other than 200', function() {
      var expectedResponse = 500;
      var company = { 
          cnpj: "231231",
          name: "Example Company"
      };
      var stub = sinon.stub();
      stub.withArgs(company).returns(expectedResponse);
      var controller = $controller('NewCompanyController', { $scope: $scope, companies: { newCompany: stub } });
      controller.createCompany(company);
      var response = controller.hasErrors();
      response.should.be.true;
    });

    it('hasErrors() should be false when the server returns 200', function() {
      var expectedResponse = 200;
      var company = {
          cnpj: "231231",
          name: "Example Inc"
      };
      var stub = sinon.stub();
      stub.withArgs(company).returns(expectedResponse);
      var controller = $controller('NewCompanyController', { $scope: $scope, companies: { newCompany: stub }});
      controller.createCompany(company);
      var response = controller.hasErrors();
      response.should.be.false;
    });
});
