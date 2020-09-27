package services;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import utils.SpaceXUtils;

import static io.restassured.RestAssured.given;

public class SpaceXApiCalls {

    public static Response getSpacXLatestUpdates() {

        String spaceXEndPoint = SpaceXUtils.endPoints.spaceXEndPoint();
        System.out.println("Method " + new Throwable().getStackTrace()[0].getClassName() + "." + new Throwable().getStackTrace()[0].getMethodName() + " - Started");
        Response response = null;
        String indexSlot = "";
        System.out.println(spaceXEndPoint + "/v4/launches/latest");
        try {
            response = given()
                    .get(spaceXEndPoint + "/v4/launches/latest")
                    .then().statusCode(HttpStatus.SC_OK)
                    .extract()
                    .response();
        } catch (Exception e) {
            System.out.println("Space X latest update service failed to fetch correct response: " + e.getMessage());
            Assert.fail("Space X latest update API call failed");
        }
        System.out.println("Method " + new Throwable().getStackTrace()[0].getClassName() + "." + new Throwable().getStackTrace()[0].getMethodName() + " - Completed");
        return response;
    }
}
