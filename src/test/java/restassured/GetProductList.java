package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

public class GetProductList {


    private static Response response;

    @BeforeAll
    public static void beforeAll()
    {
        response = RestAssured
                .given()
                .spec()
    }
}
