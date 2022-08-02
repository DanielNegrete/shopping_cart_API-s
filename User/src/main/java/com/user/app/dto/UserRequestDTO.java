package com.user.app.dto;

import javax.validation.constraints.NotEmpty;

public class UserRequestDTO {
	
	@NotEmpty(message = "Username should not be empty")
	private String name;
	@NotEmpty(message = "Email should not be empty")
	private String email;
	@NotEmpty(message = "Password should not be empty")
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

}
