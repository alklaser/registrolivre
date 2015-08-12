app.controller("CompaniesListController", ["$scope", "companies", function($scope, companies) {
    $scope.companies = [];

    $scope.companies = [{id: 1, cnpj: "123456", tradeName: "Company One Ltda"}, {id: 2, cnpj: "654321", tradeName: "Company Two, Inc"}];

    //companies.all().then(function(response){
    //    $scope.companies = response;
    //});
}]);