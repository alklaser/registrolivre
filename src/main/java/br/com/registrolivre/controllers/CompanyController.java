package br.com.registrolivre.controllers;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import br.com.registrolivre.models.Company;
import br.com.registrolivre.repository.CompanyRepository;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.springframework.http.ResponseEntity.ok;

@Log4j
@NoArgsConstructor
@RestController
public class CompanyController {

    private CompanyRepository companyRepository;
    private Validator validator;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity saveCompany(@RequestBody CompanyRepresentation companyRepresentation) {
        try {
            Company company = new Company.Builder().toModel(companyRepresentation);
            Set<ConstraintViolation<Company>> violations = validator.validate(company);
            if (violations.isEmpty()) {
                companyRepository.save(company);
            } else {
                log.error("Violations found: " + violations.toString());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException) {
            log.error("Could not save company - one or more arguments were null", illegalArgumentException);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
