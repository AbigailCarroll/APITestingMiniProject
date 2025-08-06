package pojos.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetail{

	@JsonProperty("user")
	private User user;

	@JsonProperty("responseCode")
	private int responseCode;

	public User getUser(){
		return user;
	}

	public int getResponseCode(){
		return responseCode;
	}
}