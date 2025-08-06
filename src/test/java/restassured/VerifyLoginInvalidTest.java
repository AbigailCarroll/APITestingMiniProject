package restassured;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.UserLoginResponse;
import utils.API;
import utils.Config;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyLoginInvalidTest {

    @Test
    public void verifyLoginWithInvalidCredentials() throws Exception {
        String invalidEmail = Config.getProperty("automationexercise.invalid_email");
        String invalidPassword = Config.getProperty("automationexercise.invalid_password");

        Response response = given()
                .spec(API.verifyLoginRequestSpec())
                .formParam("email", invalidEmail)
                .formParam("password", invalidPassword)
                .header("Accept", "application/json")
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .extract()
                .response();

        String rawBody = response.asString();
        String json = extractJsonFromHtml(rawBody);
        ObjectMapper mapper = new ObjectMapper();
        UserLoginResponse loginResponse = mapper.readValue(json, UserLoginResponse.class);
        assertEquals(404, loginResponse.getResponseCode(), "Expected response code 404");
        assertEquals("User not found!", loginResponse.getMessage(), "Expected message: User not found!");
    }

    private String extractJsonFromHtml(String html) {
        int start = html.indexOf('{');
        int end = html.lastIndexOf('}');
        if (start != -1 && end != -1 && end > start) {
            return html.substring(start, end + 1);
        } else {
            throw new IllegalStateException("Could not extract JSON from HTML response");
        }
    }
}
