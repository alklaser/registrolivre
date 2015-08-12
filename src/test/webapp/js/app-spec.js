describe("App routes test", function() {

    it('should return document-upload-controller when entering /add/document page', function() {
        module('registro-livre');
        inject(function($route) {
            $route.routes['/add/document'].controller.should.equal('../js/controllers/document-upload-controller');
        });
    });
});