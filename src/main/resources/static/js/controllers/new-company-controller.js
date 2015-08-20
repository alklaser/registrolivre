app.controller("NewCompanyController", ["$scope", "$document", "companies", "messages", function($scope, $document, companies, messages) {

  $scope.createCompany = function(company) {
    companies.newCompany(company).then(function(response) {
           messages.showSuccess("Empresa criada com sucesso.");
           $scope.resetForm();
        }, function(response) {
           messages.showDanger("Ocorreu um erro na criação da empresa, tente novamente.");
        });
    }

  $scope.resetForm = function() {
    $scope.company = {};
    $document.find(".has-feedback").removeClass("has-error has-success");
    $document.find("#btn-submit").attr("disabled", true);
  }
  return {
    createCompany: $scope.createCompany,
  };

}]);
