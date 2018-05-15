package com.mm.swims.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="sw_estimate",schema = "postgres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwEstimate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "estimate_Id")
	private long Id;

	@Column(name = "funding_project_scheme")
	private String funding_project_scheme;

	@Column(name = "project_category")
	private String project_category;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "approved_date")//as-date
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date approved_date;

	@Column(name = "completed_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date completed_date; 	/*if only-one estimate for the problem completed-date
	 									and in problem actual-end date should be same*/
    @Column(name = "status")
	private String status;

	@Column(name = "schedule_completed_by")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date schedule_completed_by;

	@Column(name = "as_number")
	private String as_number;

	@Column(name = "ts_number")
	private String ts_number;

	@Column(name = "estimate_amount")
	private float estimate_amount;

	@Column(name = "contract_amount")
	private float contract_amount;

	@Column(name = "workorder_number")
	private String workorder_number; /*amount santiconed for the estimate*/

	@Column(name = "reason")
	private String reason;//nameofwork

	@Column(name = "agency")
	private String agency;

	@Column(name = "feasibility_report")
	private String feasibility_report;
	
	
	//private String awardofwork;

	public enum ProjectCategory {

		ComplaintcanbeaddressedwithMenandMachinery("A"), 
		Complaintcanbeaddressedwithminorrepaircostlimit20k("B-GM"),
		// i.e. GM limit 20000
		Complaintcanbeaddressedwithminorrepaircostlimit50k("B-CGM"),
		// i.e. CGM limit 50000
		Complaintneedtobeaddressedwithsignificantrepaircost("C"),
		// (MD Approval required)
		ComplaintcanonlybeaddressedonlyafterimplementationofSeweragemasterPlan("D"),
		Others("91"),Unknown("99");
		//ComplaintcanbeaddressedwithMenandMachinery_notdone("A-TD"),
		//Complaintcanbeaddressedwithminorrepaircostlimit20k_notdone("B-GMTD"),
		//Complaintcanbeaddressedwithminorrepaircostlimit50k_notdone("B-CGMTD"),
		//Complaintneedtobeaddressedwithsignificantrepaircost_notdone("C-TD"),
		
		private String value;

		private ProjectCategory(String value) {
			this.value = value;
		}

		// @Override
		public static ProjectCategory valueOfd(String value) {
			for (ProjectCategory ptype : ProjectCategory.values()) {

				if (ptype.getValue().equals(value))

					return ptype;
			}
			return null;// or throw exception
		}

		public String getValue() {
			return value;
		}

	}

	public enum Status {
		 TobeApproved("0"),Approved("1"),InProgress("2"),Completed("3"),Close("4"),Rejected("9");
		
		private String value;

		private Status(String value) {
			this.value = value;
		}

		// @Override
		public static Status valueOfd(String value) {
			for (Status ptype : Status.values()) {

				if (ptype.getValue().equals(value))

					return ptype;
			}
			return null;// or throw exception
		}

		public String getValue() {
			return value;
		}


	}

	//@JsonManagedReference(value = "problem-details")
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "sw_problem_Id")
	private SwProblem problem;
	
	/*@JsonIgnore
	@JoinColumn(name = "problem_type")
	private String problem_type;*/
	
	
	//@JsonBackReference(value="section-details")
	/*@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "section_Id")
	private Section section;*/

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getFunding_project_scheme() {
		return funding_project_scheme;
	}

	public void setFunding_project_scheme(String funding_project_scheme) {
		this.funding_project_scheme = funding_project_scheme;
	}

	public String getProject_category() {
		return project_category;
	}

	public void setProject_category(String project_category) {
		this.project_category = project_category;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getApproved_date() {
		return approved_date;
	}

	public void setApproved_date(Date approved_date) {
		this.approved_date = approved_date;
	}

	public Date getCompleted_date() {
		return completed_date;
	}

	public void setCompleted_date(Date completed_date) {
		this.completed_date = completed_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSchedule_completed_by() {
		return schedule_completed_by;
	}

	public void setSchedule_completed_by(Date schedule_completed_by) {
		this.schedule_completed_by = schedule_completed_by;
	}

	public String getAs_number() {
		return as_number;
	}

	public void setAs_number(String as_number) {
		this.as_number = as_number;
	}

	public String getTs_number() {
		return ts_number;
	}

	public void setTs_number(String ts_number) {
		this.ts_number = ts_number;
	}

	public float getEstimate_amount() {
		return estimate_amount;
	}

	public void setEstimate_amount(long estimate_amount) {
		this.estimate_amount = estimate_amount;
	}

	public float getContract_amount() {
		return contract_amount;
	}

	public void setContract_amount(float contract_amount) {
		this.contract_amount = contract_amount;
	}

	public String getWorkorder_number() {
		return workorder_number;
	}

	public void setWorkorder_number(String workorder_number) {
		this.workorder_number = workorder_number;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAgency() {
		return agency;
	}

	/*public String getProblem_type() {
		return problem_type;
	}

	public void setProblem_type(String problem_type) {
		this.problem_type = problem_type;
	}*/

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getFeasibility_report() {
		return feasibility_report;
	}

	public void setFeasibility_report(String feasibility_report) {
		this.feasibility_report = feasibility_report;
	}

	public SwProblem getProblem() {
		return problem;
	}

	public void setProblem(SwProblem problem) {
		this.problem = problem;
	}
	
	
	
	public SwEstimate(){
	   
	}
	
	
	
	
	

}
