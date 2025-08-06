package pojos.ProductList;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchProduct{

	@JsonProperty("responseCode")
	private int responseCode;

	@JsonProperty("products")
	private List<ProductsItem> products;

	public int getResponseCode(){
		return responseCode;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}
}