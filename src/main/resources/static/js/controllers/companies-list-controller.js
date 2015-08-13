app.controller("CompaniesListController", ["$scope", "companies", function($scope, companies) {

    function init() {
        $scope.companies = [];
        $scope.hasCompanies = false;
        $scope.companiesNotFoundMessage = "Nenhum registro de empresa encontrado.";
    };

    init();

    companies.all().then(function(response){

        if (!_.isEmpty(response)) {
            $scope.companies = response;
            $scope.hasCompanies = true;
            $scope.companiesNotFoundMessage = "";
        }
    });
}]);