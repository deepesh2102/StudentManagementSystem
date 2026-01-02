package com.StudentsManagementSystem.entity;

import org.jspecify.annotations.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String username;
	private String password;
	private String role; //ROLE_ADMIN ROLE_USER
	public String getUsername() {
		return username;
	}
	public @Nullable String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public void setUsername(String userName) {
		this.username = userName;
		
	}
	public void setPassword(@Nullable String encode) {
		password = encode;
		
	}
	public void setRole(String role) {
		this.role = role;
		
	}
	

}
