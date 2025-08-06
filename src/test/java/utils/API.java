package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class API {


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

    public static RequestSpecification getUserDetailByEmailSpec(String email) {
        return getBaseSpecBuilder(Config.getUserDetailByEmailUri())
                .addQueryParam("email", email)
                .build();
    }


}
