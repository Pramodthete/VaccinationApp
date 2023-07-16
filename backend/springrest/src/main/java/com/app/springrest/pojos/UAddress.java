package com.app.springrest.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class UAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uaid")
	private long id;
	@Column(name = "upincode")
	private long upincode;
	@Column(name = "ustate")
	private String ustate;
	@Column(name = "udistrict")	
	private String udistrict;
	@Column(name = "uarea")
	private String uarea;
	
	@OneToMany(mappedBy = "uaddress",cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"review","booking","uaddress"})
	private List<User> user;
	
}
