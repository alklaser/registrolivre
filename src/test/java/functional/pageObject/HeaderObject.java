package functional.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderObject {
    protected WebDriver driver;

    public HeaderObject(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void visitHome(){
        driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/div[1]/a/")).click();
    }

    public void visitCadastrarEmpresa(){
        driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/div[2]/ul/li[2]/a")).click();
    }

    public void visitListarEmpresa(){
        driver.findElement(By.xpath("/html/body/div/div[1]/nav/div/div[2]/ul/li[3]/a")).click();
    }

    public String getCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
}
