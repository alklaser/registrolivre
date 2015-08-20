app.directive("cnpjValidation", ["companies", function(companies) {

  return {
    link: function(scope, element, attr, ctrl) {
      var inputText = element.find('.form-control');

      scope.showUniqueCnpjMessage = function(){
        console.log(scope.cnpjAlreadyExists);
        return scope.cnpjAlreadyExists && element.hasClass("has-error");
      }

      inputText.on("blur", function() {
        scope.cnpjAlreadyExists = false;
        element.removeClass('has-error has-success');
        if(!validateCNPJ(inputText.val())) {
            element.addClass('has-error');
        };
        scope.$digest();
      });

      var validateCNPJ = function(input) {
        cnpj = input.replace(/[^\d]+/g, '');

        return isCNPJStructureValid(cnpj) &&
          firstDigitValidation(cnpj) &&
          secondDigitValidation(cnpj) &&
          verifyUniqueCnpj(input);
      };

      var verifyUniqueCnpj = function(cnpj) {
        scope.verifingCnpj = true;

        companies.getCompanyWithCnpj(cnpj).then(function(response) {
            scope.verifingCnpj = false;
            if (!response.data) {
                element.addClass('has-success');
            } else {
                scope.cnpjAlreadyExists = true;
                element.addClass('has-error');
            }
        });
        return true;
      }

      var isCNPJStructureValid = function(cnpj) {
        if (cnpj == '')
          return false;

        if (cnpj.length != 14)
          return false;

        if (areAllCharsTheSame(cnpj))
          return false;

        return true;
      };

      var areAllCharsTheSame = function(input) {
        for (i = 0; i < input.length - 1; i++) {
          if (input.charAt(i) != input.charAt(i + 1)) {
            return false;
          }
        }

        return true;
      };

      var firstDigitValidation = function(cnpj) {
        size = cnpj.length - 2;
        digits = cnpj.substring(size);
        return cnpjDigitCalculation(cnpj, size) == digits.charAt(0);
      };

      var secondDigitValidation = function(cnpj) {
        size = cnpj.length - 1;
        digits = cnpj.substring(size);
        return cnpjDigitCalculation(cnpj, size) == digits.charAt(0);
      };

      var cnpjDigitCalculation = function(cnpj, size) {
        numbers = cnpj.substring(0, size);
        sum = 0;
        pos = size - 7;
        for (i = size; i >= 1; i--) {
          sum += numbers.charAt(size - i) * pos--;
          if (pos < 2)
            pos = 9;
        }
        return sum % 11 < 2 ? 0 : 11 - sum % 11;
      };
    },
  }

}]);
