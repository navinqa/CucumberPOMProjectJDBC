package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.HomePage_PF;
import pagefactory.LoginPage_PF;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginPageSteps_PF {

    WebDriver driver = null;
    LoginPage_PF login;
    HomePage_PF home;
    @Given("browser is open")
    public void browserIsOpen() {
        System.out.println("I am inside a browser open_PF");
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @And("user is on login page")
    public void userIsOnLoginPage() {
        driver.navigate().to("https://edplex.skool360.com/");
    }

    @When("users enters {} and {}")
    public void usersEntersAnd(String username, String password) {
        login= new LoginPage_PF(driver);
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
        login.clickLogin();
    }

    @Then("user is navigate to home page")
    public void userIsNavigateToHomePage() {
        home = new HomePage_PF(driver);
        Assert.assertTrue(home.checkLogoutIsDisplayed());
        driver.close();
    }
}
