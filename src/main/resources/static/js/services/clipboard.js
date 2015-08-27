app.service("clipboard", [
  function() {
    function clipboardData(event) {
      return event.originalEvent.clipboardData.getData("text");
    }

    this.handlePaste = function(domNode) {
      return _.compose(domNode.val, clipboardData);
    };
  }
]);
