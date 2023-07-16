package com.app.springrest.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.app.springrest.pojos.Center;
import com.app.springrest.pojos.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class UserDto {

	private long id;
	private String firstname;
	private String middlename;
	private String lastname;
	private LocalDate dob;
	private String adhar;
	private String mobileno;
	@JsonIgnore
	private String password;
	private short dosecount;
	private String email;

	private String paystatus;
	
	private short age;

	public UserDto(long id, String firstname, String middlename, String lastname, LocalDate dob, String adhar,
			String mobileno, short dosecount, String email, String paystatus, short age) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dob = dob;
		this.adhar = adhar;
		this.mobileno = mobileno;
		this.dosecount = dosecount;
		this.email = email;
		this.paystatus = paystatus;
		this.age = age;
	}

	public UserDto(long id, String firstname, String middlename, String lastname, LocalDate dob, String adhar,
			String mobileno, String password, short dosecount, String email, String paystatus, short age) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dob = dob;
		this.adhar = adhar;
		this.mobileno = mobileno;
		this.password = password;
		this.dosecount = dosecount;
		this.email = email;
		this.paystatus = paystatus;
		this.age = age;
	}
	
	
	
}
