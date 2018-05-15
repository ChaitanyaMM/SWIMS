package com.mm.swims.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sw_problem",schema = "postgres")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwProblem implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
 	
	@Column(name="sw_problem_Id")
	private long Id;
	
	/*@Column(name="docket_id")
	private long docket_id;*/
	
	@Column(name="problem_type")
	//@Enumerated(EnumType.ORDINAL)
 	private String problem_type;
	
	@Column(name="activity")
 	private String activity;
	
//	@Enumerated(EnumType.STRING)
	private ProblemStatus problem_status;
	
	//@Enumerated(EnumType.STRING)
	private String solution_category;
	
	//@Enumerated(EnumType.STRING)
	private DrainType drain_type;
	
//	@Enumerated(EnumType.STRING)
	private Responsibility responsibility;
	
	
	
	/*@Column(name="problem_type")
	private String problem_type;
	*/
	/*@Column(name="problem_status")
	private String	problem_status;
	
	@Column(name="solution_category")
	private String	solution_category;*/
	
	@Column(name="remarks")
	private String	remarks;
	
	@Column(name="Schedule_start", columnDefinition = "TIMESTAMP WITH TIME ZONE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
   // @Temporal(TemporalType.TIMESTAMP)
	//@JsonFormat
	private Date Schedule_start;
	
	@Column(name="Schedule_end",columnDefinition = "TIMESTAMP WITH TIME ZONE")
   // @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")

	private Date Schedule_end;
	
	@Column(name="Actual_start", columnDefinition = "TIMESTAMP WITH TIME ZONE")
   // @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date Actual_start;
	
	@Column(name="Actual_end", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    //@Temporal(TemporalType.TIMESTAMP)
	
	private Date Actual_end; // fecthcing 
	
	@Column(name="location")
	private String location;
	
	@Column(name="pipe_size")
	private long pipe_size;
	
	
	/*hotspot add-ons*/
	
	@Column(name="pipe_length")
	private long pipe_length;
	
	@Column(name="pk_number")
	private long pk_number;
	
	
	public long getPipe_size() {
		return pipe_size;
	}

	public void setPipe_size(long pipe_size) {
		this.pipe_size = pipe_size;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	//@Enumerated(EnumType.STRING)
	public enum ProblemType {
		SewerConnectedtoStorm("0"),
		StromConnectedtoSewer("1"),
		SewerPassingUnderprivateBuilding("2"),
	    GapinSewer("3"),
		MHRequirePlastering("4"),
		MHBuried("5"),
		MHRequireIntermediate("6"),
		MHRequireRaising("7"),
		DamagedPipe("8"),
//		General("9"),
//		WaterSupply("10"),   /**we have activity enum in problem-type only later we split as two *//
//		Electrical("11"),
//		Sewarage("12"),
		Others("91"),
		Unknown("99");
		
		
		 private String value;

	        private ProblemType(String value) {
	            this.value = value;
	        }

	      //  @Override
	        public static ProblemType valueOfd(String value){
	        	for( ProblemType ptype : ProblemType .values() ){
	        		
	        		if(ptype.getValue().equals(value))
	                
	                   return ptype;
	             }
	             return null;//or throw exception
	       }

	        public String getValue() { return value; }

	    
		
	}
	
	public enum Activitiy {
		
		General("General"),//0
		WaterSupply("WaterSupply"),//1
		Electrical("Electrical"),//2
		Sewarage("Sewarage"),//3
		Others("Others"),//91
		Unknown("Unknown");//99
		
		
		 private String value;

	        private Activitiy(String value) {
	            this.value = value;
	        }

	      //  @Override
	        public static ProblemType valueOfd(String value){
	        	for( ProblemType ptype : ProblemType .values() ){
	        		
	        		if(ptype.getValue().equals(value))
	                
	                   return ptype;
	             }
	             return null;//or throw exception
	       }

	        public String getValue() { return value; }

	    
		
	}
	
	
	 
	public enum ProblemStatus {
		YettoPlan,//(0)
		Estimated,//(1)
		Approved,//(2)
	    Inprogress,//(3)
	    WorkCompleted,//(4)
	    Commissioned,//(5)
	    Closed;//(6)
	    
	}
	public enum DrainType {
		Open,   	//(0)
		Close,  	//(1)
		Deviation,  //(2)
	    NotApplicable,//(3)
	    UnKnown,    //(4)
	    Diversion ;  //(5)
	    
	}
	
	public enum SolutionCategory {
		YettoDecide,//(0)
		y,//(1)
		z,//(2)
	    a,//(3)
	    Others,//91,
		Unknown;//99
	    
	}
	
	public enum Responsibility {
		GHMC,//(0)
		HMWSSB,//(1)
		X,
		Y,
		Z;
	    
	}
	
	@JsonBackReference
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "docket_Id")
	private Docket docket;
	
	//@JsonBackReference
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "section_Id")
	private Section section;
	
	@JsonIgnore
    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<SwEstimate> estimate;
	
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "constituency_Id")	
	private Constituency constituency;

	
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Docket getDocket() {
		return docket;
	}

	public void setDocket(Docket docket) {
		this.docket = docket;
	}
 
	public String getProblem_type() {
		return problem_type;
	}
	public ProblemStatus getProblem_status() {
		return problem_status;
	}
	public String getSolution_category() {
		return solution_category;
	}
	public String getRemarks() {
		return remarks;
	}
	public Date getSchedule_start() {
		return Schedule_start;
	}
	public Date getSchedule_end() {
		return Schedule_end;
	}
	public Date getActual_start() {
		return Actual_start;
	}
	public Date getActual_end() {
		return Actual_end;
	}
	 
	 
	public void setProblem_type(String problem_type) {
		this.problem_type = problem_type;
	}
	public void setProblem_status(ProblemStatus problem_status) {
		this.problem_status = problem_status;
	}
	public void setSolution_category(String solution_category) {
		this.solution_category = solution_category;
	}
	public DrainType getDrain_type() {
		return drain_type;
	}

	public void setDrain_type(DrainType drain_type) {
		this.drain_type = drain_type;
	}

	public Responsibility getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(Responsibility responsibility) {
		this.responsibility = responsibility;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setSchedule_start(Date schedule_start) {
		Schedule_start = schedule_start;
	}
	public void setSchedule_end(Date schedule_end) {
		Schedule_end = schedule_end;
	}
	public void setActual_start(Date actual_start) {
		Actual_start = actual_start;
	}
	public void setActual_end(Date actual_end) {
		Actual_end = actual_end;
	}
	 
	public long getPipe_length() {
		return pipe_length;
	}

	public void setPipe_length(long pipe_length) {
		this.pipe_length = pipe_length;
	}

	public long getPk_number() {
		return pk_number;
	}

	public void setPk_number(long pk_number) {
		this.pk_number = pk_number;
	}

	public Set<SwEstimate> getEstimate() {
		return estimate;
	}

	public void setEstimate(Set<SwEstimate> estimate) {
		this.estimate = estimate;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Constituency getConstituency() {
		return constituency;
	}

	public void setConstituency(Constituency constituency) {
		this.constituency = constituency;
	}

	public SwProblem() {
			
		}
	
	public SwProblem(ProblemType problem_type) {
		this.problem_type=problem_type.getValue();
		
	}

	
	public SwProblem(String problem_type, ProblemStatus problem_status, String solution_category ,DrainType drain_type,Responsibility responsibility, String	remarks,String location,long pipe_size) {
	    this.problem_type = problem_type;
	    this.problem_status = problem_status;
	    this.solution_category = solution_category;
	    this.drain_type=drain_type;
	    this.responsibility=responsibility;
	    this.remarks=remarks;
	    this.location=location;
	    this.pipe_size=pipe_size;
	}
	

}
