app.controller("NewCompanyController", ["$scope", "companies", "messages", function($scope, companies, messages) {

  $scope.createCompany = function(company) {
    companies.newCompany(company).then(function(response) {
           messages.showSuccess("Empresa criada com sucesso.", ".messages-container");
        }, function(response) {
           messages.showDanger("Ocorreu um erro na criação da empresa, tente novamente.", ".messages-container");
        });
    }

  return {
    createCompany: $scope.createCompany,
  };

}]);
