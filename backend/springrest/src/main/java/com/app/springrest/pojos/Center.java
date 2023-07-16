package com.app.springrest.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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
@ToString
public class Center{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid")
	private long id;
	@Column(name = "cname")
	private String name;
	@Column(name = "cpassword")
	private String password;
	@Column(name = "carea")
	private String area;
	
	@OneToMany(mappedBy = "center",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("center")
	private List<Booking> booking;
	
	@OneToMany(mappedBy = "center", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"center","user"})
    private List<Review> review=new ArrayList<Review>();

    @OneToMany(mappedBy = "qtyCenter",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("qtyCenter")
    private List<QtyVcc> QtyVcc=new ArrayList<QtyVcc>();
    
    
    @ManyToOne
    @JoinColumn(name = "caid")
    @JsonIgnoreProperties("center")
    private CAddress caddress;

}
