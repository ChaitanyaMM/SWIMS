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
@Table(name="docket",schema = "postgres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Docket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
 	
	@Column(name="docket_Id")
	private long Id;
	
	@Column(name="docket_name")
	private String docket_name;
	
	@Column(name="docket_ref_Id")
	private String docket_ref_Id;
	
	@Column(name="area_in_kms")
	private float area_in_kms;
	
	@Column(name="number_of_connections")
	private long number_of_connections;
	
	@Column(name="number_of_sewer_connections")
	private long number_of_sewer_connections;
	
	@Column(name="number_of_manholes")
	private long number_of_manholes;
	
	@Column(name="deep_manholes")
	private long deep_manholes;
	
	@Column(name="contour_low")
	private long contour_low;
	

	@Column(name="contour_high")
	private long contour_high;
	

	@Column(name="length_of_sewermain_kms")
	private float length_sewer_in_kms;
	
	
	//remove from view mean to in table
	/*@Column(name="calculated_length")
	private long calculated_length;
	
	@Column(name="area_geometry")
	private long area_geometry;*/
 	
	/*@ManyToOne
	//(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
	private Section section;*/
	
	@JsonBackReference(value="section-details")
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "section_Id")
	private Section section;
	
	@JsonBackReference(value="subdivision-details")
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "subdivision_Id")
	private SubDivision subdividocket;
	
	@JsonBackReference(value="division-details")
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "division_Id")
	private Division divisiondocket;
	
	@JsonBackReference(value="circle-details")
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "circle_Id")
	private Circle cirledocket;
	
	
	@JsonBackReference
    @OneToMany(mappedBy = "docket", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<SwProblem> problem;
	
	
	public Docket() {
			
		}
	
	public Docket(String docket_name, float area_in_kms, long number_of_connections ,long number_of_manholes,float length_sewer_in_kms, long number_of_sewer_connections,long deep_manholes,long contour_low,long contour_high) {
	    this.docket_name = docket_name;
	    this.area_in_kms = area_in_kms;
	    this.number_of_connections = number_of_connections;
	    this.number_of_manholes=number_of_manholes;;
	    this.length_sewer_in_kms =length_sewer_in_kms;
	    this. number_of_sewer_connections =  number_of_sewer_connections;
	    this.deep_manholes= deep_manholes;
	    this.contour_low = contour_low;
	    this.contour_high= contour_high;
	}
	
	  public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getNumber_of_sewer_connections() {
		return number_of_sewer_connections;
	}

	public void setNumber_of_sewer_connections(long number_of_sewer_connections) {
		this.number_of_sewer_connections = number_of_sewer_connections;
	}


	public String getDocket_name() {
		return docket_name;
	}

	public void setDocket_name(String docket_name) {
		this.docket_name = docket_name;
	}

	public float getArea_in_kms() {
		return area_in_kms;
	}

	public void setArea_in_kms(float area_in_kms) {
		this.area_in_kms = area_in_kms;
	}

	public long getNumber_of_connections() {
		return number_of_connections;
	}

	public void setNumber_of_connections(long number_of_connections) {
		this.number_of_connections = number_of_connections;
	}

	public long getNumber_of_manholes() {
		return number_of_manholes;
	}

	public void setNumber_of_manholes(long number_of_manholes) {
		this.number_of_manholes = number_of_manholes;
	}

	public long getDeep_manholes() {
		return deep_manholes;
	}

	public void setDeep_manholes(long deep_manholes) {
		this.deep_manholes = deep_manholes;
	}

	public float getLength_sewer_in_kms() {
		return length_sewer_in_kms;
	}

	public void setLength_sewer_in_kms(float length_sewer_in_kms) {
		this.length_sewer_in_kms = length_sewer_in_kms;
	}

	public Section getSection() {
		return section;
	  }



	public void setSection(Section section) {
		this.section = section;
	}

 
	 	public Set<SwProblem> getProblem() {
		return problem;
	}

	public void setProblem(Set<SwProblem> problem) {
		this.problem = problem;
	}

	public long getContour_low() {
		return contour_low;
	}

	public void setContour_low(long contour_low) {
		this.contour_low = contour_low;
	}

	public long getContour_high() {
		return contour_high;
	}

	public void setContour_high(long contour_high) {
		this.contour_high = contour_high;
	}

	public SubDivision getSubdividocket() {
		return subdividocket;
	}

	public void setSubdividocket(SubDivision subdividocket) {
		this.subdividocket = subdividocket;
	}

	public Division getDivisiondocket() {
		return divisiondocket;
	}

	public void setDivisiondocket(Division divisiondocket) {
		this.divisiondocket = divisiondocket;
	}

	public Circle getCirledocket() {
		return cirledocket;
	}

	public void setCirledocket(Circle cirledocket) {
		this.cirledocket = cirledocket;
	}



	
	
}