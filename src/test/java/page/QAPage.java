package page;

import org.openqa.selenium.WebDriver;

public class QAPage {

    private WebDriver driver;


    public QAPage(WebDriver driver) {
        this.driver = driver;
    }

    public void browser() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

}
