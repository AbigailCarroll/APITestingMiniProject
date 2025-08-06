package pojos.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private int id;
	private String name;
	private String email;
	private String title;

	@JsonProperty("birth_day")
	private String birthDay;

	@JsonProperty("birth_month")
	private String birthMonth;

	@JsonProperty("birth_year")
	private String birthYear;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	private String company;

	@JsonProperty("address1")
	private String address1;

	@JsonProperty("address2")
	private String address2;

	private String country;
	private String state;
	private String city;
	private String zipcode;

	// Getters only (you can generate setters if needed)

	public int getId() { return id; }

	public String getName() { return name; }

	public String getEmail() { return email; }

	public String getTitle() { return title; }

	public String getBirthDay() { return birthDay; }

	public String getBirthMonth() { return birthMonth; }

	public String getBirthYear() { return birthYear; }

	public String getFirstName() { return firstName; }

	public String getLastName() { return lastName; }

	public String getCompany() { return company; }

	public String getAddress1() { return address1; }

	public String getAddress2() { return address2; }

	public String getCountry() { return country; }

	public String getState() { return state; }

	public String getCity() { return city; }

	public String getZipcode() { return zipcode; }
}
