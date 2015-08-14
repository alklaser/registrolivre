var RegistroLivre = RegistroLivre || {};

RegistroLivre.Mascaras = function mascaras(){

  var mascararCnpj = function mascararCnpj(cnpj){mascararCnpj
      cnpj.mask("99.999.999/9999-99");
    }

  return {
      mascararCnpj : mascararCnpj
    }
}

var mascaras = new RegistroLivre.Mascaras();



