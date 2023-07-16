package com.app.springrest.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="vstatus")
	private String vaccinationStatus;  // taken / nontaken
	@Column(name="dosecount")
	private int uDoseCount;
	@Column(name="timeslot")
	private String uTimeSlot;
	
	@ManyToOne
	@JoinColumn(name="uddid")
	@JsonIgnoreProperties("booking")
	private Udosedate uDoseDate;
	
	@ManyToOne
	@JoinColumn(name="vid")
	@JsonIgnoreProperties({"booking","QtyVcc"})
	private Vaccine vaccine;
	
	@ManyToOne
	@JoinColumn(name="uid")
	@JsonIgnoreProperties({"booking","review","uaddress"})
	private User user;
	
	@ManyToOne
	@JoinColumn(name="cid")
	@JsonIgnoreProperties({"booking","review"})
	private Center center;
	
}
