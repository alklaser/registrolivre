app.directive("requiredFieldValidation", [function() {

var checkIfButtonIsEnabled = function(element) {
  var requiredElements = element.find('.required');
  var myElements = element.find('.has-success');
  var button = element.find("#btn-submit")[0];
  if(requiredElements.length == myElements.length) {
    button.disabled = false;
  } else {
    button.disabled = true;
  }
}

  return {
    link: function(scope, element, attr, ctrl) {

      var myElements = element.find('.required');
      myElements.on("blur", function() {
          // call my method
          checkIfButtonIsEnabled(element);
      });
    }
  };
}]);
