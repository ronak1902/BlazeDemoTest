package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id='app-navbar-collapse']/ul[2]/li[2]/a")
    WebElement registerButton;

    @FindBy(id = "email")
    WebElement emailLogin;
    @FindBy(id = "password")
    WebElement emailPassword;
    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div[2]/form/div[4]/div/button")
    WebElement loginButton;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterButton(){
        registerButton.click();
    }
    public void enterLognEmail(String email){
        emailLogin.sendKeys(email);
    }

    public void enterLognPassword(String password){
        emailPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
