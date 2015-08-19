describe("Factory: messages", function() {

    var messages;
    var $document;

    beforeEach(function() {
        var doc = document.implementation.createHTMLDocument();
        $document = angular.element(doc);


        module(function($provide) {
            $provide.value('$document', $document);
        });
    });

    beforeEach(module('registro-livre'));
    beforeEach(inject(function($injector) {

        messages = $injector.get('messages');
    }));

    it("displays success message on given container", function() {
        $document.find('body').append('<div class="message-container">lalala</div>');
        messages.showSuccess("teste", '.message-container');
        var htmlResponse = $document[0].querySelectorAll('.message-container');
        var response = angular.element(htmlResponse).html();
        expect(response).to.contain("teste");
        expect(response).to.contain("alert-success");
    });
});