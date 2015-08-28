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

    it('Should get states from states-and-cities service', function(){
        var spy = sinon.spy();
        var $scope = {};
        var controller = $controller('NewCompanyController', { $scope: $scope, statesAndCities: { getStates: spy }});

        controller.getStates();

        spy.should.have.been.called.once;
    });

    it('Should get cities from states-and-cities service', function() {
        var spy = sinon.spy();
        var state =  "RS";
        var $scope = {
            company: {
                UF: state
            }
        };
        var controller = $controller('NewCompanyController', { $scope: $scope, statesAndCities: { getCitiesByState: spy }});

        controller.loadCities();
        assert(spy.calledWith(state));
    });

    it("Should clear form and messages when hit reset form button", function() {
        var clearMessages = sinon.spy();

        var controller = $controller('NewCompanyController', { $scope: $scope, messages: { clear: clearMessages }});

        controller.clearForm();
        clearMessages.should.have.been.called.once;
        $scope.company.should.be.deep.equal({});

    });

});
