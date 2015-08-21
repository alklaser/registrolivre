app.directive("emptyFieldValidation", [function() {
  return {
    link: function(scope, element, attr, ctrl) {
      var inputText = element.find('.form-control');

      scope.validate = function(){
        element.removeClass('has-error has-success');
        if(inputText.val().length > 0) {
          element.addClass('has-success');
        } else {
          element.addClass('has-error');
        }
      };
    }
  }
}]);
