package br.com.registrolivre.repository;

import br.com.registrolivre.models.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
}
