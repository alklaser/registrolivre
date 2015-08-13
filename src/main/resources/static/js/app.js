var app = angular.module("registro-livre", ['ngRoute'])

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
            .otherwise({
                redirectTo: '/'
            });
    }]);
