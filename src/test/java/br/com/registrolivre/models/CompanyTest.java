package br.com.registrolivre.models;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompanyTest {

    private static final String CNPJ = "1234567";
    private static final String TRADE_NAME = "fancy name";

    @Test
    public void shouldConvertRepresentationToCompany() throws Exception {
        CompanyRepresentation companyRepresentation = new CompanyRepresentation(CNPJ, TRADE_NAME);
        Company company = new Company.Builder().toModel(companyRepresentation);

        assertThat(company.getCnpj(), is(companyRepresentation.getCnpj()));
        assertThat(company.getTradeName(), is(companyRepresentation.getTradeName()));
    }
}
