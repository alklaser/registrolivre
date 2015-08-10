package br.com.registrolivre.controllers;

import br.com.registrolivre.models.Company;
import br.com.registrolivre.repository.CompanyRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyController {

    CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public ResponseEntity<String> saveCompany(Company company) {
        try {
            companyRepository.save(company);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
