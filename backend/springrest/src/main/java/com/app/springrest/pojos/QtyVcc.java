package com.app.springrest.pojos;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
public class QtyVcc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qid")
	private long id;
	
	@Column(name = "qty")
	private int qty;
	
	
	@ManyToOne
	@JoinColumn(name = "cid")
	@JsonIgnoreProperties({"booking","review"})
	private Center qtyCenter;
	
	@ManyToOne
	@JoinColumn(name = "vid")
	@JsonIgnoreProperties({"booking","qtyvcc"})
	private Vaccine qtyVaccine;

	
}
