package com.example.groupdepartment.entity;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`User`")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`", unique = true, nullable = false)
	private int id;

	@Column(name = "`username`", nullable = false, length = 50, unique = true)
	private String username;

	@Column(name = "`email`", nullable = false, length = 50, unique = true)
	private String email;

	@Column(name = "`password`", nullable = false, length = 800)
	private String password;

	@Column(name = "`first_name`", nullable = false, length = 50)
	private String firstname;

	@Column(name = "`last_name`", nullable = false, length = 50)
	private String lastname;

	@Formula("concat(first_name, ' ', last_name)")
	private String fullname;

	@Column(name = "role", nullable = false)
	private String role = "Employee";

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "`status`", nullable = false)
	private UserStatus status = UserStatus.NOT_ACTIVE;

	public User(String username, String email, String password, String first_name, String last_name) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstname = first_name;
		this.lastname = last_name;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public String getFullName() {
		return fullname;
	}

	public String getRole() {
		return role;
	}

}