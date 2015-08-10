package br.com.registrolivre.controllers;

import br.com.registrolivre.models.Empresa;
import br.com.registrolivre.repository.EmpresaRepository;
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
public class EmpresaControllerTest {

    @Mock
    EmpresaRepository empresaRepository;
    @Mock
    Empresa empresa;

    EmpresaController controller;

    @Before
    public void setUp() throws Exception {
        controller = new EmpresaController(empresaRepository);
    }

    @Test
    public void shouldCallRepository() throws Exception {
        controller.saveEmpresa(empresa);
        verify(empresaRepository).save(empresa);
    }

    @Test
    public void shouldReturnOKIfSuccess() throws Exception {
        when(empresaRepository.save(empresa)).thenReturn(empresa);
        ResponseEntity<String> response = controller.saveEmpresa(empresa);
        assertThat(response, is(HttpStatus.OK));
    }


    @Test
    public void shouldThrowException() throws Exception {
        when(empresaRepository.save(empresa)).thenThrow(Exception.class);
        ResponseEntity<String> response = controller.saveEmpresa(empresa);
        assertThat(response, is(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}