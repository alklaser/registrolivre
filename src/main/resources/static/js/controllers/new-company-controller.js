app.controller("NewCompanyController", ["$scope", "$document", "companies", "messages", function($scope, $document, companies, messages) {

  $scope.createCompany = function(company) {
    companies.newCompany(company).then(function(response) {
           messages.showSuccess("Empresa <strong>"+ company.tradeName +"</strong> foi cadastrada.");
           $scope.resetForm();
        }, function(response) {
           messages.showDanger("Ocorreu um erro no sistema, por favor tente novamente.");
        });
    }

  $scope.resetForm = function() {
    $scope.company = {};
    $document.find(".has-feedback").removeClass("has-error has-success");
    $document.find("#btn-submit").attr("disabled", true);
  }

  $scope.clearForm = function() {
    messages.clear();
    $scope.resetForm();
  }

  return {
    createCompany: $scope.createCompany,
  };

}]);
