package br.com.registrolivre.services;

import br.com.registrolivre.models.Company;
import br.com.registrolivre.repository.CompanyRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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

    @Test
    public void shouldReturnAllRegisteredCompanies() {
        List<Company> companies = getCompanies();

        when(companyRepository.findAll()).thenReturn(companies);

        companyService.findAll();
        verify(companyRepository).findAll();
    }

    @Test
    public void shouldReturnExistingCompanyWhenGetCompanyByCNPJ() throws Exception {
        Company company = new Company.Builder()
                .withCnpj("cnpj")
                .withTradeName("trade name")
                .build();

        when(companyRepository.getByCnpj("cnpj")).thenReturn(company);
        Company resultingCompany = companyService.getByCnpj("cnpj");

        assertThat(resultingCompany, is(company));
    }

    private List<Company> getCompanies() {
        Company company = new Company.Builder()
                .withCnpj("cnpj")
                .withTradeName("trade name")
                .build();

        List<Company> companies = new ArrayList<Company>();
        companies.add(company);
        return companies;
    }
}