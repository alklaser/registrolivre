app.controller("NewCompanyController", ["$scope", "companies", "messages", function($scope, companies, messages) {

  $scope.createCompany = function(company) {
    var formattedCnpj = formatCnpj(company.cnpj);
    company.cnpj = formattedCnpj;
    companies.newCompany(company).then(function(response) {
           messages.showSuccess("Empresa criada com sucesso.", ".messages-container");
        }, function(response) {
           messages.showDanger("Ocorreu um erro na criação da empresa, tente novamente.", ".messages-container");
        });
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
  };

}]);
