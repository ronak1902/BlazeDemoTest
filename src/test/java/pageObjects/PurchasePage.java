package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/p[1]")
    WebElement airlineNameLabel;
    @FindBy(xpath = "/html/body/div[2]/p[2]")
    WebElement airlineNumberLabel;
    @FindBy(xpath = "/html/body/div[2]/p[3]")
    WebElement flightPriceLabel;
    @FindBy(xpath = "//*[@id='app']/nav/div/div[1]/a")
    WebElement blazeMeterHeader;
    @FindBy(id = "inputName")
    WebElement enterNameTextbox;
    @FindBy(id = "address")
    WebElement enterAddressTextbox;
    @FindBy(id = "city")
    WebElement enterCityTextbox;
    @FindBy(id = "state")
    WebElement enterStateTextbox;
    @FindBy(id = "zipCode")
    WebElement enterZipTextbox;
    @FindBy(id = "creditCardNumber")
    WebElement enterCardNumberTextbox;
    @FindBy(id = "creditCardMonth")
    WebElement enterCardMonthTextbox;
    @FindBy(id = "creditCardYear")
    WebElement enterCardYearTextbox;
    @FindBy(id = "nameOnCard")
    WebElement enterCardNameTextbox;
    @FindBy(xpath = "/html/body/div[2]/form/div[11]/div/input")
    WebElement purchaseFlightButton;
    public PurchasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void VerifyDetailsOnPurchasePage(String airlineName, String airlineNumber, String price)
    {
        airlineNameLabel.getText().contains(airlineName);
        airlineNumberLabel.getText().contains(airlineNumber);
        flightPriceLabel.getText().contains(price);
    }

    public void enterPassengerDetails(String username, String address, String city, String state, String zipCode, String cardType, String creditCardNumber, String month, String year, String cardName)
    {
        Select cardTypeDropDown = new Select(driver.findElement(By.name("cardType")));
        cardTypeDropDown.selectByVisibleText(cardType);
        enterNameTextbox.sendKeys(username);
        enterAddressTextbox.sendKeys(address);
        enterCityTextbox.sendKeys(city);
        enterStateTextbox.sendKeys(state);
        enterZipTextbox.sendKeys(zipCode);
        enterCardNumberTextbox.sendKeys(creditCardNumber);
        enterCardMonthTextbox.sendKeys(month);
        enterCardYearTextbox.sendKeys(year);
        enterCardNameTextbox.sendKeys(cardName);
    }

    public void clickPurchaseFlight()
    {
        purchaseFlightButton.click();
    }
}
