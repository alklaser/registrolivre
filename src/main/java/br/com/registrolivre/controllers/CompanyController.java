package br.com.registrolivre.controllers;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import br.com.registrolivre.models.Company;
import br.com.registrolivre.services.CompanyService;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Optional;
import java.util.Set;

import static javax.validation.Validation.buildDefaultValidatorFactory;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.*;

@Log4j
@NoArgsConstructor
@RestController
@FieldDefaults(level = PRIVATE)
public class CompanyController {

    CompanyService companyService;
    Validator validator;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody CompanyRepresentation companyRepresentation) {
        try {
            Company company = new Company.Builder().toModel(companyRepresentation);
            Set<ConstraintViolation<Company>> violations = validator.validate(company);
            if (violations.isEmpty()) {
                companyService.save(company);
                return new ResponseEntity<>(OK);

            } else {
                log.error("Violations found: " + violations.toString());
                return new ResponseEntity<>(BAD_REQUEST);

            }
        } catch (IllegalArgumentException illegalArgumentException) {
            log.error("Could not save company - one or more arguments were null", illegalArgumentException);
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/buscar-por-cnpj", method = RequestMethod.GET)
    public ResponseEntity getCompanyByCnpj(@RequestParam String cnpj) {
        Optional<Company> company = Optional.ofNullable(companyService.getByCnpj(cnpj));
        if (!company.isPresent()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        CompanyRepresentation companyRepresentation = new CompanyRepresentation.Builder().toRepresentation(company.get());
        return ResponseEntity.ok(companyRepresentation);
    }
}
