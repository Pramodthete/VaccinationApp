//package com.app.springrest.pojos;
//
//import java.sql.Time;
//
//import javax.persistence.AttributeOverride;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@NoArgsConstructor
//@Table
//@JsonIgnoreProperties
//public class Utimeslot{
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "tid")
//	private long id;
//	
//	@Column(name="utimeslot")
//	private String utimeslot;
//	
//	@ManyToOne
//	@JoinColumn(name ="did")
//	@JsonIgnoreProperties("utimeslot")
//	private Udosedate udosedate;
//	
//	@ManyToOne
//	@JoinColumn(name ="uid")
//	private User tuser;
//
//	public Utimeslot(long id, String utimeslot, Udosedate udosedate, User tuser) {
//		super();
//		this.id = id;
//		this.utimeslot = utimeslot;
//		this.udosedate = udosedate;
//		this.tuser = tuser;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getUtimeslot() {
//		return utimeslot;
//	}
//
//	public void setUtimeslot(String utimeslot) {
//		this.utimeslot = utimeslot;
//	}
//
//	public Udosedate getUdosedate() {
//		return udosedate;
//	}
//
//	public void setUdosedate(Udosedate udosedate) {
//		this.udosedate = udosedate;
//	}
//
//	public User getTuser() {
//		return tuser;
//	}
//
//	public void setTuser(User tuser) {
//		this.tuser = tuser;
//	}
//
//	@Override
//	public String toString() {
//		return "Utimeslot [id=" + id + ", utimeslot=" + utimeslot + ", udosedate=" + udosedate + ", tuser=" + tuser
//				+ "]";
//	}
//
//	
//	
//
//
//
//}
