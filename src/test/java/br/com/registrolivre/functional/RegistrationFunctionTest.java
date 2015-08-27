package br.com.registrolivre.functional;

import br.com.registrolivre.repository.CompanyRepository;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RegistrationFunctionTest {

    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void shouldCreateNewCompany() {
        companyRepository.deleteAll();

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://192.168.33.71:5000/#/cadastro");

        WebElement cnpj = driver.findElement(By.id("cnpj"));
        cnpj.sendKeys("75.423.694/0001-79");

        WebElement nomeFantasia = driver.findElement(By.id("nomeFantasia"));
        nomeFantasia.sendKeys("Masterchef5");

        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        submitButton.click();

        driver.get("http://192.168.33.71:5000/#/empresas");
        WebElement span = driver.findElement(By.xpath(".//span[contains(text(),'Masterchef5')]"));
        assertThat(span.getText(), is("Masterchef5"));
        driver.close();
    }
}


