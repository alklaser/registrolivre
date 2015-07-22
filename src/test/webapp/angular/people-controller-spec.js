describe("People Controller", function() {
    var $rootScope, $scope, $controller;

    beforeEach(module('registro-livre'));
    beforeEach(inject(function($injector) {
        $rootScope = $injector.get('$rootScope');
        $scope = $rootScope.$new();
        $controller = $injector.get('$controller');

        $controller('PeopleController', {
            '$scope': $scope
        });
    }));

    it("add a person", function() {
        $scope.add('Person 1');
        $scope.add('Person 2');
        $scope.people.should.be.deep.equal([{ name: "Person 1", selected: false }, { name: 'Person 2', selected: false }]);
    });

    it("clear person item", function () {
        $scope.add('Person 1');
        $scope.clear();
        $scope.people.should.be.deep.equal([]);
    });

    it("selected people", function () {
        $scope.add("Person 1");
        $scope.add("Person 2");

        $scope.people[0].selected = true;
        $scope.$apply();

        $scope.peopleSelected.should.be.deep.equal(["Person"]);
    });
});