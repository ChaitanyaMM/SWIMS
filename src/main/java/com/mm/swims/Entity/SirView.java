package com.mm.swims.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.ManagedBean;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@ManagedBean
@Entity
@Table(name="sir_view")
//@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedQuery(name = "SirView.findAllwithproblem", query="select sv from SirView sv")

public class SirView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="docket_id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long Id;
	
	@Column(name="docket_name")
	private String docket_name;
	
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
	
	@Column(name="length_of_sewermain_kms")
	private float length_sewer_in_kms;
	
	@Column(name="sewer_connected_to_storm")
	private long sewer_connected_to_storm;
	
	@Column(name="storm_connected_to_sewer")
	private long storm_connected_to_sewer;
	
	@Column(name="sewer_passing_under_private_building")
	private long sewer_passing_under_private_building;
	
	@Column(name="gap_in_sewer")
	private long gap_in_sewer;
	
	//@JsonBackReference
	//@OneToMany(mappedBy = "section", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   //@Embedded
   /* @AttributeOverrides( {
    @AttributeOverride(name="Id", column = @Column(name="docket_Id") ),
    } )*/
	@OneToOne
	@PrimaryKeyJoinColumn
	private Docket docket;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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

	public void setArea_in_kms(long area_in_kms) {
		this.area_in_kms = area_in_kms;
	}

	public long getNumber_of_connections() {
		return number_of_connections;
	}

	public void setNumber_of_connections(long number_of_connections) {
		this.number_of_connections = number_of_connections;
	}

	public long getNumber_of_sewer_connections() {
		return number_of_sewer_connections;
	}

	public void setNumber_of_sewer_connections(long number_of_sewer_connections) {
		this.number_of_sewer_connections = number_of_sewer_connections;
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

	public void setLength_sewer_in_kms(long length_sewer_in_kms) {
		this.length_sewer_in_kms = length_sewer_in_kms;
	}

	public long getSewer_connected_to_storm() {
		return sewer_connected_to_storm;
	}

	public void setSewer_connected_to_storm(long sewer_connected_to_storm) {
		this.sewer_connected_to_storm = sewer_connected_to_storm;
	}

	public long getStorm_connected_to_sewer() {
		return storm_connected_to_sewer;
	}

	public void setStorm_connected_to_sewer(long storm_connected_to_sewer) {
		this.storm_connected_to_sewer = storm_connected_to_sewer;
	}

	public long getSewer_passing_under_private_building() {
		return sewer_passing_under_private_building;
	}

	public void setSewer_passing_under_private_building(long sewer_passing_under_private_building) {
		this.sewer_passing_under_private_building = sewer_passing_under_private_building;
	}

	public long getGap_in_sewer() {
		return gap_in_sewer;
	}

	public void setGap_in_sewer(long gap_in_sewer) {
		this.gap_in_sewer = gap_in_sewer;
	}

	 
	
	/*@Column(name="contour_low")
	private long contour_low;
	

	@Column(name="contour_high")
	private long contour_high;*/
	
   public SirView(){
	   
	   
   }
   

   public SirView(String docket_name, float area_in_kms, long number_of_connections ,long number_of_sewer_connections ,long number_of_manholes,long deep_manholes,float length_sewer_in_kms,long sewer_connected_to_storm ,long storm_connected_to_sewer,long sewer_passing_under_private_building,long gap_in_sewer) {
       this.docket_name = docket_name;
       this.area_in_kms = area_in_kms;
       this.number_of_connections = number_of_connections;
       
       this.number_of_sewer_connections = number_of_sewer_connections;
       this.number_of_manholes = number_of_manholes;
       this.deep_manholes = deep_manholes;
       
       this.length_sewer_in_kms=length_sewer_in_kms;
       this.sewer_connected_to_storm=sewer_connected_to_storm;
       this.storm_connected_to_sewer=storm_connected_to_sewer;
       this.sewer_passing_under_private_building=sewer_passing_under_private_building;
       this.gap_in_sewer = gap_in_sewer;
       
       
       
       this.gap_in_sewer=gap_in_sewer;
   }
	

	/*sir_view in DB*/
   
   /*CREATE OR REPLACE FUNCTION docket_type_count_fn
   (  dkt_id        docket.docket_id%type
   ,  type_id        sw_problem.problem_type%type
   )
 RETURNs integer AS $v_count$
 declare
   v_count    integer:=0; 
 BEGIN
   select count(*)
    INTO v_count
   from sw_problem SP
   where SP.Problem_Type = type_id
    AND SP.DOCKET_ID = dkt_id;
  
   return v_count;
   END;
 $v_count$ LANGUAGE plpgsql;
  
  ================================
  CREATE OR REPLACE VIEW sir_view AS
 SELECT D.docket_id
 , D.DOCKET_NAME
 , D.NUMBER_OF_SEWER_CONNECTIONS
 , D.NUMBER_OF_CONNECTIONS
 , D.AREA_IN_KMS
 , D.LENGTH_OF_SEWERMAIN_KMS
 , D.NUMBER_OF_MANHOLES
 , D.DEEP_MANHOLES
 , docket_type_count_fn(D.docket_id, '0') as sewer_connected_to_storm
 , docket_type_count_fn(D.docket_id, '1') as storm_connected_to_sewer
 , docket_type_count_fn(D.docket_id, '2') as sewer_passing_under_private_building
 , docket_type_count_fn(D.docket_id, '3') as gap_in_sewer
 FROM docket D*/


}
