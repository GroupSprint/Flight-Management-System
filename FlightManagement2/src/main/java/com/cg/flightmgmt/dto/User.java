package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	private BigInteger userId;

	@NotEmpty(message = "Type should not be empty")
	private String userType;

	@NotEmpty(message = "userName should not be empty")
	@Size(min = 2, message = "Should be more than 2 chars")
	private String userName;

	@NotEmpty(message = "Password should not be empty")
	@Size(min = 6, message = "Should be more than 6 chars")
	private String password;

	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Enter Valid mail id")
	private String email;

	@NotEmpty(message = "Mobile should not be empty")
	@Size(min = 10, max = 10, message = "Should be exact 10 chars")
	private String mobileNumber;

	// Constructors for user
	public User() {
		super();
	}

	public User(@NotEmpty(message = "Name should not be empty") String userType,
			@NotEmpty(message = "userName should not be empty") @Size(min = 2, message = "Should be more than 2 chars") String userName,
			String password, String email, String mobileNumber) {
		super();
		this.userType = userType;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public User(BigInteger userId, @NotEmpty(message = "Name should not be empty") String userType,
			@NotEmpty(message = "userName should not be empty") @Size(min = 2, message = "Should be more than 2 chars") String userName,
			String password, String email, String mobileNumber) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	// Getters and Setter for user
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//toString method for users
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
	}

}
