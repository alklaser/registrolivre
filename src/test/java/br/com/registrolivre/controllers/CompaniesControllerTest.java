package br.com.registrolivre.controllers;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import br.com.registrolivre.models.Company;
import br.com.registrolivre.services.CompanyService;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CompaniesControllerTest {

    @Mock
    CompanyService companyService;

    CompaniesController controller;

    @Before
    public void setUp() {
        initMocks(this);
        this.controller = new CompaniesController(companyService);
    }

    @Test
    public void shouldReturnAllRegisteredCompanies() {
        when(companyService.findAll()).thenReturn(registeredCompanies());
        ResponseEntity<Iterable<CompanyRepresentation>> companies = controller.getCompanies();

        List<CompanyRepresentation> expectedCompanies = new ArrayList<>();
        expectedCompanies.add(new CompanyRepresentation(1L, "first cnpj", "first tradeName"));
        expectedCompanies.add(new CompanyRepresentation(2L, "second cnpj", "second tradeName"));

        assertThat(asList(companies.getBody()).size(), is(asList(expectedCompanies).size()));
        assertThat(Lists.newArrayList(companies.getBody()).get(0).getTradeName(), is("first tradeName"));
        assertThat(Lists.newArrayList(companies.getBody()).get(1).getTradeName(), is("second tradeName"));
        assertThat(companies.getStatusCode(), is(HttpStatus.OK));

        verify(companyService).findAll();
    }

    @Test
    public void shouldReturnInternalServerError() {
        when(companyService.findAll()).thenThrow(IllegalArgumentException.class);
        ResponseEntity response = controller.getCompanies();
        assertThat(response.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private Set<Company> registeredCompanies() {
        Company firstCompany = new Company(1L, "first cnpj", "first tradeName");
        Company secondCompany = new Company(2L, "second cnpj", "second tradeName");
        Set<Company> companies = new HashSet<>();
        companies.add(firstCompany);
        companies.add(secondCompany);
        return companies;
    }
}
