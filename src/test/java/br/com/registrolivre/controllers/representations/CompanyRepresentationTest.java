package br.com.registrolivre.controllers.representations;

import br.com.registrolivre.models.Company;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompanyRepresentationTest {

    private static final String CNPJ = "1234567";
    private static final String TRADE_NAME = "fancy name";

    @Test
    public void shouldConvertRepresentationToCompany() throws Exception {
        Company company = new Company(CNPJ, TRADE_NAME);
        CompanyRepresentation companyRepresentation = new CompanyRepresentation(CNPJ, TRADE_NAME);
        assertThat(companyRepresentation.toModel(), is(company));
    }
}