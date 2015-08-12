app.factory("companies", ["$http", function($http) {
    function all() {
        return $http.get('/empresas').then(function(response) {
            return response.data;
        });
    };

    return {
        all: all
    }
}]);