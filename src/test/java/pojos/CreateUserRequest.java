package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest {

	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("password")
	private String password;
	@JsonProperty("title")
	private String title;
	@JsonProperty("birth_date")
	private String birthDate;
	@JsonProperty("birth_month")
	private String birthMonth;
	@JsonProperty("birth_year")
	private String birthYear;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("company")
	private String company;
	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String address2;
	@JsonProperty("country")
	private String country;
	@JsonProperty("zipcode")
	private String zipcode;
	@JsonProperty("state")
	private String state;
	@JsonProperty("city")
	private String city;
	@JsonProperty("mobile_number")
	private String mobileNumber;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getBirthDate() { return birthDate; }
	public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
	public String getBirthMonth() { return birthMonth; }
	public void setBirthMonth(String birthMonth) { this.birthMonth = birthMonth; }
	public String getBirthYear() { return birthYear; }
	public void setBirthYear(String birthYear) { this.birthYear = birthYear; }
	public String getFirstname() { return firstname; }
	public void setFirstname(String firstname) { this.firstname = firstname; }
	public String getLastname() { return lastname; }
	public void setLastname(String lastname) { this.lastname = lastname; }
	public String getCompany() { return company; }
	public void setCompany(String company) { this.company = company; }
	public String getAddress1() { return address1; }
	public void setAddress1(String address1) { this.address1 = address1; }
	public String getAddress2() { return address2; }
	public void setAddress2(String address2) { this.address2 = address2; }
	public String getCountry() { return country; }
	public void setCountry(String country) { this.country = country; }
	public String getZipcode() { return zipcode; }
	public void setZipcode(String zipcode) { this.zipcode = zipcode; }
	public String getState() { return state; }
	public void setState(String state) { this.state = state; }
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	public String getMobileNumber() { return mobileNumber; }
	public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
}