package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.ProductList.PostProductListPOJO;
import utils.API;

public class PostProductList {
    private static Response response;
    static PostProductListPOJO postProductListPOJO;

    @BeforeAll
    public static void setup() {

        RestAssured.registerParser("text/html", Parser.JSON);


        response = RestAssured
                .given()
                    .spec(API.postProductListSpec())
                .when()
                    .post()
                .then()
                .log().all()
                .extract().response();

        postProductListPOJO = response.as(PostProductListPOJO.class);

    }

    @DisplayName("Post request returns status code 405")
    @Test
    public void postRequestReturn405StatusCode() {

        MatcherAssert.assertThat(postProductListPOJO.getResponseCode(), Matchers.is(405));


    }
}
