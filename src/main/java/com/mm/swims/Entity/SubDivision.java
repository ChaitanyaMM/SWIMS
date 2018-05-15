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
@Table(name="subdivison",schema = "postgres")
@JsonIgnoreProperties(ignoreUnknown = true)


public class SubDivision implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
 	
	@Column(name="subdivison_Id")
	private long Id;
	
	@Column(name="subdivison_name")
	private String subdivison_name;
	
	@Column(name="area_in_kms")
	private long area_in_kms;
	
	@Column(name="calculated_length")
	private long calculated_length;
	
	@Column(name="area_geometry")
	private long area_geometry;
	
 
	 
	// @JsonManagedReference
	@JsonIgnore
	 @OneToMany(mappedBy = "subdivision", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 private Set<Section> section;
	
	 //for stopping hirerachy
	//@JsonBackReference 
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "division_Id")
	private Division division;
			
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Set<Section> getSection() {
		return section;
	}
	public void setSection(Set<Section> section) {
		this.section = section;
	}
	public Division getDivision() {
		return division;
	}
	public void setDivision(Division division) {
		this.division = division;
	}
	
	public String getSubdivison_name() {
		return subdivison_name;
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
	 
	
	public void setSubdivison_name(String subdivison_name) {
		this.subdivison_name = subdivison_name;
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
	 
	 
	
	public  SubDivision() {
		// TODO Auto-generated constructor stub
	

    }

    public SubDivision(String subdivison_name, long area_in_kms, long calculated_length ,long area_geometry) {
        this.subdivison_name = subdivison_name;
        this.area_in_kms = area_in_kms;
        this.calculated_length = calculated_length;
        this.area_geometry=area_geometry;
    }
	
	
}
