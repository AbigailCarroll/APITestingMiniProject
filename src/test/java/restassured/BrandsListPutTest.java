package restassured;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.API;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrandsListPutTest {
    private static Response response;

    @BeforeAll
    static void beforeAll(){
        //Treat "text/html" as JSON
        RestAssured.registerParser("text/html", Parser.JSON);

        response = RestAssured
                .given()
                .spec(API.putBrandsListSpec())
                .body("{ \"dummy\": \"data\" }")
                .when()
                .put()
                .then()
                .log().all()
                .extract().response();
    }

    @Test
    public void testPutMethodOnBrandsList_ShouldReturn405InBody() {
        // Parse JSON directly
        int responseCode = response.jsonPath().getInt("responseCode");
        String message = response.jsonPath().getString("message");

        MatcherAssert.assertThat(responseCode, Matchers.is(405));
        MatcherAssert.assertThat(message, Matchers.is("This request method is not supported."));


    }
}
