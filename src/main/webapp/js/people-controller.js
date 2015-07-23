angular.module('registro-livre')
    .controller('PeopleController', ['$scope', function ($scope) {

        $scope.people = [];
        $scope.person = "";
        $scope.add = function (name) {
            $scope.people.push({ name: name, selected: false });
        };

        $scope.clear = function () {
            $scope.people = [];
            $scope.person = "";
        };

        $scope.peopleSelected = [];
        $scope.$watch('people|filter:{selected:true}', function (peopleFiltered) {
            $scope.peopleSelected = peopleFiltered.map(function (person) {
                return person.name;
            });
        }, true);
    }]);