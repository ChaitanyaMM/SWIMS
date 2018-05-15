package com.mm.swims.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="sw_sewerbranch")
@JsonIgnoreProperties(ignoreUnknown = true)

public class SwSewerBranch implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
 	
	@Column(name="sewerbranch_Id")
	private long Id;
	
	@Column(name="sewer_name")
    private String sewer_name;
	
	@Column(name="material_type")
    private String material_type;
	
	@Column(name="diameter")
    private long diameter;
	
	@Column(name="date_of_commission")
    private Date date_of_commission;
	
	@Column(name="docket_id")
    private long docket_id;
	
	@Column(name="number_of_connections")
    private long number_of_connections;
	
	@Column(name="line_geometry")
    private String line_geometry;
	
	@Column(name="length_in_meters")
    private long length_in_meters;
	
	@Column(name="calculate_length_in_meters")
    private long calculate_length_in_meters;
	
	
	 
	public String getSewer_name() {
		return sewer_name;
	}
	public String getMaterial_type() {
		return material_type;
	}
	public long getDiameter() {
		return diameter;
	}
	public Date getDate_of_commission() {
		return date_of_commission;
	}
	public long getDocket_id() {
		return docket_id;
	}
	public long getNumber_of_connections() {
		return number_of_connections;
	}
	public String getLine_geometry() {
		return line_geometry;
	}
	public long getLength_in_meters() {
		return length_in_meters;
	}
	public long getCalculate_length_in_meters() {
		return calculate_length_in_meters;
	}
	 
	public void setSewer_name(String sewer_name) {
		this.sewer_name = sewer_name;
	}
	public void setMaterial_type(String material_type) {
		this.material_type = material_type;
	}
	public void setDiameter(long diameter) {
		this.diameter = diameter;
	}
	public void setDate_of_commission(Date date_of_commission) {
		this.date_of_commission = date_of_commission;
	}
	public void setDocket_id(long docket_id) {
		this.docket_id = docket_id;
	}
	public void setNumber_of_connections(long number_of_connections) {
		this.number_of_connections = number_of_connections;
	}
	public void setLine_geometry(String line_geometry) {
		this.line_geometry = line_geometry;
	}
	public void setLength_in_meters(long length_in_meters) {
		this.length_in_meters = length_in_meters;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public void setCalculate_length_in_meters(long calculate_length_in_meters) {
		this.calculate_length_in_meters = calculate_length_in_meters;
	}
	 



}
