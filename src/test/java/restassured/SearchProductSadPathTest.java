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
import pojos.ProductList.SearchProduct;
import pojos.SearchProductBadRequest;

public class SearchProductSadPathTest {
    private static Response response;
    private static SearchProductBadRequest searchProductBadRequest;

    @BeforeAll
    public static void setup() throws JsonProcessingException {
        response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api")
                .basePath("/searchProduct")
                .contentType("application/x-www-form-urlencoded")
                .accept("application/json")
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .extract().response();

        //Strips away any html tags in response and parses as json
        String rawBody = response.getBody().asString();
        String json = rawBody.replaceAll("(?s)<[^>]*>", "").trim();
        ObjectMapper mapper = new ObjectMapper();
        searchProductBadRequest = mapper.readValue(json, SearchProductBadRequest.class);
    }

    @Test
    @DisplayName("Request returns status code 400")
    public void testStatusCode_Returned400() {
        Integer statusCode = 400;
        MatcherAssert.assertThat(searchProductBadRequest.getResponseCode(), Matchers.is(statusCode));
    }

    @Test
    @DisplayName("Request returns appropriate message")
    public void testReturnsBad_RequestMessage() {
        String message = "Bad request, search_product parameter is missing in POST request.";

        MatcherAssert.assertThat(searchProductBadRequest.getMessage(), Matchers.is(message));
    }
}
