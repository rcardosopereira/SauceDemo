package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.QAPage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Steps {

    private WebDriver driver;
    private QAPage qaPage;
    public Steps steps;

    @Before()
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver.exe");
        driver = new ChromeDriver();
        qaPage = new QAPage(driver);
        steps = new Steps();
    }

    @Given("The access to the page")
    public void The_access_to_the_page() {
        qaPage.browser();
    }

    @When("I put the username and password")
    //Data Table
    public void i_write_the_question_and_answer(List<Map<String, String>> names) {
        for(Map<String, String> name : names) {
            driver.findElement(By.id("user-name")).sendKeys(name.get("username"));
            driver.findElement(By.id("password")).sendKeys(name.get("password"));
        }
    }

   @And("I click in the login button")
   public void I_click_in_the_login_button() throws InterruptedException {
       driver.findElement(By.id("login-button")).click();
    }

    @And ("I add to cart the bike light")
    public void I_add_to_cart_the_bike_light() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @And ("I click in the shopping cart")
    public void I_click_in_the_shopping_cart() throws InterruptedException {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @And ("I click in the checkout button")
    public void I_click_in_the_checkout_button() throws InterruptedException {
        driver.findElement(By.id("checkout")).click();
    }

    @And ("I fill in my personal information")
    public void I_fill_in_my_personal_information() throws InterruptedException {
        driver.findElement(By.id("first-name")).sendKeys("João");
        driver.findElement(By.id("last-name")).sendKeys("Silva");
        driver.findElement(By.id("postal-code")).sendKeys("90410");
        driver.findElement(By.id("continue")).click();
    }

    @And ("I click in the finish button")
    public void I_click_in_the_finish_button() throws InterruptedException {
        driver.findElement(By.id("finish")).click();
    }

    @Then("I see the checkout complete")
    public void I_see_the_checkout_complete()  {
        WebElement ActualText = driver.findElement(By.className("complete-header"));
        String ExpectedText = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(ExpectedText, ActualText.getText());
        System.out.println("THANK YOU FOR YOUR ORDER text is a expected – Assert passed");
    }

    @Then ("I click in the login")
    public void I_click_in_the_login()  {

        driver.findElement(By.id("login-button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ActualText = driver.findElement(By.xpath("//*[text()='Epic sadface: Sorry, this user has been locked out.']"));
        String ExpectedText = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(ExpectedText, ActualText.getText());
        System.out.println("Epic sadface: Sorry, this user has been locked out. text is a expected – Assert passed");
    }

//*[@id="login_button_container"]/div/form/div[3]

    @After()
    public void quitBrowser(){
        driver.quit();
    }

}