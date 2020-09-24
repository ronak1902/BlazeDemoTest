package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationPage {
    WebDriver driver;
    @FindBy(id = "name")
    WebElement nameTextbox;
    @FindBy(id = "company")
    WebElement companyTextbox;
    @FindBy(id = "email")
    WebElement emailTextbox;
    @FindBy(id = "password")
    WebElement passwordTextbox;
    @FindBy(id = "password-confirm")
    WebElement confirmPasswordTextbox;
    @FindBy(className = "btn btn-primary")
    WebElement registerUserButton;

    public UserRegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterAllRegistrationDetails(String userName, String company, String email, String password, String confirmPassword){
        nameTextbox.sendKeys(userName);
        companyTextbox.sendKeys(company);
        emailTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        confirmPasswordTextbox.sendKeys(confirmPassword);
    }

    public void clickRegisterUserButton()
    {
        registerUserButton.click();
    }



}
