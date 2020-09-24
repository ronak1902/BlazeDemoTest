package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationPage {
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div/table/tbody/tr[5]/td[2]")
    WebElement creditCardExpiryYear;
    @FindBy(xpath = "/html/body/div[2]/div/table/tbody/tr[3]/td[2]")
    WebElement amountPaid;

    public FlightConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyCardYear(String creditCardYear)
    {
        creditCardExpiryYear.getText().contains(creditCardYear);
    }

    public void verifyAmountPaid(String amount)
    {
        amountPaid.getText().contains(amount);
    }
}
