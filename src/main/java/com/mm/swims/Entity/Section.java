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
@Table(name="section",schema = "postgres")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Section implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
 	
	@Column(name="section_Id")
	private long Id;
	
	@Column(name="section_name")
	private String section_name;
	
	@Column(name="area_in_kms")
    private long area_in_kms;
	
	@Column(name="calculated_length")
	private long calculated_length;
	
	@Column(name="area_geometry")
	private long area_geometry;
//	private long docket_id;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subdivison_id")
	private SubDivision subdivision;*/
	
	
	/*@OneToMany(cascade = CascadeType.ALL,
		    fetch = FetchType.LAZY,
		    mappedBy = "section")
			private Set<Docket> docket;*/
	
	/*@OneToMany(mappedBy = "section", fetch = FetchType.EAGER)
	private Set<Docket> docket;*/
	
	
	//@JsonBackReference 
	@JsonIgnore
	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Docket> docket;
		
	
	
  
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "subdivision_Id")
	private SubDivision subdivision;
	
	
	public Section() {
		
	}

 

public Section(String section_name, long area_in_kms, long calculated_length ,long area_geometry) {
    this.section_name = section_name;
    this.area_in_kms = area_in_kms;
    this.calculated_length = calculated_length;
    this.area_geometry=area_geometry;
}

	
	public SubDivision getSubdivision() {
		return subdivision;
	}
	public void setSubdivision(SubDivision subdivision) {
		this.subdivision = subdivision;
	}
	
	public long getId() {
		return Id;
	}



	public void setId(long id) {
		Id = id;
	}



	public Set<Docket> getDocket() {
		return docket;
	}



	public void setDocket(Set<Docket> docket) {
		this.docket = docket;
	}



	public void setSection_name(String section_name) {
		this.section_name = section_name;
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
	 

	public String getSection_name() {
		return section_name;
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
	 
	 
	
	
	
}
