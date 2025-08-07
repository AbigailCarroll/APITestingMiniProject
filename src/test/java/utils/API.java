package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class API {
    public static final String BASE_URI = Config.getBaseUri();

    public static RequestSpecification createAccountRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(Config.getCreateAccountPath())
                .setContentType(ContentType.URLENC) // Set the Content-Type for the request
                .build();
    }

    public static RequestSpecification getProductListSpec()
    {
        return getBaseSpecBuilder(Config.getAllProductsUri())
                .build();
    }

    public static RequestSpecification postProductListSpec()
    {
        return getBaseSpecBuilder(Config.postAllProductsUri())
                .build();
    }

    public static RequestSpecBuilder getBaseSpecBuilder(String path)
    {
        return new RequestSpecBuilder()
                .setBaseUri(Config.getBaseUri())
                .setBasePath(path);
    }

    public static RequestSpecification putBrandsListSpec() {
        return getBaseSpecBuilder(Config.getAllUri())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }


    public static RequestSpecification verifyLoginRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(Config.getVerifyLoginPath())
                .setContentType(ContentType.URLENC)
                .build();
    }


}
