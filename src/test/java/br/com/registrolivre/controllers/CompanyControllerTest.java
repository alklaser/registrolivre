package br.com.registrolivre.controllers;

import br.com.registrolivre.models.Company;
import br.com.registrolivre.repository.CompanyRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class CompanyControllerTest {

    @Mock
    CompanyRepository companyRepository;
    @Mock
    Company company;

    CompanyController controller;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        controller = new CompanyController(companyRepository);
    }

    @Test
    public void shouldCallRepository() throws Exception {
        controller.saveCompany(company);
        verify(companyRepository).save(company);
    }

    @Test
    public void shouldReturnOKIfSuccess() throws Exception {
        when(companyRepository.save(company)).thenReturn(company);
        ResponseEntity<String> response = controller.saveCompany(company);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


    @Test
    public void shouldReturnInternalServerError() throws Exception {
        when(companyRepository.save(company)).thenThrow(Exception.class);
        ResponseEntity<String> response = controller.saveCompany(company);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}