package br.com.registrolivre.controllers;

import br.com.registrolivre.models.Company;
import br.com.registrolivre.repository.CompanyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompanyControllerTest {

    @Mock
    CompanyRepository companyRepository;
    @Mock
    Company company;

    CompanyController controller;

    @Before
    public void setUp() throws Exception {
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
        assertThat(response, is(HttpStatus.OK));
    }


    @Test
    public void shouldThrowException() throws Exception {
        when(companyRepository.save(company)).thenThrow(Exception.class);
        ResponseEntity<String> response = controller.saveCompany(company);
        assertThat(response, is(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}