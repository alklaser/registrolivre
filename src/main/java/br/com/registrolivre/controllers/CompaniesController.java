package br.com.registrolivre.controllers;

import br.com.registrolivre.models.Company;
import br.com.registrolivre.repository.CompanyRepository;
import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log4j
@NoArgsConstructor
@Controller
public class CompaniesController {

    private CompanyRepository companyRepository;

    @Autowired
    public CompaniesController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<Company> saveCompany(@RequestBody CompanyRepresentation companyRepresentation) {
        try {
            Company company = companyRepresentation.toModel();
            companyRepository.save(company);
            return new ResponseEntity<Company>(HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException) {
            log.error("Could not save company - one or more arguments were null", illegalArgumentException);
            return new ResponseEntity<Company>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
