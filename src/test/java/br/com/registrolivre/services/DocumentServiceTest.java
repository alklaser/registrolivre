package br.com.registrolivre.services;

import br.com.registrolivre.models.Company;
import br.com.registrolivre.models.Document;
import br.com.registrolivre.repository.DocumentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DocumentServiceTest {
    private DocumentService documentService;

    @Mock
    DocumentRepository documentRepository;

    @Before
    public void setUp() {
        initMocks(this);
        documentService = new DocumentService(documentRepository);
    }

    @Test
    public void shouldSaveDocument() {
        Document document = new Document.Builder()
                .withCompany(new Company.Builder()
                        .withCnpj("cnpj")
                        .withTradeName("trade name")
                        .build()
                )
                .withUrl("url")
                .build();
        when(documentRepository.save(document)).thenReturn(document);
        documentService.save(document);
        verify(documentRepository).save(document);
    }
}
