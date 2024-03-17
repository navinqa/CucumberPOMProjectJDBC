package pages;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By txtUsername = By.id("txtUserName");
    private By txtPassword = By.id("txtPassword");
    private By btnLogin = By.id("BtnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Login - Edplex")) {
            throw new IllegalStateException("This is a not login page : " + driver.getTitle() + " URL" + driver.getCurrentUrl());
        }
    }
    public void enterUsername(String username)
    {
        driver.findElement(txtUsername).sendKeys(username);
    }
    public void enterPassword(String password)
    {
        driver.findElement(txtPassword).sendKeys(password);
    }
    public void clickLogin()
    {
        driver.findElement(btnLogin).click();
    }
    public void loginValidUser(String username, String password)
    {
        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
    }
    public boolean checkLogOutIsDisplayed()
    {
        return true;

    }


}
