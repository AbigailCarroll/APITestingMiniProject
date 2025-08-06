package restassured;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.UserDetails.UserDetail;
import utils.API;
import utils.Config;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class GetUserDetailByEmail {

    private static Response response;

    @BeforeAll
    public static void beforeAll() {
        RestAssured.registerParser("text/html", Parser.JSON);
        response = RestAssured
                .given()
                .spec(API.getUserDetailByEmailSpec(Config.getEmail()))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();
    }

    @Test
    @DisplayName("TC14 - Status Code is 200")
    public void testStatusCode() {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("User Email Matches Expected")
    public void testUserEmail() {
        UserDetail userDetail = response.as(UserDetail.class);
        MatcherAssert.assertThat(userDetail.getUser().getEmail(), Matchers.is(Config.getEmail()));
    }

    @Test
    @DisplayName("User Info Not Null")
    public void testUserInfoNotNull() {
        UserDetail userDetail = response.as(UserDetail.class);
        MatcherAssert.assertThat(userDetail.getUser().getName(), Matchers.notNullValue());
        MatcherAssert.assertThat(userDetail.getUser().getId(), Matchers.greaterThan(0));
        MatcherAssert.assertThat(userDetail.getUser().getTitle(), Matchers.notNullValue());
    }
}
