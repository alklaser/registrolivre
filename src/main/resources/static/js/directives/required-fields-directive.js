app.directive("requiredFieldValidation", [function() {

  return {
    link: function(scope, element, attr, ctrl) {


    var checkIfButtonIsEnabled = function() {
      var requiredElements = element.find('.required');
      var myElements = element.find('.has-success');
      var button = element.find("#btn-submit")[0];
      if(requiredElements.length == myElements.length) {
        button.disabled = false;
      } else {
        button.disabled = true;
      }
    }

    scope.$watch(function () {
       return element.html();
      }, checkIfButtonIsEnabled);
    }
  };
}]);
