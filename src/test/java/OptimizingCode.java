import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class OptimizingCode {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://www.zippopotam.us/")
                .build();
    }

    @Test
    public void requestCountryZipCode() {
        given().
                spec(requestSpecification).
        when().
                get("us/90210").
        then().
                assertThat().
                statusCode(200);
    }

    @BeforeClass
    public static void createResponseSpecification() {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void responseCountryZipCode() {
        given().
                spec(requestSpecification).
        when().
                get("https://www.zippopotam.us/us/90210").
        then().
                spec(responseSpecification).
                and().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void getFirstPlaceName() {
        String placeName =
        given().
                spec(requestSpecification).
        when().
                get("https://www.zippopotam.us/us/90210").
        then().
                extract().
                path("places[0].'place name'");

        Assert.assertEquals(placeName, "Beverly Hills");
    }

}
