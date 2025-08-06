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

public class VerifyLoginWithCorrectDetails {
    private static Response response;
    private static VerifyLogin verifyLoginValid;

    @BeforeAll
    public static void setup(){
        RestAssured.registerParser("text/html", Parser.JSON);

        response = RestAssured
                .given()
                .spec(utils.API.getVerifyLogin())
                .formParam("email", "example@sparta2.com")
                .formParam("password", "Test123")
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();
        verifyLoginValid = response.as(VerifyLogin.class);

    }

    @Test
    @DisplayName("Tests the response status code returns 200")
    public void testResponseStatusCode_Returns200() {
        MatcherAssert.assertThat(verifyLoginValid.getResponseCode(), Matchers.is(200));
    }

}