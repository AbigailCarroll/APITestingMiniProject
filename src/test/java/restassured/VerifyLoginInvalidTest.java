package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.UserManagement.UserLoginResponse;
import utils.API;

import utils.ExerciseConfig;

public class VerifyLoginInvalidTest {
    private static Response response;
    private static UserLoginResponse loginResponse;

    @BeforeAll
    public static void setup() throws JsonProcessingException {
        String invalidEmail = ExerciseConfig.getProperty("automationexercise.invalid_email");
        String invalidPassword = ExerciseConfig.getProperty("automationexercise.invalid_password");
        response = RestAssured
                .given()

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

        String rawBody = response.getBody().asString();
        String json = rawBody.replaceAll("(?s)<[^>]*>", "").trim();
        ObjectMapper mapper = new ObjectMapper();
        loginResponse = mapper.readValue(json, UserLoginResponse.class);
    }

    @Test
    @DisplayName("Request returns status code 404")
    public void verifyLoginWithInvalidCredentials_StatusCode() {
        MatcherAssert.assertThat(loginResponse.getResponseCode(), Matchers.is(404));
    }

    @Test
    @DisplayName("Request returns error message")
    public void verifyLoginWithInvalidCredentials_Message() {
        MatcherAssert.assertThat(loginResponse.getMessage(), Matchers.is("User not found!"));
    }

}
