app.controller("CompaniesListController", ["$scope", "companies", function($scope, companies) {
    $scope.companies = [];

    companies.all().then(function(response){
        $scope.companies = response;
    });
}]);