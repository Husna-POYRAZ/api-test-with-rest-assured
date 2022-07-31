import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class getMethod {
    public static final String api = "https://www.zippopotam.us/";
    public static final String getApi = "us/90210";
    // Checking the HTTP request
    @Test(priority=1)
    public void checkHTTPRequest() {
        RestAssured.baseURI = api;
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get(getApi);

    }

    // Checking the response status code expect HTTP 200
    @Test(priority=2)
    public void checkStatusCode() {
        given().
        when().
                get(api + getApi).
        then().
                assertThat().
                statusCode(200);
    }

    // Checking the response content type
    @Test(priority=3)
    public void checkContentType() {
        given().
        when().
                get(api + getApi).
        then().
                assertThat().
                contentType(ContentType.JSON); // or .contentType("application/json");
    }

    // Logging request and response details
    @Test(priority=4)
    public void checkLogRequestandResponseDetails() {
        given().
                log().all().
        when().
                get(api + getApi).
        then().
                log().
                body();

    }

    // Checking the response body
    @Test(priority=5)
    public void checkResponseBody() {
        given().
        when().
                get(api + getApi).
        then().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));

    }
    @Test(priority=6)
    public void checkResponseBody2() {
        given().
        when().
                get(api + getApi).
        then().
                assertThat().
                body("places.'place name'", hasItem("Beverly Hills"));
    }
    @Test(priority=7)
    public void checkResponseBody3() {
        given().
        when().
                get(api + getApi).
        then().
                assertThat().
                body("places[0].'state'", equalTo("California"));

    }

    @Test(priority=8)
    public void checkResponseBody34() {
        given().
        when().
                get(api + getApi).
        then().
                assertThat().
                body("places.'place name'", hasSize(1));

    }



}
