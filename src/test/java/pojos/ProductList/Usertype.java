package pojos.ProductList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usertype{

	@JsonProperty("usertype")
	private String usertype;

	public String getUsertype(){
		return usertype;
	}
}