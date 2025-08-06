package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductSearchPostTest {
    private static Response response;

    @BeforeAll
    public static void setup() {
        response = RestAssured
                .given()
                    .baseUri("https://automationexercise.com/api")
                    .basePath("/searchProduct")
                    .contentType("application/x-www-form-urlencoded")
                    .accept("application/json")
                    .formParam("search_product", "shirt")
                .when()
                    .log().all()
                    .post()
                .then()
                .log().all()
                .extract().response();
    }

    @Test
    @DisplayName("Tests the response status code returns 200")
    public void testResponseStatusCode_Returns200() {
        Integer statusCode = 200;
        MatcherAssert.assertThat(response.jsonPath().getString("responseCode"), Matchers.is(statusCode));
    }


}
