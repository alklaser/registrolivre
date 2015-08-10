package br.com.registrolivre.controllers;

import br.com.registrolivre.models.Empresa;
import br.com.registrolivre.repository.EmpresaRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmpresaController {

    EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public ResponseEntity<String> saveEmpresa(Empresa empresa) {
        try {
            empresaRepository.save(empresa);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
