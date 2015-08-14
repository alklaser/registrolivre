app.controller("NewCompanyController", ["$scope", "companies", function($scope, companies) {

  $scope.createCompany = function(company) {
    companies.newCompany(company);
  };

  return {
    createCompany: $scope.createCompany
  };

}]);
