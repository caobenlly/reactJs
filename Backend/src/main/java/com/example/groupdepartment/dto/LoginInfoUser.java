package com.example.groupdepartment.dto;

public class LoginInfoUser {

	private String token;

	// check not null, check length, check exists, check format (regex)...
	private String userName;

	// check not null, check length, check exists on database, check format
	// (regex)...
	private String email;

	// check not null, check length, check format (regex)...
	private String firstName;

	// check not null, check length, check format (regex)...
	private String lastName;

	private String role;

	private String status;

	public LoginInfoUser(String token, String userName, String email, String firstName, String lastName, String role,
                         String status) {
		this.token = token;
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRole() {
		return role;
	}

	public String getStatus() {
		return status;
	}

}
