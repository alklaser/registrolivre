app.directive("initializeTooltip", ["$timeout", function($timeout) {
  return {
    link: function(scope, element, attr, ctrl) {

      if (scope.$last){
        $timeout(function() {
           angular.element('[data-toggle="tooltip"]').tooltip();
        }, 300);

      }

    }
  }
}]);
