package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtils {

    public static Response sendPutRequestToBrandsList() {
        String baseUri = ConfigReader.getProperty("automationexcercise.base_uri");
        String apiPath = ConfigReader.getProperty("automationexcercise.api_path.get_all");

        return RestAssured
                .given()
                .baseUri(baseUri)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body("{ \"dummy\": \"data\" }") // Add body to trigger error on PUT
                .when()
                .put(apiPath)
                .then()
                .log().all()
                .extract().response();
    }
}
