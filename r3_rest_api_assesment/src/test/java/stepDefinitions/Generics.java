package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.Assert;

import java.net.URI;

public class Generics {

    private Scenario scenario;
    private Response response;
    private final String BASE_URL = "https://open.er-api.com/";
    private static final Logger LOGGER = LogManager.getLogger(Generics.class);

    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
    }

    @Given("I call the API with the endpoint {string}")
    public void GET_request_to_URL (String url) throws Exception {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification req = RestAssured.given();
        response = req.when().get(new URI(url));
        LOGGER.info("API HIT");
    }

    @And("the response status should be {int}")
    public void check_response_is_status_code (int statusCode) throws Exception {
        int actualStatusCode = response.then().extract().statusCode();
        LOGGER.info("Asserting the response status code with the actuals");
        Assert.assertEquals(statusCode, actualStatusCode);

    }




}
