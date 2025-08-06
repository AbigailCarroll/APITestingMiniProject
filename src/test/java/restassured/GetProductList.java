package restassured;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.ProductList.ProductList;
import pojos.ProductList.ProductsItem;
import utils.API;

public class GetProductList {

    private static Response response;

    @BeforeAll
    public static void beforeAll()
    {
        RestAssured.registerParser("text/html", Parser.JSON);
        response = RestAssured
                .given()
                .spec(API.getProductListSpec())
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .get()
                .then()
                .log().all()
                .extract().response();

    }

    @Test
    @DisplayName("Status Code is 200")
    public void testStatusCode()
    {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }

    @Test
    public void testFirstItem()
    {
        ProductList productList = response.as(ProductList.class);
        MatcherAssert.assertThat(productList.getProducts().get(0).getName(), Matchers.is("Blue Top"));
        MatcherAssert.assertThat(productList.getProducts().get(0).getPrice(), Matchers.is("Rs. 500"));
        MatcherAssert.assertThat(productList.getProducts().get(0).getId(), Matchers.is(1));
        MatcherAssert.assertThat(productList.getProducts().get(0).getBrand(), Matchers.is("Polo"));
    }

    @Test
    public void testNotNull()
    {
        ProductList productList = response.as(ProductList.class);
        for (ProductsItem i : productList.getProducts())
        {
            MatcherAssert.assertThat(isNotNull(i), Matchers.is(true));
        }
    }

    public boolean isNotNull(ProductsItem item)
    {//returns true if there are no null/empty values
        return !(item.getBrand().isEmpty() && item.getCategory() == null && item.getId() == 0 && item.getPrice().isEmpty() && item.getName().isEmpty());
    }
}
