package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class API {
    public static final String BASE_URI = ExerciseConfig.getBaseUri();

    public static RequestSpecification createAccountRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(ExerciseConfig.getCreateAccountPath())
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

    public static RequestSpecification verifyLoginRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(ExerciseConfig.getVerifyLoginPath())
                .setContentType(ContentType.URLENC)
                .build();
    }

}
