package com.app.springrest.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.val;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private long id;
	@Column(name = "ufirstname",length=30)
	private String firstname;
	@Column(name = "umiddlename",length=30)
	private String middlename;
	@Column(name = "ulastname",length=30)
	private String lastname;
	@Column(name = "udob")
	private LocalDate dob;
	@Column(name = "uadhar",length=20, unique=true)
	private String adhar;
	@Column(name = "umobileno",length=13)
	private String mobileno;
	@Column(name = "upassword", nullable=false)
	private String password;

	@Column(name = "uemail", unique=true)
	private String email;
//
//	@Size(min=10,max=60)
	private short age;
	
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"user","center"})
	private List<Booking> booking=new ArrayList<Booking>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"user","center"})
//	@JsonBackReference
	private List<Review> review=new ArrayList<Review>();
	
	@ManyToOne
	@JoinColumn(name = "uaddress")
	@JsonIgnoreProperties("user")
	private UAddress uaddress;


}
