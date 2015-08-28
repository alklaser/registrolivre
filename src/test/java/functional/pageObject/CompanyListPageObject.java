package functional.pageObject;

import org.openqa.selenium.WebDriver;

public class CompanyListPageObject {
    protected WebDriver driver;

    public CompanyListPageObject(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void visit () {
        driver.get("http://192.168.33.71:5000/#/empresas");
    }

    


}


