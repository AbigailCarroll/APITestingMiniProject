package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.UserManagement.CreateUserResponse;
import utils.API;

public class CreateUserAccountTest {

    private Response response;
    private CreateUserResponse createUserResponse;
    private final ObjectMapper mapper = new ObjectMapper();

    private Response sendCreateUserRequest(String email) {
        return RestAssured
                .given()
                .spec(API.createAccountRequestSpec())
                .formParams(
                        "name", "Test User",
                        "email", email,
                        "password", "password123",
                        "title", "Miss",
                        "birth_date", "17",
                        "birth_month", "02",
                        "birth_year", "2004",
                        "firstname", "Jess",
                        "lastname", "John",
                        "company", "Sparta Global",
                        "address1", "123 Main St",
                        "address2", "Apt 123",
                        "country", "United Kingdom",
                        "zipcode", "EC2Y 5AS",
                        "state", "London",
                        "city", "London",
                        "mobile_number", "1234567890"
                )
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .extract()
                .response();
    }

    private CreateUserResponse extractJson(Response response) throws JsonProcessingException {
        String rawBody = response.getBody().asString();
        String json = rawBody.replaceAll("(?s)<[^>]*>", "").trim();
        return mapper.readValue(json, CreateUserResponse.class);
    }

    @Test
    @DisplayName("User should be successfully created")
    public void testCreateUserAccountSuccess() throws JsonProcessingException {
        String uniqueEmail = "testuser_" + System.currentTimeMillis() + "@example.com";
        response = sendCreateUserRequest(uniqueEmail);
        createUserResponse = extractJson(response);

        MatcherAssert.assertThat(createUserResponse.getResponseCode(), Matchers.is(201));
        MatcherAssert.assertThat(createUserResponse.getMessage(), Matchers.is("User created!"));
    }

    @Test
    @DisplayName("When the email is missing an error message should be returned")
    public void testCreateUserAccountFail_MissingEmail() throws JsonProcessingException {
        response = RestAssured
                .given()
                .spec(API.createAccountRequestSpec())
                .formParams(
                        "name", "Test User",
                        "password", "password123",
                        "title", "Miss",
                        "birth_date", "17",
                        "birth_month", "02",
                        "birth_year", "2004",
                        "firstname", "Jess",
                        "lastname", "John",
                        "company", "Sparta Global",
                        "address1", "123 Main St",
                        "address2", "Apt 123",
                        "country", "United Kingdom",
                        "zipcode", "EC2Y 5AS",
                        "state", "London",
                        "city", "London",
                        "mobile_number", "1234567890"
                )
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .extract()
                .response();

        createUserResponse = extractJson(response);

        MatcherAssert.assertThat(createUserResponse.getResponseCode(), Matchers.is(400));
        MatcherAssert.assertThat(createUserResponse.getMessage(), Matchers.is("Bad request, email parameter is missing in POST request."));
    }

    @Test
    @DisplayName("When the user exists an error message should be returned")
    public void testExistingUser() throws JsonProcessingException {
        String existingEmail = "testuser@example.com";
        response = sendCreateUserRequest(existingEmail);
        createUserResponse = extractJson(response);

        MatcherAssert.assertThat(createUserResponse.getResponseCode(), Matchers.is(400));
        MatcherAssert.assertThat(createUserResponse.getMessage(), Matchers.is("Email already exists!"));
    }
}