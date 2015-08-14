function areAllCharsTheSame(input) {
  for (i = 0; i < input.length - 1; i++) {
    if (input.charAt(i) != input.charAt(i + 1)) {
      return false;
    }
  }

  return true;
}

function validateCNPJ(input) {

  cnpj = input.replace(/[^\d]+/g, '');

  return isCNPJStructureValid(cnpj) &&
         firstDigitValidation(cnpj) &&
         secondDigitValidation(cnpj);
}

var firstDigitValidation = function(cnpj) {
  size = cnpj.length - 2;
  digits = cnpj.substring(size);
  return cnpjDigitCalculation(cnpj, size) == digits.charAt(0);
}

var secondDigitValidation = function(cnpj) {
  size = cnpj.length - 1;
  digits = cnpj.substring(size);
  return CNPJDigitCalculation(cnpj, size) == digits.charAt(0);
}

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
