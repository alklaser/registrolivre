package br.com.registrolivre.models;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import br.com.registrolivre.controllers.representations.DocumentRepresentation;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DocumentTest {

    @Test
    public void shouldConvertRepresentationToDocument() throws Exception {
        CompanyRepresentation companyRepresentation = new CompanyRepresentation.Builder()
                .withId(1L)
                .withCnpj("cnpj")
                .withTradeName("trade name")
                .build();


        DocumentRepresentation documentRepresentation = new DocumentRepresentation(companyRepresentation, "s3Etag");
        Document document = new Document.Builder().toModel(documentRepresentation);

        assertThat(document.getS3Etag(), is(documentRepresentation.getS3Etag()));
        assertThat(document.getCompany().getCnpj(), is(documentRepresentation.getCompany().getCnpj()));
    }
}
