package com.user.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "user_profile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Length(max=20)
	@NotNull
	private String firstName;
	@Length(max=20)
	@NotNull
	private String lastName;
	@Email(message="Email Address format not specified")
	@NotNull
	private String emailId;
	@Min(1000000000L)
	@Max(9999999999L)
//	@Pattern(regexp="(^$|[0-9]{10})")
	private Long mobileNumber;
	@Size(min = 7, max = 15, message = "Password should have at least 7 or less than 15 characters and minimun one special character")
	@Pattern(regexp="?=.*?[#?!@$%^&*-]", message="Password should have at least 7 or less than 15 characters and minimun one special character")
	private String password;
	@Length(max=20)
	@NotNull
	private String nationality;
	@Size(min = 7, max = 12, message = "Passport Number should have at least 7 or less than 13 characters")
	private String passportNumber;
	@Length(max=200)
	@NotNull
	private String permanentAddress;
	@Length(max=200)
	@NotNull
	private String officeAddress;
	@Min(100000000000L)
	@Max(999999999999L)
	private Long personalIdentificationNumber;
	
	public UserProfile(int userId, String firstName, String lastName, String emailId, Long mobileNumber,
			String password, String nationality, String passportNumber, String permanentAddress, String officeAddress,
			Long personalIdentificationNumber) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.nationality = nationality;
		this.passportNumber = passportNumber;
		this.permanentAddress = permanentAddress;
		this.officeAddress = officeAddress;
		this.personalIdentificationNumber = personalIdentificationNumber;
	}
	public UserProfile() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmaiId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Long getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}
	public void setPersonalIdentificationNumber(Long personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}
	
	
	
	
	
	

}
