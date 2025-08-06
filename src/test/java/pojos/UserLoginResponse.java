package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginResponse {

    @JsonProperty("responseCode")
    private int responseCode;

    @JsonProperty("message")
    private String message;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}