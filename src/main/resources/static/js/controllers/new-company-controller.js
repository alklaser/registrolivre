app.controller("NewCompanyController", ["$scope", "companies", function($scope, companies) {

  $scope.createCompany = function(company) {
    var formattedCnpj = formatCnpj(company.cnpj);
    company.cnpj = formattedCnpj;
    $scope.response = companies.newCompany(company);
  };

  $scope.hasErrors = function(company) {
    if ($scope.response != undefined) {
      return $scope.response != 200;
    }
  }

  var formatCnpj = function(value) {

    var formattedCnpj = "";
    for (var index = 0; index <= value.length - 1; index++) {
      if (index == 2 || index == 5) {
        formattedCnpj += '.';
      }
      if (index == 8) {
        formattedCnpj += '/';
      }
      if (index == 12) {
        formattedCnpj += '-';
      }
      formattedCnpj += value[index];
    }

    return formattedCnpj;

  };

  return {
    createCompany: $scope.createCompany,
    hasErrors: $scope.hasErrors
  };

}]);
