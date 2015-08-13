app.controller("NewCompanyController", ["$scope", "NewCompanyFactory", function($scope, newCompanyFactory) {
  var createCompany = function(company) {
    newCompanyFactory.postNewCompany(company);
  };

  return {
    createCompany: createCompany
  };
}]);
