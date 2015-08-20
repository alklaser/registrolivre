app.factory("messages", ["$document", "$templateCache", function($document, $templateCache) {

  function parseHtml(message, type) {
    return '<div class="alert alert-' + type + ' alert-dismissible" role="alert">' +
          '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
          message + '</div>';

  }

  function show(message, selector, type) {
    var alert = parseHtml(message, type);

    /* O método .find() do Angular não encontra classes ou IDs, apenas atributos */
    var container = $document[0].querySelector(selector);
    angular.element(container).html(alert);
  };

  function showSuccess(message, selector) {
    show(message, selector, "success");
  }

  function showWarning(message, selector) {
    show(message, selector, "warning")
  }

   function showDanger(message, selector) {
     show(message, selector, "danger");
   }

   function showInfo(message, selector) {
     show(message, selector, "info");
   }

  return {
    showSuccess: showSuccess,
    showWarning: showWarning,
    showDanger: showDanger,
    showInfo: showInfo,
  }
}]);
