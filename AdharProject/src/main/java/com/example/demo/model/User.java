package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//validate property is not null or empty
	@NotEmpty(message = "name should not be empty")
	private String name;
	private String phoneNo;
	
	
	@NotEmpty(message = "city should not be empty")
	private String city;
	private int pincode;
	
	//size annotation validate property has size between min and max value
	@NotEmpty
	@Size(min=4 ,max = 44 , message = "email should have 4 to 44 charactor")
	private String email;
	
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", city=" + city + ", pincode=" + pincode
				+ ", email=" + email + ", password=" + password + "]";
	}
	public User(int id, String name, String phoneNo, String city, int pincode, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.city = city;
		this.pincode = pincode;
		this.email = email;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
