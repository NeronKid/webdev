package com.serving.accounting.models;

import jakarta.persistence.*;

@Table
@Entity
public class Role {
	
	@Id
	private long id;
	private String role;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Role(long id, String role) {
		this.id = id;
		this.role = role;
	}
	public Role() {
	}
	
}
