package br.com.registrolivre.services;

import br.com.registrolivre.models.Document;
import br.com.registrolivre.repository.DocumentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocumentService {
    DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public void save(Document document) {
        documentRepository.save(document);
    }
}
