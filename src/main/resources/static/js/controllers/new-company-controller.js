app.controller("NewCompanyController", ["$scope", "companies", function($scope, companies) {

  $scope.createCompany = function(company) {
    $scope.response = companies.newCompany(company);
  };

  $scope.hasErrors = function(company) {
    return $scope.response != 200;
  }

  return {
    createCompany: $scope.createCompany,
    hasErrors: $scope.hasErrors
  };

}]);
