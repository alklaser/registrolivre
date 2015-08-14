package br.com.registrolivre.controllers.representations;

import br.com.registrolivre.models.Company;
import br.com.registrolivre.models.Document;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DocumentRepresentationTest {

    private CompanyRepresentation companyRepresentation;
    private Company company;
    private String s3Etag = "s3Etag";

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
        Document document = new Document(company, s3Etag);
        DocumentRepresentation documentRepresentation = new DocumentRepresentation.Builder()
                .toRepresentantion(document);

        assertThat(documentRepresentation.getCompany().getCnpj(), is(document.getCompany().getCnpj()));
        assertThat(documentRepresentation.getS3Etag(), is(document.getS3Etag()));
    }
}
