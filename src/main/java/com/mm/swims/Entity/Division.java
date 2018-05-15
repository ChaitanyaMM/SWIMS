package com.mm.swims.Entity;

import java.io.Serializable;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="division",schema = "postgres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Division implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "division_Id")
	private long Id;

	@Column(name = "division_name")
	private String divison_name;

	@Column(name = "area_in_kms")
	private long area_in_kms;

	@Column(name = "calculated_length")
	private long calculated_length;

	@Column(name = "area_geometry")
	private long area_geometry;

	@JsonBackReference
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "circle_Id")
	private Circle circle;
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "circle_id")
	 */
	// @JsonManagedReference
	//JsonIdentityInfo
	 @JsonIgnore
	 //@JsonManagedReference
	 @OneToMany(mappedBy = "division", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 private Set<SubDivision> subdivision;
	 
	 
	public Division() {

	}

	public Division(String divison_name, long area_in_kms, long calculated_length, long area_geometry) {
		this.divison_name = divison_name;
		this.area_in_kms = area_in_kms;
		this.calculated_length = calculated_length;
		this.area_geometry = area_geometry;
	}

	 

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Set<SubDivision> getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(Set<SubDivision> subdivision) {
		this.subdivision = subdivision;
	}

	public String getDivison_name() {
		return divison_name;
	}

	public long getArea_in_kms() {
		return area_in_kms;
	}

	public long getCalculated_length() {
		return calculated_length;
	}

	public long getArea_geometry() {
		return area_geometry;
	}

	
	public void setDivison_name(String divison_name) {
		this.divison_name = divison_name;
	}

	public void setArea_in_kms(long area_in_kms) {
		this.area_in_kms = area_in_kms;
	}

	public void setCalculated_length(long calculated_length) {
		this.calculated_length = calculated_length;
	}

	public void setArea_geometry(long area_geometry) {
		this.area_geometry = area_geometry;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	 

}
