package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class API {

    private static final String BASE_URI = "https://automationexercise.com";
    private static final String POST_PRODUCTS_LIST_PATH = "api/productsList";

    public static RequestSpecification postProductsListRequestSpec() {
        return getBaseSpecBuilder()
                .build();
    }

    private static RequestSpecBuilder getBaseSpecBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(API.POST_PRODUCTS_LIST_PATH)
                .addHeaders(Map.of(
                        "Accept", "*/*"
                ));
    }


}
