package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class LoginPage_PF {
    @FindBy(id = "txtUserName")
    WebElement txtUsername;
    @FindBy(id = "txtPassword")
    WebElement txtPassword;
    @FindBy(id = "BtnLogin")
    @CacheLookup
    WebElement btnLogin;

  /*  @FindBy(partialLinkText = "Shirts")
    List<WebElement> webElementList;
    @FindBy(how = How.ID, using = "name")
    WebElement txtname;*/
    WebDriver driver = null;
    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    public void enterUsername(String username) {
        txtPassword.sendKeys(username);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void loginValidUser(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public boolean checkLogOutIsDisplayed() {

        return true;

    }


}
