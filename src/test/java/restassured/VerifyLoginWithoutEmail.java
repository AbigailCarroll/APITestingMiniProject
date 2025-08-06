package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.VerifyLogin.VerifyLoginInvalid;

public class VerifyLoginWithoutEmail {
    private static Response response;
    private static VerifyLoginInvalid verifyLoginInvalid;

    @BeforeAll
    public static void setup(){
        RestAssured.registerParser("text/html", Parser.JSON);

        response = RestAssured
                .given()
                .spec(utils.API.getVerifyLogin())
                .formParam("password", "Test123")
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();
       verifyLoginInvalid = response.as(VerifyLoginInvalid.class);

    }

    @Test
    @DisplayName("Tests the response status code returns 400")
    public void testResponseStatusCode_Returns400() {
        MatcherAssert.assertThat(verifyLoginInvalid.getResponseCode(), Matchers.is(400));
    }

}
