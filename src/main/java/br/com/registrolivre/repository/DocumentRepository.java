package br.com.registrolivre.repository;

import br.com.registrolivre.models.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
