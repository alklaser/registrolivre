package br.com.registrolivre.controllers;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import br.com.registrolivre.models.Company;
import br.com.registrolivre.services.AWSService;
import br.com.registrolivre.services.CompanyService;
import com.amazonaws.services.s3.AmazonS3;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import static lombok.AccessLevel.*;

@Log4j
@NoArgsConstructor
@RestController
@FieldDefaults(level = PRIVATE)
public class CompanyController {

    CompanyService companyService;
    Validator validator;
    AWSService awsService;

    @Autowired
    public CompanyController(CompanyService companyService, AWSService awsService) {
        this.companyService = companyService;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        this.awsService = awsService;
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity saveCompany(@RequestBody CompanyRepresentation companyRepresentation, @RequestParam MultipartFile multipartFile) throws IOException {
        try {
            Company company = new Company.Builder().toModel(companyRepresentation);
            Set<ConstraintViolation<Company>> violations = validator.validate(company);
            if (violations.isEmpty()) {
                saveFor(company);
                String documentUrl = uploadDocumentFor(multipartFile);
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

    private void saveFor(Company company) {
        companyService.save(company);
    }

    private String uploadDocumentFor(MultipartFile multipartFile) throws IOException {
        AmazonS3 client = AWSService.client();
        String fileName = multipartFile.getName();
        return awsService.uploadToS3(client, fileName);
    }
}
