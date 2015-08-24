package br.com.registrolivre.models;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import br.com.registrolivre.controllers.representations.DocumentRepresentation;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompanyTest {

    private static final String CNPJ = "1234567";
    private static final String TRADE_NAME = "fancy name";
    private static final String COMPANY_NAME = "fancy name Ltda.";
    private static final Set<DocumentRepresentation> DOCUMENTS = new HashSet<>();

    @Test
    public void shouldConvertRepresentationToCompany() throws Exception {
        CompanyRepresentation representation = new CompanyRepresentation(1L, CNPJ, TRADE_NAME, COMPANY_NAME, DOCUMENTS, null);
        Company company = new Company.Builder().toModel(representation);

        assertThat(company.getCnpj(), is(representation.getCnpj()));
        assertThat(company.getTradeName(), is(representation.getTradeName()));
    }
}
