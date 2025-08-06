package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;

public class API {



    public static RequestSpecification getProductListSpec()
    {
        return getBaseSpecBuilder(Config.getAllProductsUri())
                .build();
    }

    public static RequestSpecification getBrandList(){
        return getBaseSpecBuilder(Config.getBrandsListUri())
                .build();
    }

    public static RequestSpecBuilder getBaseSpecBuilder(String path)
    {
        return new RequestSpecBuilder()
                .setBaseUri(Config.getBaseUri())
                .setBasePath(path);
    }
}
