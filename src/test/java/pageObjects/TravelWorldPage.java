package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TravelWorldPage {

    WebDriver driver;
    @FindBy(xpath = "/html/body/div[1]/div/div/a[3]")
    WebElement homeButton;
    @FindBy(xpath = "/html/body/div[3]/form/div/input")
    WebElement fineFlightsButton;
    public TravelWorldPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickHomeButton(){
        homeButton.click();
    }

    public void chooseDepartureCity(String country)
    {
        Select fromCountry = new Select(driver.findElement(By.name("fromPort")));
        fromCountry.selectByVisibleText(country);
    }

    public void chooseDestinationCity(String country)
    {
        Select toCountry = new Select(driver.findElement(By.name("toPort")));
        toCountry.selectByVisibleText(country);
    }

    public void clickFindFlightsButton(){
        fineFlightsButton.click();
    }
}
