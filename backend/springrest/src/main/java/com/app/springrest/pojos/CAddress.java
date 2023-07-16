package com.app.springrest.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Getter
@Setter
@ToString
@AllArgsConstructor
public class CAddress{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "caid")
	private long id;
	
	@Column(name = "cpincode")
	private long cpincode;
	
	@Column(name = "cstate")
	private String cstate;
	@Column(name = "cdistrict")
	private String cdistrict;
	@Column(name = "carea")
	private String carea;

	@OneToMany(mappedBy = "caddress")
	@JsonIgnoreProperties({"caddress","QtyVcc"})
	private List<Center> center;

	
}