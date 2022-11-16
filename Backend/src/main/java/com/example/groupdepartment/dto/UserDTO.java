package com.example.groupdepartment.dto;


import com.example.groupdepartment.entity.User;

public class UserDTO {


	// check not null, check length, check exists, check format (regex)...
	private String username;

	// check not null, check length, check exists on database, check format
	// (regex)...
	private String email;

	// check not null, check length, check format (regex)...
	private String password;

	// check not null, check length, check format (regex)...
	private String firstname;

	// check not null, check length, check format (regex)...
	private String lastname;

	public UserDTO(String username, String email, String password, String firstname, String lastname) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public UserDTO() {
	}


	public User toEntity() {
		return new User(username, email, password, firstname, lastname);
	}
}