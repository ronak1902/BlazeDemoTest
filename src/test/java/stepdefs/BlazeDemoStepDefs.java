package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BlazeDemoStepDefs {
    WebDriver driver;
    UserRegistrationPage  userRegistrationPage;
    TravelWorldPage travelWorldPage;
    LoginPage loginPage;
    HomePage homePage;
    ReserveTicketsPage reserveTicketsPage;
    PurchasePage purchasePage;
    FlightConfirmationPage flightConfirmationPage;
    String[] flightDetails = new String[5];
    @Before
    public void beforeScenario() {
        System.setProperty("webdriver.chrome.driver", "C:\\BlazeDemoTest\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://blazedemo.com/");
    }

    @Given("A new User is Registered")
    public void new_user_registration(DataTable dt) throws IOException {

        List<List<String>> list = dt.asLists(String.class);
        String username = "";
        String company = "";
        String email = "";
        String password = "";
        for (int i = 1; i < list.size(); i++) {
            username = list.get(i).get(0).toString();
            company = list.get(i).get(1).toString();
            email = list.get(i).get(2).toString();
            password = list.get(i).get(3).toString();
        }
        travelWorldPage = new TravelWorldPage(driver);
        loginPage = new LoginPage(driver);
        userRegistrationPage = new UserRegistrationPage(driver);
        homePage = new HomePage(driver);
        travelWorldPage.clickHomeButton();
        loginPage.clickRegisterButton();
        userRegistrationPage.enterAllRegistrationDetails(username, company, email,password,password);
        homePage.isLoggenIn();
        homePage.clickBlazeMeterHeader();
    }

    @Given("Login with existing User")
    public void login_existing_user(DataTable dt) throws IOException {

        List<List<String>> list = dt.asLists(String.class);
        String email = "";
        String password = "";
        for (int i = 1; i < list.size(); i++) {
            email = list.get(i).get(0).toString();
            password = list.get(i).get(1).toString();

        }
        travelWorldPage = new TravelWorldPage(driver);
        loginPage = new LoginPage(driver);
        userRegistrationPage = new UserRegistrationPage(driver);
        homePage = new HomePage(driver);
        travelWorldPage.clickHomeButton();
        loginPage.enterLognEmail( email);
        loginPage.enterLognPassword( password);
        loginPage.clickLoginButton();
        homePage.isLoggenIn();
        homePage.clickBlazeMeterHeader();
    }

    @When("user chooses departure city")
    public void user_chooses_departure_city(){
        //travelWorldPage = new TravelWorldPage(driver);
        travelWorldPage.chooseDepartureCity("Boston");
    }

    @And("user chooses destination city")
    public void user_chooses_destination_city(){
        //travelWorldPage =  new TravelWorldPage(driver);
        travelWorldPage.chooseDestinationCity("Cairo");
    }

    @And("click find flights button")
    public void click_find_flights_button(){
        //travelWorldPage =  new TravelWorldPage(driver);
        travelWorldPage.clickFindFlightsButton();
    }

    @And("user clicks cheapest available flight")
    public void user_chooses_flight(){
        reserveTicketsPage = new ReserveTicketsPage(driver);
        reserveTicketsPage.confirmDepartureCity("Boston");
        reserveTicketsPage.confirmDestinationCity("Cairo");
        reserveTicketsPage.chooseCheapestFlighTicket();
        flightDetails = reserveTicketsPage.saveSelectedFlightDetails();
    }

    @And("verify purchase details")
    public void verify_purchase_details(){
        purchasePage.VerifyDetailsOnPurchasePage(flightDetails[1], flightDetails[0], flightDetails[4]);
    }

    @And("enter passenger details and click on purchase flight")
    public void enter_passenger_details(){
       purchasePage.enterPassengerDetails("Ronnie", "abcd 1122", "Pune", "MH","411040", "VISA", "1234567890", "02/26", "2028", "ABCD DFGH");
       purchasePage.clickPurchaseFlight();
    }

    @Then("verify all customer details on confirmation page")
    public void verify_all_details(){
        flightConfirmationPage.verifyCardYear("2028");
        flightConfirmationPage.verifyAmountPaid("400");
    }

    @Given("blazedemo site is opened in the browser")
    public void blazemeter_open() {
    }

    @After
    public void afterScenario() {
       driver.close();
    }

}
