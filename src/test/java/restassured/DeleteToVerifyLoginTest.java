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
import pojos.DeleteToVerifyLogin;
import pojos.SearchProductBadRequest;

public class DeleteToVerifyLoginTest {

    private static Response response;
    private static DeleteToVerifyLogin deleteToVerifyLogin;

    @BeforeAll
    public static void sendDeleteToVerifyLogin() throws JsonProcessingException {
        response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api")
                .basePath("/verifyLogin")
             //   .contentType("application/x-www-form-urlencoded") // not required for DELETE, but fine
                .accept("application/json")
                .when()
                .log().all()
                .delete()
                .then()
                .log().all()
                .extract().response();
        //Strips away any html tags in response and parses as json
        String rawBody = response.getBody().asString();
        String json = rawBody.replaceAll("(?s)<[^>]*>", "").trim();
        ObjectMapper mapper = new ObjectMapper();
        deleteToVerifyLogin = mapper.readValue(json, DeleteToVerifyLogin.class);

    }
    @Test
    @DisplayName("Response Code Returned 405")
    public void testResponseCode_ReturnedIs405() {

        Integer responseCode = 405;
        MatcherAssert.assertThat(deleteToVerifyLogin.getResponseCode(), Matchers.is(responseCode));
    }

    @Test
    @DisplayName("Response Message returned Request Method is not supported")
    public void testMessage_ReturnedIsCorrect() {
        String message = "This request method is not supported." ;
        MatcherAssert.assertThat(deleteToVerifyLogin.getMessage(), Matchers.is(message));
    }
}
