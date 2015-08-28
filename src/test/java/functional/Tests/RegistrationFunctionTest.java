package functional.Tests;

import functional.pageObject.CompanyListPageObject;
import functional.pageObject.NewCompanyPageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegistrationFunctionTest {
    static WebDriver driver;
    private NewCompanyPageObject newCompanyPageObject;
    private CompanyListPageObject companyListPageObject;

    @Before
    public void setUp() throws Exception {

        driver = new FirefoxDriver();
        newCompanyPageObject = new NewCompanyPageObject(driver);
        companyListPageObject = new CompanyListPageObject (driver);


       // newCompanyPageObject.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @Test
    public void shouldCreateNewCompany() {
        newCompanyPageObject.visit();
        newCompanyPageObject.fillInCnpj("30.883.835/0001-06");
        newCompanyPageObject.fillInName("Gama Company LTDA");
        newCompanyPageObject.fillInSocialReason("Gama Company");
        newCompanyPageObject.fillInAddress("Rua Avelino Nascimento");
        newCompanyPageObject.fillInNumber("222");
        newCompanyPageObject.fillInComplement("apart 107");
        newCompanyPageObject.fillInState("MG");
        newCompanyPageObject.fillInCity("Almenara");
        newCompanyPageObject.fillInZipCode("39900-000");
        newCompanyPageObject.submitForm();


        companyListPageObject.visit();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}


