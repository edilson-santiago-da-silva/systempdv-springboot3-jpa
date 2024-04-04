package com.system.pdv.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usersys implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	private Integer id;
	private String email;
	private String passwordsys;
	
	public Usersys() {
	}

	public Usersys(Integer id, String email, String passwordsys) {
		this.id = id;
		this.email= email;
		this.passwordsys = passwordsys;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPasswordsys() {
		return passwordsys;
	}

	public void setPasswordsys(String passwordsys) {
		this.passwordsys = passwordsys;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usersys other = (Usersys) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", passwordsys=" + passwordsys + "]";
	}

	
}
