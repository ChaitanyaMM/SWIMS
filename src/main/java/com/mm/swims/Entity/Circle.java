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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="circle",schema = "postgres")
@JsonIgnoreProperties(ignoreUnknown = true)

public class Circle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
 	
	@Column(name="circle_Id")
	private long Id;
	
	@Column(name="circle_name")
	private String circle_name;
	
	@Column(name="area_in_kms")
	private long area_in_kms;
	
	@Column(name="calculated_length")
	private long calculated_length;
	
	@Column(name="area_geometry")
	private long area_geometry;
	
	
	
	/*@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="circle_id")
	@IndexColumn(name="idx")
	private List<Division> divisions;*/
	
	//@OneToMany(mappedBy="department")
	/*@OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "circle")
	private Set<Division> division;*/
	
    // @OneToMany(mappedBy = "circle", fetch = FetchType.EAGER)
	//@JsonIgnore
	 
	@JsonManagedReference
    @OneToMany(mappedBy = "circle", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Division> division;
	
    
	
	public Set<Division> getDivision() {
		return division;
	}

	public void setDivision(Set<Division> division) {
		this.division = division;
	}

	public Circle() {

    }

    public Circle(String circle_name, long area_in_kms, long calculated_length ,long area_geometry) {
        this.circle_name = circle_name;
        this.area_in_kms = area_in_kms;
        this.calculated_length = calculated_length;
        this.area_geometry=area_geometry;
    }
	
	
	
 
	public String getCircle_name() {
		return circle_name;
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
	
	 
	public void setCircle_name(String circle_name) {
		this.circle_name = circle_name;
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
	 
	
	
	
	
}
