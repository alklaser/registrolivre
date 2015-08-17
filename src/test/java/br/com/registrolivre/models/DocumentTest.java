package br.com.registrolivre.models;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import br.com.registrolivre.controllers.representations.DocumentRepresentation;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DocumentTest {

    @Test
    public void shouldConvertRepresentationToDocument() throws Exception {
        CompanyRepresentation companyRepresentation = new CompanyRepresentation.Builder()
                .withId(1L)
                .withCnpj("cnpj")
                .withTradeName("trade name")
                .build();


        DocumentRepresentation documentRepresentation = new DocumentRepresentation(companyRepresentation, "url");
        Document document = new Document.Builder().toModel(documentRepresentation);

        assertThat(document.getUrl(), is(documentRepresentation.getUrl()));
        assertThat(document.getCompany().getCnpj(), is(documentRepresentation.getCompany().getCnpj()));
    }
}
