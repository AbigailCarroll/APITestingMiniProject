package restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utils.API;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserAccountTest {

    @Test
    public void testCreateUserAccountSuccess() {
        // Use a unique email to avoid conflicts
        String uniqueEmail = "testuser_" + System.currentTimeMillis() + "@example.com";

        // Send the parameters as form-urlencoded data
        Response response = given()
                .spec(API.createAccountRequestSpec())
                .formParams(
                        "name", "Test User",
                        "email", uniqueEmail,
                        "password", "password123",
                        "title", "Mr",
                        "birth_date", "15",
                        "birth_month", "05",
                        "birth_year", "1990",
                        "firstname", "John",
                        "lastname", "Doe",
                        "company", "ACME Inc",
                        "address1", "123 Main St",
                        "address2", "Apt 4B",
                        "country", "United States",
                        "zipcode", "12345",
                        "state", "CA",
                        "city", "Los Angeles",
                        "mobile_number", "5551234567"
                )
                .when()
                .post();

        // Log the response and perform explicit assertions
        response.then().log().all();

        // Assert the HTTP status code directly on the response object
        response.then().statusCode(200);

        // Assert the JSON fields from the cleaned-up body string directly
        String responseBody = response.body().asString();
        String jsonBody = responseBody.replaceAll("<html>\\s*<body>|</body>\\s*</html>", "");

        // Use RestAssured's JsonPath to parse the string and assert values
        io.restassured.path.json.JsonPath jsonPath = new io.restassured.path.json.JsonPath(jsonBody);

        // Assert the custom response code and message
        int responseCode = jsonPath.getInt("responseCode");
        String message = jsonPath.getString("message");

        // The assertion should use JUnit's assertion methods for clarity
        org.junit.Assert.assertEquals("responseCode should be 201", 201, responseCode);
        org.junit.Assert.assertEquals("message should be 'User created!'", "User created!", message);
    }
}