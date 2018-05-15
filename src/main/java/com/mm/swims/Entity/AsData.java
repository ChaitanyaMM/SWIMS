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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mm.swims.Entity.SwEstimate.Status;
import com.mm.swims.Entity.SwProblem.ProblemType;

@Entity
@Table(name="as_data",schema = "postgres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AsData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column(name = "as_data_Id")
	private long Id;

	@Column(name = "award_of_work")
	private String award_of_work;
	
	@Column(name = "head_of_account")
	private String head_of_account;
	
	//@Lob
	@Column(name = "payment_details",length=4000)
	private String payment_details;
	
	@Column(name = "ts_number")
	private String ts_number;
	
	@Column(name = "ts_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
   // @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date ts_date;
	
	@Column(name = "material_cost")
	private long material_cost;
	
	@Column(name = "civil_work_cost")
	private long civil_work_cost;
	
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
	
	
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "estimate_Id")
	private SwEstimate swestimate;
	
	public enum HeadOfAccount{
		
		BF("BF"),LOCAdmnBldg("LOCAdmnBldg"),AHDWWaterSupply ("AHDWWaterSupply"),GramPanchayatFunds("GramPanchayatFunds"),DCWSWC("DCWSWC"),
		
		DCW("DCW"),SPECIALDEVELOPMENTFUNDFORWELFAREANDDEVELOPEMENTACTIVITIES2017to18("SPECIALDEVELOPMENT2017TO2018"),
		
        CDP("CDP"),SREandIWSandSRPSC("SREandIWSandSRPSC"),AHDWSewerageSupply("AHDWSewerageSupply"), SandIWS("SandIWS"),
        
        CoOptFund("CoOptFund"),GHMC("GHMC"),RWH("RWH"),RDS("RDS"),JNNURM("JNNURM"),MPLADS("MPLADS"),
        
        IWS("IWS"),SAP("SAP"),HMRL("HMRL"),HUDCO("HUDCO"),CRF("CRF"),SCSP("SCSP"),
        
       GOVTGRANTS("GOVTGRANTS"),SIWSNGA("SIWSNGA"),NPSS("NPSS"),EIW("EIW"),TSP("TSP"),WSP("WSP"),EIWSandMLA("EIWSandMLA"),
       
        Others("Others"),Unknown("Unknown");
		
		private String value;

		private HeadOfAccount(String value) {
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
	
	public enum AwardOfWork {
		Nomination("0"),Tender("1"),Others("91"),Unknown("99");
	
		private String value;

		private AwardOfWork(String value) {
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
	
	public enum AdminSanctionType {
		A("0"),B("1"),C("91"),D("99");
	
		private String value;

		private AdminSanctionType(String value) {
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
	
	public enum WorkStatus {
		YettoPlan("0"), Estimated("1"), Approved("2"),
		
	    Inprogress("3"), WorkCompleted("4"), Commissioned("5"),
	    
	    Closed("6"), Others("91"),  Unknown("99");
		
		private String value;

		private WorkStatus(String value) {
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
	
	
	
	public AsData(){
	   
	}

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

	public SwEstimate getSwestimate() {
		return swestimate;
	}

	public void setSwestimate(SwEstimate swestimate) {
		this.swestimate = swestimate;
	}
	
	
	
	
	

}
