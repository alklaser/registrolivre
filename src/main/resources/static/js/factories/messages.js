app.factory("messages", ["$document", "$templateCache", function($document, $templateCache) {

  function parseHtml(message, type) {
    return '<div class="alert alert-' + type + ' alert-dismissible" role="alert">' +
          '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
          message + '</div>';

  }

  function show(message, type) {
    var alert = parseHtml(message, type);

    /* O método .find() do Angular não encontra classes ou IDs, apenas atributos */
    var container = $document[0].querySelector(".messages-container");
    angular.element(container).html(alert);
  };

  function clear() {
    var container = $document[0].querySelector(".messages-container");
    angular.element(container).html('');
  }


  function showSuccess(message) {
    show(message, "success");
  }

  function showWarning(message) {
    show(message, "warning")
  }

   function showDanger(message) {
     show(message, "danger");
   }

   function showInfo(message) {
     show(message, "info");
   }

  return {
    showSuccess: showSuccess,
    showWarning: showWarning,
    showDanger: showDanger,
    showInfo: showInfo,
    clear: clear,
  }
}]);
