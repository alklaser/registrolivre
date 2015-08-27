var app = angular.module("registro-livre", ["ngRoute","ui.mask", "ngTable"])

app.config(["$routeProvider",
    function($routeProvider) {
        $routeProvider
          .when("/empresas", {
            templateUrl: "partials/companies.html",
            controller: "CompaniesListController"
          })
          .when("/cadastro", {
            templateUrl: "partials/new-company.html",
            controller: "NewCompanyController"
          })
          .otherwise({
            redirectTo: "/"
          });
    }]);
