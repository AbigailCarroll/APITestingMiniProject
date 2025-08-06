package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.API;

public class REST {

    private static Response response;

    @BeforeAll
    public static void setup() {
        response = RestAssured
                .given()
                .spec(API.postProductsListRequestSpec())
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();

    }

    @DisplayName("Post request returns status code 405")
    @Test
    public void postRequestReturn405StatusCode() {

        MatcherAssert.assertThat(response.jsonPath().getString("responseCode"), Matchers.is("405"));


    }

}
