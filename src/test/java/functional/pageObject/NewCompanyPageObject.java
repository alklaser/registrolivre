package functional.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewCompanyPageObject {
    protected WebDriver driver;

    public NewCompanyPageObject(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void visit() {
        driver.get("http://192.168.33.71:5000/#/cadastro");
    }

    public void fillInCnpj(String cnpj) {
        driver.findElement(By.id("cnpj")).sendKeys(cnpj);
    }

    public void fillInName(String nomeFantasia) {
        driver.findElement(By.id("nomeFantasia")).sendKeys(nomeFantasia);
    }

    public void fillInSocialReason(String socialReason) {
        driver.findElement(By.id("razaoSocial")).sendKeys(socialReason);
    }

    public void fillInAddress(String nameAddress) {
        driver.findElement(By.id("nomeEndereco")).sendKeys(nameAddress);
    }

    public void fillInNumber(String number) {
        driver.findElement(By.id("nomeNumero")).sendKeys(number);
    }

    public void fillInComplement(String nameComplement) {
        driver.findElement(By.id("nomeComplemento")).sendKeys(nameComplement);
    }

    public void fillInState(String stateName) {
        Select dropdown = new Select(driver.findElement(By.cssSelector("#nomeUF-group select")));
        dropdown.selectByVisibleText(stateName);
    }

    public void fillInCity(String cityName) {
        Select dropdown = new Select(driver.findElement(By.cssSelector("#nomeCidade-group select")));
        dropdown.selectByVisibleText(cityName);
    }

    public void fillInZipCode(String zipCode) {
        driver.findElement(By.id("nomeCEP")).sendKeys(zipCode);
    }

    public void submitForm() {
        driver.findElement(By.id("btn-submit")).click();
    }
}
