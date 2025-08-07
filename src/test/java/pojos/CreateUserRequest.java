package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest{

	@JsonProperty("country")
	private String country;

	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("address2")
	private String address2;

	@JsonProperty("city")
	private String city;

	@JsonProperty("birth_month")
	private String birthMonth;

	@JsonProperty("address1")
	private String address1;

	@JsonProperty("birth_date")
	private String birthDate;

	@JsonProperty("title")
	private String title;

	@JsonProperty("birth_year")
	private String birthYear;

	@JsonProperty("lastname")
	private String lastname;

	@JsonProperty("zipcode")
	private String zipcode;

	@JsonProperty("password")
	private String password;

	@JsonProperty("name")
	private String name;

	@JsonProperty("company")
	private String company;

	@JsonProperty("state")
	private String state;

	@JsonProperty("mobile_number")
	private String mobileNumber;

	@JsonProperty("email")
	private String email;

	public String getCountry(){
		return country;
	}

	public String getFirstname(){
		return firstname;
	}

	public String getAddress2(){
		return address2;
	}

	public String getCity(){
		return city;
	}

	public String getBirthMonth(){
		return birthMonth;
	}

	public String getAddress1(){
		return address1;
	}

	public String getBirthDate(){
		return birthDate;
	}

	public String getTitle(){
		return title;
	}

	public String getBirthYear(){
		return birthYear;
	}

	public String getLastname(){
		return lastname;
	}

	public String getZipcode(){
		return zipcode;
	}

	public String getPassword(){
		return password;
	}

	public String getName(){
		return name;
	}

	public String getCompany(){
		return company;
	}

	public String getState(){
		return state;
	}

	public String getMobileNumber(){
		return mobileNumber;
	}

	public String getEmail(){
		return email;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}