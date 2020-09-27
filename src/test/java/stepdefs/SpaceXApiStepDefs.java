package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import services.SpaceXApiCalls;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class SpaceXApiStepDefs {

    Response response = null;
    @Given("call Space X Latest get Api")
    public void space_x_latest_updates() {
        response = SpaceXApiCalls.getSpacXLatestUpdates();
    }

    @When("^Api returns a correct response with status code (\\d+)")
    public void verify_api_status_code(int stausCode) {
        Assert.assertEquals(response.getStatusCode(), stausCode);
    }

    @Then("verify rocket details from the space X Api")
    public void verify_rocket_details() {
        String rocketId = response.jsonPath().get("rocket").toString();
        Assert.assertNotNull("Rocket id should not be null", rocketId);
        Assert.assertNotEquals("", rocketId);
    }

    @Then("verify capsule details from the space X Api")
    public void verify_capsule_details() {
        List<String> capsules = response.jsonPath().getList("capsules");
        int counter = 0;
        for(String capsule : capsules){
            if(capsule != null && capsule.isEmpty())
                counter++;
        }
        Assert.assertTrue("response contains value for capsules",counter>0);
    }

    @Then("verify launch pad Id and latest flight details")
    public void verify_flight_and_launchpad_details() {
        String launchpadId = response.jsonPath().get("launchpad").toString();
        Assert.assertNotNull("launchpad id should not be null", launchpadId);
        Assert.assertNotEquals("", launchpadId);
        Integer flightNumber = response.jsonPath().get("flight_number");
        System.out.println("Flight number is: " + flightNumber);
        String lastFlightName = response.jsonPath().get("name").toString();
        Assert.assertNotNull("Last Flight Name should not be null", lastFlightName);
        Assert.assertNotEquals("", lastFlightName);
        String lastFlightDateUtc = response.jsonPath().get("date_utc").toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.ms\'Z\'");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(lastFlightDateUtc.trim());
        } catch (ParseException pe) {
            Assert.fail("give launch date not a valid date format");
        }
    }

    @Then("verify core details for Space X")
    public void verify_core_details() {
        String coreId = response.jsonPath().get("cores[0].core").toString();
        Assert.assertNotNull("coreId id should not be null", coreId);
        Assert.assertNotEquals("", coreId);
        String landingAttempt = response.jsonPath().get("cores[0].landing_attempt").toString();
        String landingSuccess = response.jsonPath().get("cores[0].landing_success").toString();
        if(landingAttempt.equals("true"))
            Assert.assertEquals("true", landingSuccess);
        else
            Assert.fail("Landing Failed for Space X");

    }
}
