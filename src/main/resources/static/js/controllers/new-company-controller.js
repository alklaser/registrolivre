app.controller("NewCompanyController", ["$scope", "$document", "companies", "messages", function($scope, $document, companies, messages) {

  $scope.createCompany = function(company) {
    companies.newCompany(company).then(function(response) {
           messages.showSuccess("Empresa criada com sucesso.", ".messages-container");
           resetForm();
        }, function(response) {
           messages.showDanger("Ocorreu um erro na criação da empresa, tente novamente.", ".messages-container");
        });
    }

  $scope.resetForm = function() {
    $scope.company = {};
    $document.find(".has-feedback").removeClass("has-error has-success");
  }
  return {
    createCompany: $scope.createCompany,
  };

}]);
