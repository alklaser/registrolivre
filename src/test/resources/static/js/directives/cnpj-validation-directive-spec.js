describe('MyApp Tabs', function() {
  var elm, scope;

  scope = {
    company: {
        cnpj: '38.366.166/0001-07'
    }
  };

  beforeEach(module('registro-livre'));

  beforeEach(inject(function($rootScope, $compile) {
    elm = angular.element(
      '<div cnpj-validation class="form-group has-feedback " id="cnpj-group" >' +
         '<label class="control-label">CNPJ <abbr class="cor-vermelha" alt="Preenchimento obrigatório" title="Preenchimento obrigatório">*</abbr></label>' +
         '<input class="form-control required" ng-model="company.cnpj"  type="text" name="empresa.cnpj" id="cnpj"' +
         'autocomplete="off" ui-mask="?99.999.999/9999-99" model-view-value="true" required/>' +
      '</div>');
    scope = $rootScope;
    $compile(elm)(scope);
    scope.$digest();
  }));

  it('should create clickable titles', function() {
    var input = elm.find('input');
    input.triggerHandler('blur');
//    console.log(elm.html());
//    console.log(input.hasClass('has-success'));
//    expect(input.hasClass('has-success')).toEqual(true);
  });

});