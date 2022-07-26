package com.user.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.user.demo.entity.UserProfile;

public class UserProfileDTO {
	
	@NotNull
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
	public void setEmailId(String emailId) {
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
	public UserProfileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserProfileDTO(@NotNull int userId, @Length(max = 20) @NotNull String firstName,
			@Length(max = 20) @NotNull String lastName,
			@Email(message = "Email Address format not specified") @NotNull String emailId,
			@Min(1000000000L) @Max(9999999999L) Long mobileNumber,
			@Size(min = 7, max = 15, message = "Password should have at least 7 or less than 15 characters and minimun one special character") @Pattern(regexp = "?=.*?[#?!@$%^&*-]", message = "Password should have at least 7 or less than 15 characters and minimun one special character") String password,
			@Length(max = 20) @NotNull String nationality,
			@Size(min = 7, max = 12, message = "Passport Number should have at least 7 or less than 13 characters") String passportNumber,
			@Length(max = 200) @NotNull String permanentAddress, @Length(max = 200) @NotNull String officeAddress,
			@Min(100000000000L) @Max(999999999999L) Long personalIdentificationNumber) {
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
	
	public static UserProfile convertDTOToEntity(UserProfileDTO dto) {
		UserProfile userProfile = new UserProfile();
		
		userProfile.setFirstName(dto.getFirstName());
		userProfile.setLastName(dto.getLastName());
		userProfile.setEmaiId(dto.getEmailId());
		userProfile.setMobileNumber(dto.getMobileNumber());
		userProfile.setPassportNumber(dto.getPassportNumber());
		userProfile.setPassword(dto.getPassword());
		userProfile.setNationality(dto.getNationality());
		userProfile.setPermanentAddress(dto.getPermanentAddress());
		userProfile.setOfficeAddress(dto.getOfficeAddress());
		userProfile.setPersonalIdentificationNumber(dto.getPersonalIdentificationNumber());
		
		return userProfile;
		
	}
	

}
