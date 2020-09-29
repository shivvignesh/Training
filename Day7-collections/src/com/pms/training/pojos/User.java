package com.pms.training.pojos;

import java.time.LocalDate;

public class User {

	private String uname;
	private String password;
	private String role;
	private LocalDate dob;
	private long contactNumber;
	
	public User(String uname, String password, String role, LocalDate dob, long contactNumber) {
		//super();
		this.uname = uname;
		this.password = password;
		this.role = role;
		this.dob = dob;
		this.contactNumber = contactNumber;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", password=" + password + ", role=" + role + ", dob=" + dob
				+ ", contactNumber=" + contactNumber + "]";
	}
	
	
}
