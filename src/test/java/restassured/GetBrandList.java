package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.BrandList.BrandList;

public class GetBrandList {
    private static Response response;
    private static BrandList brandList;

    @BeforeAll
    public static void setup(){
        response = RestAssured
                .given()
                .spec(utils.API.getBrandList())
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .extract().response();

    }

    @Test
    @DisplayName("Tests the response status code returns 200")
    public void testResponseStatusCode_Returns200() {
        MatcherAssert.assertThat(brandList.getResponseCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("Test the response returns a list of the correct number of products")
    public void testResponse_ReturnsAListOfTheCorrectNumberOfProducts() {
        MatcherAssert.assertThat(brandList.getBrands().size(), Matchers.is(43));
    }
}
