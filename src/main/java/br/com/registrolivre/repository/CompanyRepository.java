package br.com.registrolivre.repository;

import br.com.registrolivre.models.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company getByCnpj(String cnpj);
}
