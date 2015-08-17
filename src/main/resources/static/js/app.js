var app = angular.module("registro-livre", ['ngRoute', 'ngTable'])

app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider
            .when("/add/document", {
                templateUrl: 'partials/input.html',
                controller: '../js/controllers/document-upload-controller'
            })
            .when("/empresas", {
                templateUrl: 'partials/companies.html',
                controller: 'CompaniesListController'
            })
            .when("/cadastro", {
                templateUrl: 'partials/new-company.html',
                controller: 'NewCompanyController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }]);
