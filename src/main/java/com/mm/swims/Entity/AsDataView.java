package com.mm.swims.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@ManagedBean
@Entity
@Table(name="as_data_view")
//@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
@Transactional

public class AsDataView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id	
	@Column(name = "as_data_Id")
	private long Id;

	@Column(name = "award_of_work")
	private String award_of_work;
	
	@Column(name = "head_of_account")
	private String head_of_account;
	
	@Column(name = "payment_details")
	private String payment_details;
	
	@Column(name = "ts_number")
	private String ts_number;
	
	@Column(name = "ts_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
   // @Temporal(TemporalType.TIMESTAMP)
    
	private Date ts_date;
	
	@Column(name = "material_cost")
	private long material_cost;
	
	@Column(name = "civil_work_cost")
	private long civil_work_cost;
	
	@Column(name = "funding_project_scheme")
	private String funding_project_scheme;
	
	@Column(name = "ls_amount")
	private long ls_amount;
	
	@Column(name = "total_cost")
	private long total_cost;

	@Column(name = "work_status")
	private String work_status;
	
	@Column(name = "admin_sanction_type")
	private String admin_sanction_type;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name="constituency_id")
	private long constituency_id;
	
	@Column(name = "name")
	private String name;
	
	public long getConstituency_id() {
		return constituency_id;
	}

	public void setConstituency_id(long constituency_id) {
		this.constituency_id = constituency_id;
	}

	@Column(name="section_id")
	private long section_id;
	
	@Column(name="section_name")
	private String section_name;
	
	@Column(name = "contract_amount")
	private float contract_amount;
	
	@Column(name="division_id")
	private long division_id;
	
	
	@Column(name = "division_name")
	private String division_name;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "approved_date")//as-date
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")

	private Date approved_date;

	@Column(name = "agency")
	private String agency;
	
	@Column(name="activity")
 	private String activity;
	
	@Column(name = "as_number")
	private String as_number;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getAward_of_work() {
		return award_of_work;
	}

	public void setAward_of_work(String award_of_work) {
		/*if(award_of_work.isEmpty() || award_of_work ==null){
		   this.award_of_work = null;
           }
		else*/
		this.award_of_work = award_of_work;
		
	}

	public String getHead_of_account() {
		return head_of_account;
	}

	public void setHead_of_account(String head_of_account) {
		this.head_of_account = head_of_account;
	}

	public String getPayment_details() {
		return payment_details;
	}

	public void setPayment_details(String payment_details) {
		this.payment_details = payment_details;
	}
	
	public long getSection_id() {
		return section_id;
	}

	public void setSection_id(long section_id) {
		this.section_id = section_id;
	}

	public long getDivision_id() {
		return division_id;
	}

	public void setDivision_id(long division_id) {
		this.division_id = division_id;
	}

	public String getDivision_name() {
		return division_name;
	}

	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}


	public String getTs_number() {
		return ts_number;
	}

	public void setTs_number(String ts_number) {
		this.ts_number = ts_number;
	}

	public Date getTs_date() {
		return ts_date;
	}

	public void setTs_date(Date ts_date) {
		this.ts_date = ts_date;
	}

	public long getMaterial_cost() {
		return material_cost;
	}

	public void setMaterial_cost(long material_cost) {
		this.material_cost = material_cost;
	}

	public long getCivil_work_cost() {
		return civil_work_cost;
	}

	public void setCivil_work_cost(long civil_work_cost) {
		this.civil_work_cost = civil_work_cost;
	}

	public String getFunding_project_scheme() {
		return funding_project_scheme;
	}

	public void setFunding_project_scheme(String funding_project_scheme) {
		/* if(funding_project_scheme.isEmpty()){
		   this.funding_project_scheme = null;
           }*/
		 
		this.funding_project_scheme = funding_project_scheme;
		 
	}

	public long getLs_amount() {
		return ls_amount;
	}

	public void setLs_amount(long ls_amount) {
		this.ls_amount = ls_amount;
	}

	public long getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(long total_cost) {
		this.total_cost = total_cost;
	}

	public String getWork_status() {
		return work_status;
	}

	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}

	public String getAdmin_sanction_type() {
		return admin_sanction_type;
	}

	public void setAdmin_sanction_type(String admin_sanction_type) {
		this.admin_sanction_type = admin_sanction_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public float getContract_amount() {
		return contract_amount;
	}

	public void setContract_amount(float contract_amount) {
		this.contract_amount = contract_amount;
	}

	
	/*public String getDivison_name() {
		return division_name;
	}

	public void setDivison_name(String divison_name) {
		this.division_name = divison_name;
	}*/

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getApproved_date() {
		return approved_date;
	}

	public void setApproved_date(Date approved_date) {
		this.approved_date = approved_date;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getAs_number() {
		return as_number;
	}

	public void setAs_number(String as_number) {
		this.as_number = as_number;
	}

/*	private Map<String, Object> otherProperties = new HashMap<String, Object>();
	 
    @JsonAnyGetter
    public Map<String, Object> any() {
        return otherProperties;
    }
 
    @JsonAnySetter
    public void set(String name, Object value) {
        otherProperties.put(name, value);
    }*/
	
	
	

}


/*as_data_view in db*/

/*CREATE OR REPLACE VIEW as_data_view AS
SELECT asa.as_data_id
,asa.award_of_work 
, se.as_number
, se.approved_date
, se.reason 
, s.section_id
, s.section_name
, di.division_id
, di.division_name 
, asa.head_of_account 
, sp.activity 
, se.agency
, se.contract_amount 
, se.funding_project_scheme 
, cs.name 
, asa.payment_details
, se.remarks 
, asa.ts_number 
, asa.ts_date 
, asa.material_cost 
, asa.civil_work_cost 
, asa.ls_amount 
, asa.total_cost
, asa.work_status 
, asa.admin_sanction_type 
, asa.description 
FROM sw_estimate se, as_data asa,sw_problem sp ,section s,subdivison sd ,division di , constituency cs
where  asa.estimate_id =se.estimate_id 
 AND   se.sw_problem_id =sp.sw_problem_id
 AND   sp.constituency_id =cs.constituency_id
 AND   sp.section_Id =s.section_Id
 AND   s.subdivision_Id = sd.subdivison_id
 AND   sd.division_id  =di.division_id

*/ 