package com.mm.swims.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="sw_manhole")

public class SwManhole implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
 	
	@Column(name="manhole_Id")
	private long Id;
	
	@Column(name="location")
    private String location;
	
	@Column(name="docket_id")
    private long docket_id ; //(join record with service area table)
	
	@Column(name="manhole_type")
    private int manhole_type; //(Enum)
	
	@Column(name="manhole_diameter")
    private long manhole_diameter;
	
	@Column(name="manhole_cover_type")
    private String manhole_cover_type;
	
	@Column(name="safetygril")
    private String  safetygril;
	
	@Column(name="ground_level")
    private String ground_level;
	
	@Column(name="invert_level")
    private	String invert_level;
	
	@Column(name="pipe_diameter")
    private String	pipe_diameter;
	
	@Column(name="trunk_sewer_name")
    private String	trunk_sewer_name;
	
	@Column(name="branch_sewer_name")
    private	String branch_sewer_name;
	
	@Column(name="schedule_maintenance_data")
    private	String schedule_maintenance_data;
	
	@Column(name="remarks")
    private	String remarks;
	
	@Column(name="location_geometry")
    private String	location_geometry;
	
	
	 
	public void setLocation(String location) {
		this.location = location;
	}
	public void setDocket_id(long docket_id) {
		this.docket_id = docket_id;
	}
	public void setManhole_type(int manhole_type) {
		this.manhole_type = manhole_type;
	}
	public void setManhole_diameter(long manhole_diameter) {
		this.manhole_diameter = manhole_diameter;
	}
	public void setManhole_cover_type(String manhole_cover_type) {
		this.manhole_cover_type = manhole_cover_type;
	}
	public void setSafetygril(String safetygril) {
		this.safetygril = safetygril;
	}
	public void setGround_level(String ground_level) {
		this.ground_level = ground_level;
	}
	public void setInvert_level(String invert_level) {
		this.invert_level = invert_level;
	}
	public void setPipe_diameter(String pipe_diameter) {
		this.pipe_diameter = pipe_diameter;
	}
	public void setTrunk_sewer_name(String trunk_sewer_name) {
		this.trunk_sewer_name = trunk_sewer_name;
	}
	public void setBranch_sewer_name(String branch_sewer_name) {
		this.branch_sewer_name = branch_sewer_name;
	}
	public void setSchedule_maintenance_data(String schedule_maintenance_data) {
		this.schedule_maintenance_data = schedule_maintenance_data;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setLocation_geometry(String location_geometry) {
		this.location_geometry = location_geometry;
	}
	 
	public String getLocation() {
		return location;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public long getDocket_id() {
		return docket_id;
	}
	public int getManhole_type() {
		return manhole_type;
	}
	public long getManhole_diameter() {
		return manhole_diameter;
	}
	public String getManhole_cover_type() {
		return manhole_cover_type;
	}
	public String getSafetygril() {
		return safetygril;
	}
	public String getGround_level() {
		return ground_level;
	}
	public String getInvert_level() {
		return invert_level;
	}
	public String getPipe_diameter() {
		return pipe_diameter;
	}
	public String getTrunk_sewer_name() {
		return trunk_sewer_name;
	}
	public String getBranch_sewer_name() {
		return branch_sewer_name;
	}
	public String getSchedule_maintenance_data() {
		return schedule_maintenance_data;
	}
	public String getRemarks() {
		return remarks;
	}
	public String getLocation_geometry() {
		return location_geometry;
	}
	
	
	 


}
