package br.com.registrolivre.controllers;

import br.com.registrolivre.controllers.representations.DocumentRepresentation;
import br.com.registrolivre.models.Company;
import br.com.registrolivre.models.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class DocumentControllerTest  {

    @Mock
    private Company company;

    private DocumentController controller;

    private Document document;

    private DocumentRepresentation documentRepresentation;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        controller = new DocumentController();
        documentRepresentation = new DocumentRepresentation(1L, "0001");
        document = documentRepresentation.toModel();
    }

    @Test
    public void shouldGetDocumentUrl() throws Exception {
        ResponseEntity response = controller.getDocumentUrl(documentRepresentation);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}