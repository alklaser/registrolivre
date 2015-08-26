package br.com.registrolivre.controllers;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import br.com.registrolivre.models.Company;
import br.com.registrolivre.services.CompanyService;
import com.google.common.collect.Lists;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@Log4j
@NoArgsConstructor
@Controller
public class CompaniesController {

    private CompanyService companyService;

    @Autowired
    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/empresas", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<Iterable<CompanyRepresentation>> getCompanies() {

        try {
            Iterable<Company> registeredCompanies = companyService.findAll();

            List<CompanyRepresentation> companies = Lists.newArrayList(registeredCompanies)
                    .stream()
                    .map(company -> toRepresentation(company))
                    .collect(Collectors.toList());
            return ok(companies);
        } catch (IllegalArgumentException ex) {
            log.error("Error trying to find one or more companies", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private CompanyRepresentation toRepresentation(Company company) {
        return new CompanyRepresentation.Builder().toRepresentation(company);
    }
}
