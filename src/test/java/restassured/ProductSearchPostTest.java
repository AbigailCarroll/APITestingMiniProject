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
import pojos.ProductList.SearchProduct;
import pojos.ProductList.ProductsItem;
import pojos.ProductList.SearchProduct;
import java.util.List;

public class ProductSearchPostTest {
    private static Response response;
    private static SearchProduct searchProduct;

    @BeforeAll
    public static void setup() throws JsonProcessingException {
        response = RestAssured
                .given()
                    .baseUri("https://automationexercise.com/api")
                    .basePath("/searchProduct")
                    .contentType("application/x-www-form-urlencoded")
                    .accept("application/json")
                    .formParam("search_product", "shirt")
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
        searchProduct = mapper.readValue(json, SearchProduct.class);
    }

    @Test
    @DisplayName("Tests the response status code returns 200")
    public void testResponseStatusCode_Returns200() {
        Integer statusCode = 200;
        MatcherAssert.assertThat(searchProduct.getResponseCode(), Matchers.is(statusCode));
    }

    @Test
    @DisplayName("Test the response returns a list of products")
    public void testResponse_ReturnsAListOfProducts() {
        Integer numProductItems = 13;

        MatcherAssert.assertThat(searchProduct.getProducts().size(), Matchers.is(numProductItems));
    }

    //TODO: Ensure all category items have a search term t-shirt
    /**
     * Method1:
     *
     * -Get list of product items
     * -for each product item
     *      -get category object
     *      -get category "category" name
     *      -if category name does not contains t-shirt
     *          - false
     * -return true
     */

    @Test
    @DisplayName("Ensure category contains shirt key word")
    public void testResponse_ReturnsProductItemsWithShirtInKeyword() {
        List<ProductsItem> products = searchProduct.getProducts();

        for(ProductsItem product: products) {
            MatcherAssert.assertThat(product.getCategory().getCategory().toLowerCase().contains("shirt"), Matchers.is(true));
        }
    }
}
