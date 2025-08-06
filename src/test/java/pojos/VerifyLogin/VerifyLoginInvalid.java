package pojos.VerifyLogin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VerifyLoginInvalid{

	@JsonProperty("message")
	private String message;

	@JsonProperty("responseCode")
	private int responseCode;

	public String getMessage(){
		return message;
	}

	public int getResponseCode(){
		return responseCode;
	}
}