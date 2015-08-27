package functional.Tests;

import functional.pageObject.TelaCadastroObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegistrationFunctionTest {
    static WebDriver driver;
    private TelaCadastroObject telacadastro;

    @Before
    public void setUp() throws Exception {

        driver = new FirefoxDriver();
        telacadastro = new TelaCadastroObject(driver);
        telacadastro.getDriver().get("http://192.168.33.71:5000/#/cadastro");

       // telacadastro.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }



    @Test
    public void shouldCreateNewCompany() {
        telacadastro.preencheForm("30.883.835/0001-06", "pageObjectTest");
        //telacadastro.inputCnpj("30.883.835/0001-06");
        //telacadastro.inputNomeFantasia("pageObjectTest");
        //telacadastro.submit();

        driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/div[2]/ul/li[3]/a")).click();
        Assert.assertEquals("Registro Livre", driver.getTitle());
//        WebElement span = driver.findElement(By.xpath(".//span[contains(text(),'Masterchef5')]"));
//        assertThat(span.getText(), is("Masterchef5"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}


