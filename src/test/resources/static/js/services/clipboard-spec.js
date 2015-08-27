describe("clipboard", function () {
  var clipboard;

  beforeEach(module("registro-livre"));

  beforeEach(inject(function($injector) {
    clipboard = $injector.get("clipboard");
  }));

  describe("#handlePaste", function () {
    it("updates dom node value with clipboard event data", function () {
      var node = {
        val: sinon.spy()
      };

      var event = {
        originalEvent: {
          clipboardData: {
            getData: _.identity
          }
        }
      };

      clipboard.handlePaste(node)(event);
      expect(node.val).to.have.been.calledWith("text");
    });
  });
});
