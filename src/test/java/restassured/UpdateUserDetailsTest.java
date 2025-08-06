package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.SearchProductBadRequest;

public class UpdateUserDetailsTest {
    private static Response response;

    @BeforeAll
    public static void setup() throws JsonProcessingException {
        response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api")
                .basePath("/updateAccount")
                .contentType("application/x-www-form-urlencoded")
                .accept("application/json")
                .formParam("name", "Archie")
                .formParam("email", "archie@example.com")
                .formParam("password", "SecurePass123")
                .formParam("title", "Mr")
                .formParam("birth_date", "18")
                .formParam("birth_month", "09")
                .formParam("birth_year", "1994")
                .formParam("firstname", "Archibald")
                .formParam("lastname", "Copeland")
                .formParam("company", "TechVerse Ltd")
                .formParam("address1", "456 Innovation Way")
                .formParam("address2", "Suite 12")
                .formParam("country", "United Kingdom")
                .formParam("zipcode", "TR1 2BB")
                .formParam("state", "Cornwall")
                .formParam("city", "Truro")
                .formParam("mobile_number", "+447987654321")
                .when()
                .log().all()
                .put()
                .then()
                .log().all()
                .extract().response();
    }

    @Test
    public void testStatusCode_ReturnedIs200() {
        Integer statusCode = 200;
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(statusCode));
    }

    @Test
    public void testMessage_ReturnedIsCorrect() {
        String message = "User updated!";
        MatcherAssert.assertThat(response.jsonPath().getString("message"), Matchers.is(message));
    }
}
