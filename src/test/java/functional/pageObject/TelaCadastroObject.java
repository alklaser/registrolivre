package functional.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TelaCadastroObject{


    protected WebDriver driver;

    public TelaCadastroObject(WebDriver driver){
        super();
        this.driver = driver;
    }

    @FindBy (id = "cnpj")
    private WebElement cnpfField;

    @FindBy (id = "nomeFantasia")
    private WebElement nomeFantasiaField;

    @FindBy (id = "btn-submit")
    private WebElement submitBtn;

//    public void inputCnpj(String cnpj){
//        cnpfField.sendKeys(cnpj);
//    }
//
//    public void inputNomeFantasia(String nomeFantasia){
//        nomeFantasiaField.sendKeys(nomeFantasia);
//    }
//
//    public void submit() {
//        submitBtn.click();
//    }

    public TelaCadastroObject preencheForm(String cnpj,String nomeFantasia){
        cnpfField.sendKeys(cnpj);
        nomeFantasiaField.sendKeys(nomeFantasia);
        submitBtn.click();
//        inputCnpj(cnpj);
//        inputNomeFantasia(nomeFantasia);
//        submit();

        return this;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

}
