//package steps;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pages.LoginPage;
//
//import java.util.concurrent.TimeUnit;
//
//public class LoginPageSteps {
//
//    WebDriver driver = null;
//    LoginPage login;
//
//
//    @Given("browser is open")
//    public void browserIsOpen() {
//        System.out.println("I am inside a browser open");
//        WebDriverManager.chromedriver().setup();
//        driver= new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }
//
//    @And("user is on login page")
//    public void userIsOnLoginPage() {
//        driver.navigate().to("https://edplex.skool360.com/");
//    }
//
//    @When("users enters {} and {}")
//    public void usersEntersAnd(String username, String password) {
//        login= new LoginPage(driver);
//        login.enterUsername(username);
//        login.enterPassword(password);
//
//    }
//
//    @And("user click on login button")
//    public void userClickOnLoginButton() {
//        login.clickLogin();
//    }
//
//    @Then("user is navigate to home page")
//    public void userIsNavigateToHomePage() {
//        Assert.assertTrue(login.checkLogOutIsDisplayed());
//        driver.close();
//    }
//
//
//}
