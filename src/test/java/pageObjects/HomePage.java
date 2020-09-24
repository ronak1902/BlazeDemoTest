package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class HomePage {


    WebDriver driver;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div[2]")
    WebElement loggedInText;

    @FindBy(xpath = "//*[@id='app']/nav/div/div[1]/a")
    WebElement blazeMeterHeader;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean isLoggenIn()
    {
        if(loggedInText.getText().contains("You are logged in!")) {
            return true;
        }
        else {
            return false;
        }

    }

    public void clickBlazeMeterHeader()
    {
        blazeMeterHeader.click();
    }
}
