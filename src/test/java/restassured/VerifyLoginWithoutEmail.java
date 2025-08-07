package restassured;


import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.VerifyLogin.VerifyLogin;

public class VerifyLoginWithoutEmail {
    private static Response response;
    private static VerifyLogin verifyLoginInvalid;

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
       verifyLoginInvalid = response.as(VerifyLogin.class);

    }

    @Test
    @DisplayName("Tests the response status code returns 400")
    public void testResponseStatusCode_Returns400() {
        MatcherAssert.assertThat(verifyLoginInvalid.getResponseCode(), Matchers.is(400));
    }

    @Test
    @DisplayName("Tests the response message is correct")
    public void testResponseMessageIsCorrect() {
        MatcherAssert.assertThat(verifyLoginInvalid.getMessage(), Matchers.is("Bad request, email or password parameter is missing in POST request."));
    }

}
