package restassured;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import utils.API;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;

public class CreateUserAccountTest {

    @Test
    @DisplayName("User should be successfully created")
    public void testCreateUserAccountSuccess() {
        String uniqueEmail = "testuser_" + System.currentTimeMillis() + "@example.com";

        Response response = given()
                .spec(API.createAccountRequestSpec())
                .formParams(
                        "name", "Test User",
                        "email", uniqueEmail,
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
                .when()
                .post();

        response.then().log().all();

        response.then().statusCode(200);

       String responseBody = response.body().asString();
        String jsonBody = responseBody.replaceAll("<html>\\s*<body>|</body>\\s*</html>", "");

        JsonPath jsonPath = new JsonPath(jsonBody);


        int statusCode = jsonPath.getInt("responseCode");
        String message = jsonPath.getString("message");

        MatcherAssert.assertThat(statusCode, Matchers.is(201));
        MatcherAssert.assertThat(message, Matchers.is("User created!"));
    }

    @Test
    @DisplayName("When the email is missing an error message should be returned")
    public void testCreateUserAccountFail_MissingEmail() {
        String uniqueEmail = "testuser_" + System.currentTimeMillis() + "@example.com";

        Response response = given()
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
                .when()
                .post();

        response.then().log().all();

        response.then().statusCode(200);

        String responseBody = response.body().asString();
        String jsonBody = responseBody.replaceAll("<html>\\s*<body>|</body>\\s*</html>", "");

        JsonPath jsonPath = new JsonPath(jsonBody);

        int statusCode = jsonPath.getInt("responseCode");
        String message = jsonPath.getString("message");

        MatcherAssert.assertThat(statusCode, Matchers.is(400));
        MatcherAssert.assertThat(message, Matchers.is("Bad request, email parameter is missing in POST request."));
    }

    @Test
    @DisplayName("When the user exists an error message should be returned")
    public void testExistingUser() {
        String email = "testuser@example.com";

        Response response = given()
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
                .when()
                .post();

        response.then().log().all();

        response.then().statusCode(200);

        String responseBody = response.body().asString();
        String jsonBody = responseBody.replaceAll("<html>\\s*<body>|</body>\\s*</html>", "");

        JsonPath jsonPath = new JsonPath(jsonBody);

        int statusCode = jsonPath.getInt("responseCode");
        String message = jsonPath.getString("message");

        MatcherAssert.assertThat(statusCode, Matchers.is(400));
        MatcherAssert.assertThat(message, Matchers.is("Email already exists!"));
    }
}