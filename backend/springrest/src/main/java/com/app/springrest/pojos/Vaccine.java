package com.app.springrest.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
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
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vid")
	private long id;
	
	@Column(name = "vaccine_name")
	private String vaccineName;
	
	@OneToMany(mappedBy = "qtyVaccine")
	@JsonIgnoreProperties({"qtyCenter","qtyVaccine"})
	private List<QtyVcc> qtyvcc=new ArrayList<QtyVcc>();
	
	@OneToMany(mappedBy = "vaccine")
	@JsonIgnoreProperties({"vaccine","center","user","uDoseDate"})
	private List<Booking> booking;

	
}
