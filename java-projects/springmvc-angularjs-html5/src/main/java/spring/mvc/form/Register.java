package spring.mvc.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Register {
	
	@NotEmpty(message="Username cannot be empty")
	@Size(min=3,max=60,message="Min 3 and Max 60 characters for username")
	private String username;
	
	@NotEmpty(message="Password cannot be empty")
	@Size(min=3,max=60,message="Min 3 and Max 60 characters for password")
	private String password;
	
	@DateTimeFormat(iso=ISO.DATE,pattern="dd-MM-yyyy")
	@NotNull (message="Birthdate can not be null")
	private Date birthdate;

	@NotEmpty(message="Details can not be empty")
	@Size(max=200,message="Max 200 characters for moreDetails")
	private String moreDetails;
	
	private String gender;	
	
	private String education;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getMoreDetails() {
		return moreDetails;
	}
	public void setMoreDetails(String moreDetails) {
		this.moreDetails = moreDetails;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}


}
