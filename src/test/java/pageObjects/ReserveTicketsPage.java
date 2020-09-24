package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;

public class ReserveTicketsPage {


    WebDriver driver;
    Integer indexMinAmount = 1;
    @FindBy(xpath = "//*[@id='app-navbar-collapse']/ul[2]/li[2]/a")
    WebElement registerButton;

    @FindBy(xpath = "/html/body/div[2]/table/thead/tr/th[4]")
    WebElement labelDeparts;

    @FindBy(xpath = "/html/body/div[2]/table/thead/tr/th[5]")
    WebElement labelArrives;

    public ReserveTicketsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseCheapestFlighTicket()
    {
        //ArrayList<Double> listOfPrices = new ArrayList<Double>();
        for(int i=1;i<=4;i++)
        {
            //listOfPrices.add(Double.parseDouble(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + i + "]/td[6]")).getText().substring(1)));
            if(i>=1)
            {
                if(Double.parseDouble(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + i + "]/td[6]")).getText().substring(1)) < Double.parseDouble(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + i++ + "]/td[6]")).getText().substring(1)))
                {
                    indexMinAmount = i;
                }
            }
        }

    }

    public String[] saveSelectedFlightDetails()
    {
        String[] flightDetails = new String[5];

        flightDetails[0] = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + indexMinAmount + "]/td[2]")).getText();
        flightDetails[1] = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + indexMinAmount + "]/td[3]")).getText();
        flightDetails[2] = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + indexMinAmount + "]/td[4]")).getText();
        flightDetails[3] = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + indexMinAmount + "]/td[5]")).getText();
        flightDetails[4] = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + indexMinAmount + "]/td[6]")).getText().substring(1);
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[" + indexMinAmount + "]/td[1]/input")).click();
        return flightDetails;
    }

    public Boolean confirmDepartureCity(String departureCity)
    {
        if(labelDeparts.getText().contains(departureCity)) {
            return true;
        }
            else {
            return false;
        }
    }

    public Boolean confirmDestinationCity(String destinationCity)
    {
        if(labelArrives.getText().contains(destinationCity)) {
            return true;
        }
        else {
            return false;
        }
    }
}
