describe("Factory: states-and-cities", function() {

    var statesAndCities;

beforeEach(module('registro-livre'));

    beforeEach(inject(function($injector) {
        statesAndCities = $injector.get('statesAndCities');
    }));


    it("should get states when using getStates.", function() {
        var states = [
                ['AC','Acre'],['AL','Alagoas'],['AM','Amazonas'],['AP','Amapá'],['BA','Bahia'],
                ['CE','Ceará'],['DF','Distrito Federal'],['ES','Espírito Santo'],['GO','Goiás'],['MA','Maranhão'],['MG','Minas Gerais'],
                ['MS','Mato Grosso do Sul'],['MT','Mato Grosso'],['PA','Pará'],['PB','Paraíba'],['PE','Pernambuco'],['PI','Piauí'],
                ['PR','Paraná'],['RJ','Rio de Janeiro'],['RN','Rio Grande do Norte'],['RO','Rondônia'],['RR','Roraima'],['RS','Rio Grande do Sul'],
                ['SC','Santa Catarina'],['SP','São Paulo'],['SE','Sergipe'],['TO','Tocantins']
            ];
        var result = statesAndCities.getStates();
        result.should.be.deep.equal(states);
    });

     it("should get city from DF when using getCities(DF).", function() {
     var citiesFromDF = ['Brasília'];
      var result = statesAndCities.getCitiesByState('DF');
      result.should.be.deep.equal(citiesFromDF);
     });

     it("should get an empty list when using getCities with an invalid state", function() {
        var emptyList = [];
        var result = statesAndCities.getCitiesByState('OI');
        result.should.be.deep.equal(emptyList);
     });
});