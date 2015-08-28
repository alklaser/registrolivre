package functional.Tests;

import functional.pageObject.TelaCadastroObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegistrationFunctionTest {
    static WebDriver driver;
    private TelaCadastroObject telaCadastroObject;

    @Before
    public void setUp() throws Exception {

        driver = new FirefoxDriver();
        telaCadastroObject = new TelaCadastroObject(driver);


       // telaCadastroObject.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @Test
    public void shouldCreateNewCompany() {
        telaCadastroObject.visit();
        telaCadastroObject.fillInCnpj("30.883.835/0001-06");
        telaCadastroObject.fillInName("Gama Company LTDA");
        telaCadastroObject.fillInSocialReason("Gama Company");
        telaCadastroObject.fillInAddress("Rua Avelino Nascimento");
        telaCadastroObject.fillInNumber("222");
        telaCadastroObject.fillInComplement("apart 107");
        telaCadastroObject.fillInState("MG");
        telaCadastroObject.fillInCity("Almenara");
        telaCadastroObject.fillInZipCode("39900-000");
        telaCadastroObject.submitForm();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}


