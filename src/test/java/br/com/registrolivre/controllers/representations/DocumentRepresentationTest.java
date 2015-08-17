package br.com.registrolivre.controllers.representations;

import br.com.registrolivre.models.Company;
import br.com.registrolivre.models.Document;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DocumentRepresentationTest {
    private CompanyRepresentation companyRepresentation;
    private Company company;
    private String url = "url";

    @Before
    public void setUp() {
        companyRepresentation = new CompanyRepresentation.Builder()
                .withCnpj("cnpj")
                .withTradeName("trade name")
                .build();

        company = new Company.Builder()
                .withCnpj("cnpj")
                .withTradeName("trade name")
                .build();
    }

    @Test
    public void shouldConvertDocumentToRepresentation() throws Exception {
        Document document = new Document(company, url);
        DocumentRepresentation documentRepresentation = new DocumentRepresentation.Builder()
                .toRepresentantion(document);

        assertThat(documentRepresentation.getCompany().getCnpj(), is(document.getCompany().getCnpj()));
        assertThat(documentRepresentation.getUrl(), is(document.getUrl()));
    }
}
