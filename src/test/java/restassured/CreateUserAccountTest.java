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
                        "company", "Sparta",
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

        io.restassured.path.json.JsonPath jsonPath = new io.restassured.path.json.JsonPath(jsonBody);


        int responseCode = jsonPath.getInt("responseCode");
        String message = jsonPath.getString("message");


        org.junit.Assert.assertEquals("responseCode should be 201", 201, responseCode);
        org.junit.Assert.assertEquals("message should be 'User created!'", "User created!", message);
    }
}