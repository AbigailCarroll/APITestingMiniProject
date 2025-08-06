package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.API.sendPutRequestToBrandsList;

public class BrandsListPutTest {


    @Test
    public void testPutMethodOnBrandsList_ShouldReturn405InBody() throws Exception {
        Response response = sendPutRequestToBrandsList();

        // Log everything
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Raw Response: " + response.getBody().asString());

        // Extract the JSON string from HTML
        String htmlBody = response.getBody().asString();
        int start = htmlBody.indexOf('{');
        int end = htmlBody.lastIndexOf('}') + 1;
        String jsonString = htmlBody.substring(start, end);

        // Parse the JSON string manually
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonString);

        long responseCode = (long) jsonObject.get("responseCode");
        String message = (String) jsonObject.get("message");

        // Assertions
        assertEquals(405, responseCode);
        assertEquals("This request method is not supported.", message);
    }
}
