package br.com.registrolivre.controllers;

import br.com.registrolivre.controllers.representations.CompanyRepresentation;
import br.com.registrolivre.models.Company;
import br.com.registrolivre.repository.CompanyRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CompanyControllerTest {

    @Mock
    private CompanyRepository companyRepository;

    private CompanyRepresentation companyRepresentation;

    private CompanyController controller;

    private Company company;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        controller = new CompanyController(companyRepository);
        companyRepresentation = new CompanyRepresentation(1L, "79.064.650/0001-50", "fancy name");
        company = companyRepresentation.toModel();
    }

    @Test
    public void shouldCallRepository() throws Exception {
        controller.saveCompany(companyRepresentation);
        verify(companyRepository).save(company);
    }

    @Test
    public void shouldReturnOKIfSuccess() throws Exception {
        when(companyRepository.save(company)).thenReturn(company);
        ResponseEntity response = controller.saveCompany(companyRepresentation);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void shouldReturnInternalServerError() throws Exception {
        when(companyRepository.save(company)).thenThrow(IllegalArgumentException.class);
        ResponseEntity response = controller.saveCompany(companyRepresentation);
        assertThat(response.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Test
    public void shouldValidateCNPJ() throws Exception {
        companyRepresentation = new CompanyRepresentation("123 invalid cnpj", "another fancy name");
        controller.saveCompany(companyRepresentation);
        verifyZeroInteractions(companyRepository);
    }
}