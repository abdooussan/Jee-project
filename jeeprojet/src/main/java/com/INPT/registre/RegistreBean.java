package com.INPT.registre;

import java.io.Serializable;

public class RegistreBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String secondname;
	private String username;
	private String email;
	private String password;
	private int id;

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailname) {
		this.email = emailname;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
}
