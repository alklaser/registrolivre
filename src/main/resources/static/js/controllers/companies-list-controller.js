app.controller("CompaniesListController", ["$scope", "$filter", "ngTableParams", "companies", function($scope, $filter, ngTableParams, companies) {

    function init() {
        $scope.companies = [];
        $scope.hasCompanies = false;
        $scope.companiesNotFoundMessage = "Nenhum registro de empresa encontrado.";
    };

    function configureTableParams() {
        $scope.tableParams = new ngTableParams({
            page: 1,
            count: 1000,
            sorting: {
                tradeName: 'asc'
            }
        }, {
            total: $scope.companies.length,
            getData: function($defer, params) {
                var orderedData = params.sorting() ? $filter('orderBy')($scope.companies, params.orderBy()) : $scope.companies;
                $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
            }
        });
    };

    init();

    companies.all().then(function(response){
        if (!_.isEmpty(response)) {
            $scope.companies = response;
            $scope.hasCompanies = true;
            $scope.companiesNotFoundMessage = "";

            configureTableParams();
        }
    });
}]);