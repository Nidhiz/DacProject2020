package com.ohm.pojos;



//import java.time.LocalDate;
//import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "user" )
public class User {

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@NotBlank(message = "Please enter your name ")
	@Size(min = 2, message = "Name must be more than 2 character")
	@Column(name = "username")
	private String userName;
	
	
	@NotBlank(message = "Please Enter Your Email")
	@Email(message = "Please Enter Valid Email")
	@Column(name = "email", unique = true)
	private String email;

	
	@NotBlank(message = "Please enter your name ")
	@Size(min = 4, message = "Invalid Password, enter atleast 4 character")
	@Column(name = "password")
	private String password;
	
	@NotBlank(message = "Please enter your Address ")
	@Column(name = "address")
	private String address;
	
	@NotBlank(message = "Please enter your Phone no ")
	@Size(min=10,max = 10 ,message = "Enter 10 digit phone no")
	@Column(name = "contactno")
	private String contactNo;
	
	@Column(name = "dob")
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dob;
	
	@NotBlank(message = "Please enter your City ")
	@Column(name = "city")
	private String city;
	
	@NotBlank(message = "Please enter your State ")
	@Column(name = "state")
	private String state;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private ROLENAME role;
	
	public ROLENAME getRole() {
		return role;
	}

	public void setRole(ROLENAME roles) {
		this.role = roles;
	}

	/*@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinColumn( name = "role_id", referencedColumnName = "roleid")
	
	 private Role roles ;*/

	
	public User() {
		System.out.println("in ctor of "+getClass().getName());
	}


	public User(Long userId, String userName, String email, String password, String address, String contactNo,
			String dob, String city, String state, String gender, ROLENAME role){//, Role roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contactNo = contactNo;
		this.dob = dob;
		this.city = city;
		this.state = state;
		this.gender = gender;
		this.role = role;
		//this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	/*public Role getRoles() {
		return roles;
	}


	public void setRoles(Role roles) {
		this.roles = roles;
	}
*/

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", contactNo=" + contactNo + ", expDate=" + dob + ", city=" + city
				+ ", state=" + state + ", gender=" + gender +  "]";
	}

	

}
