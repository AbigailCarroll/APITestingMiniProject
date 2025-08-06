package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

public class GetProductList {


    private static Response response;

    @BeforeAll
    public static void beforeAll()
    {
        response = RestAssured
                .given()
                .spec(API.getProductListSpec())
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }

    @Test
    @DisplayName("Status Code is 200")
    public void testStatusCode()
    {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }
}
