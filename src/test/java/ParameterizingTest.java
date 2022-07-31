import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParameterizingTest {

    @DataProvider(name = "data-provider")
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][] {
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"}
        };
    }
    @Test (dataProvider = "data-provider")
    public void checkResponseBody(String countryCode, String zipCode, String expectedPlaceName) {
        given().
                pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
        when().
                get("https://www.zippopotam.us/{countryCode}/{zipCode}").
        then().
                assertThat().
                body("places[0].'place name'", equalTo(expectedPlaceName));
    }
}
