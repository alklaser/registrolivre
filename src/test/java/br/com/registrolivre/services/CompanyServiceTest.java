package br.com.registrolivre.services;

import br.com.registrolivre.models.Company;
import br.com.registrolivre.repository.CompanyRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;

    private CompanyService companyService;

    @Before
    public void setUp() {
        initMocks(this);
        companyService = new CompanyService(companyRepository);
    }

    @Test
    public void shouldSaveCompanyTest() {
        Company company = new Company.Builder()
                .withCnpj("cnpj")
                .withTradeName("trade name")
                .build();

        when(companyRepository.save(company)).thenReturn(company);

        companyService.save(company);
        verify(companyRepository).save(company);
    }
}