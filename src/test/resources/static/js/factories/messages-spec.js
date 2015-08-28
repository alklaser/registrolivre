describe("Factory: messages", function() {

    var messages;
    var $document;
    var MESSAGE_TEST = "test";
    beforeEach(function() {
        var doc = document.implementation.createHTMLDocument();
        $document = angular.element(doc);
        $document.find('body').append('<div class="messages-container"></div>');

        module(function($provide) {
            $provide.value('$document', $document);
        });
    });

    beforeEach(module('registro-livre'));
    beforeEach(inject(function($injector) {

        messages = $injector.get('messages');
    }));

    it("should displays success message on given container", function() {
        messages.showSuccess(MESSAGE_TEST);
        response = getResponse();
        assertMessageWithType(response, MESSAGE_TEST, "alert-success");
    });

    it("should displays warning message on given container", function() {
        messages.showWarning(MESSAGE_TEST);
        response = getResponse();
        assertMessageWithType(response, MESSAGE_TEST, "alert-warning");
    });

    it("should displays danger message on given container", function() {
        messages.showDanger(MESSAGE_TEST);
        response = getResponse();
        assertMessageWithType(response, MESSAGE_TEST, "alert-danger");

    });

    it("should displays info message on given container", function() {
        messages.showInfo(MESSAGE_TEST);
        response = getResponse();
        assertMessageWithType(response, MESSAGE_TEST, "alert-info");
    });

    it("should clear message on give container", function (){
        messages.showInfo(MESSAGE_TEST);
        messages.clear();
        response = getResponse();
        response.should.be.deep.equal("");
    });

    function getResponse() {
        var htmlResponse = $document[0].querySelectorAll('.messages-container');
        return angular.element(htmlResponse).html();
    }

    function assertMessageWithType(response, msg, type) {
        expect(response).to.contain(msg);
        expect(response).to.contain(type);
    }
});