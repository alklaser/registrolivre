app.factory("companies", ["$http", function($http) {
    function all() {
        return $http.get('/companies').then(function(response) {
            return response.data;
        });
    };

    return {
        all: all
    }
}]);