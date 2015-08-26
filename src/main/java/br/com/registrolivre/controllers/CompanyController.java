package br.com.registrolivre.controllers;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import br.com.registrolivre.models.Company;
import br.com.registrolivre.services.CompanyService;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Log4j
@NoArgsConstructor
@RestController
public class CompanyController {

    private CompanyService companyService;
    private Validator validator;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody CompanyRepresentation companyRepresentation) {
        try {
            Company company = new Company.Builder().toModel(companyRepresentation);
            Set<ConstraintViolation<Company>> violations = validator.validate(company);
            if (violations.isEmpty()) {
                companyService.save(company);
                return new ResponseEntity<>(HttpStatus.OK);

            } else {
                log.error("Violations found: " + violations.toString());
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            }
        } catch (IllegalArgumentException illegalArgumentException) {
            log.error("Could not save company - one or more arguments were null", illegalArgumentException);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/buscar-por-cnpj", method = RequestMethod.GET)
    public ResponseEntity getCompanyByCnpj(@RequestParam String cnpj) {
        Company company = companyService.getByCnpj(cnpj);
        if (company == null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        CompanyRepresentation companyRepresentation = new CompanyRepresentation.Builder().toRepresentation(company);
        return ResponseEntity.ok(companyRepresentation);
    }
}
