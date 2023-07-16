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
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rid")
	private long id;
	@Column(name = "rating")
	private byte rating;
	@Column(name = "rdata")
	private String data;
	
	@ManyToOne
    @JoinColumn(name = "uid")
	@JsonIgnoreProperties({"review","booking"})
    private User user;
	
	@JsonIgnoreProperties({"review","QtyVcc","booking"})
	@ManyToOne
    @JoinColumn(name = "cid")
    private Center center;
	
}
