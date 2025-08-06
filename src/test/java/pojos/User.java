package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User{

	@JsonProperty("password")
	private String password;

	@JsonProperty("birth_month")
	private String birthMonth;

	@JsonProperty("birth_date")
	private String birthDate;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("email")
	private String email;

	@JsonProperty("birth_year")
	private String birthYear;

	public String getPassword(){
		return password;
	}

	public String getBirthMonth(){
		return birthMonth;
	}

	public String getBirthDate(){
		return birthDate;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getEmail(){
		return email;
	}

	public String getBirthYear(){
		return birthYear;
	}
}