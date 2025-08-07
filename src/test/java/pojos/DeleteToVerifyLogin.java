package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteToVerifyLogin{

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