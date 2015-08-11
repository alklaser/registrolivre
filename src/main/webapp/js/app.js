var app = angular.module("registro-livre", ['ngRoute'])

app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when("/add/document", {
                templateUrl: 'partials/example.html',
                controller: '../js/controllers/companies-list-controller'
            }).
            otherwise({
                redirectTo: '/add/document'
            });
    }]);
