//package com.mm.swims.Entity;
//
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//
//@Entity(name="docket_view")
//@JsonIgnoreProperties(ignoreUnknown = true)
//
//public class DocketView {
//	
//    @Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
// 	
//	@Column(name="docket_id")
//	private long docket_id;
//	
//	@Column(name="docket_name")
//	private String docket_name;
//	
//	@Column(name="area_in_kms")
//	private long area_in_kms;
//	
//	@Column(name="number_of_connections")
//	private long number_of_connections;
//	
//	@Column(name="number_of_manholes")
//	private long number_of_manholes;
//	
//	@Column(name="deep_manholes")
//	private long deep_manholes;
//	
//	
//	@Column(name="total_amount_swd")
//	private long Total_Amount_swd;
//	
//	@Column(name="total_amount_strom")
//	private long Total_Amount_stormtose;
//	
//	@Column(name="total_amount_private")
//	private long Total_Amount_private;
//	
//	@Column(name="total_amount_gaps")
//	private long Total_Amount_gaps;
//	
//	@Column(name="length_of_sewermain_kms")
//	private long length_sewer_in_kms;
//	
//	@Column(name="stromConnectedtoSewer")
//	private long stromConnectedtoSewer;
//	
//	@Column(name="sewerConnectedtoStrom")
//	private long sewerConnectedtoStrom;
//	
//	@Column(name="sewerPassingUnderprivateBuilding")
//	private long sewerPassingUnderprivateBuilding;
//	
//	@Column(name="gapinSewer")
//	private long gapinSewer;
//	
//	
//	@Enumerated(EnumType.ORDINAL)
//	private Responsibility responsibility;
//	
//	/*@Enumerated(EnumType.ORDINAL)
//	private ProblemType problem_type;*/
//	
//	
//	/*@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name = "sec_docket_id")
//	private Section section;
//	
//	
//	@JsonManagedReference
//	//@JsonIgnore
//    @OneToMany(mappedBy = "docket", cascade = CascadeType.ALL)
//	private Set<SwProblem> problem;*/
//	
//	/*public enum ProblemType {
//		SewerConnectedtoStorm,
//		StromConnectedtoSewer,
//		SewerPassingUnderprivateBuilding,
//	    GapinSewer
//	    
//	}*/
//	
//	public enum Responsibility {
//		GHMC
//	    
//	}
//
//	public long getDocket_id() {
//		return docket_id;
//	}
//
//	public void setDocket_id(long docket_id) {
//		this.docket_id = docket_id;
//	}
//
//	public String getDocket_name() {
//		return docket_name;
//	}
//
//	public void setDocket_name(String docket_name) {
//		this.docket_name = docket_name;
//	}
//
//	public long getArea_in_kms() {
//		return area_in_kms;
//	}
//
//	public void setArea_in_kms(long area_in_kms) {
//		this.area_in_kms = area_in_kms;
//	}
//
//	public long getNumber_of_connections() {
//		return number_of_connections;
//	}
//
//	public void setNumber_of_connections(long number_of_connections) {
//		this.number_of_connections = number_of_connections;
//	}
//
//	public long getNumber_of_manholes() {
//		return number_of_manholes;
//	}
//
//	public void setNumber_of_manholes(long number_of_manholes) {
//		this.number_of_manholes = number_of_manholes;
//	}
//
//	public long getDeep_manholes() {
//		return deep_manholes;
//	}
//
//	public void setDeep_manholes(long deep_manholes) {
//		this.deep_manholes = deep_manholes;
//	}
//
//	public long getTotal_Amount_swd() {
//		return Total_Amount_swd;
//	}
//
//	public void setTotal_Amount_swd(long total_Amount_swd) {
//		Total_Amount_swd = total_Amount_swd;
//	}
//
//	public long getTotal_Amount_stormtose() {
//		return Total_Amount_stormtose;
//	}
//
//	public void setTotal_Amount_stormtose(long total_Amount_stormtose) {
//		Total_Amount_stormtose = total_Amount_stormtose;
//	}
//
//	public long getTotal_Amount_private() {
//		return Total_Amount_private;
//	}
//
//	public void setTotal_Amount_private(long total_Amount_private) {
//		Total_Amount_private = total_Amount_private;
//	}
//
//	public long getTotal_Amount_gaps() {
//		return Total_Amount_gaps;
//	}
//
//	public void setTotal_Amount_gaps(long total_Amount_gaps) {
//		Total_Amount_gaps = total_Amount_gaps;
//	}
//
//	public long getLength_sewer_in_kms() {
//		return length_sewer_in_kms;
//	}
//
//	public void setLength_sewer_in_kms(long length_sewer_in_kms) {
//		this.length_sewer_in_kms = length_sewer_in_kms;
//	}
//
//	public Responsibility getResponsibility() {
//		return responsibility;
//	}
//
//	public void setResponsibility(Responsibility responsibility) {
//		this.responsibility = responsibility;
//	}
//
//	public long getStromConnectedtoSewer() {
//		return stromConnectedtoSewer;
//	}
//
//	public void setStromConnectedtoSewer(long stromConnectedtoSewer) {
//		this.stromConnectedtoSewer = stromConnectedtoSewer;
//	}
//
//	public long getSewerConnectedtoStrom() {
//		return sewerConnectedtoStrom;
//	}
//
//	public void setSewerConnectedtoStrom(long sewerConnectedtoStrom) {
//		this.sewerConnectedtoStrom = sewerConnectedtoStrom;
//	}
//
//	public long getSewerPassingUnderprivateBuilding() {
//		return sewerPassingUnderprivateBuilding;
//	}
//
//	public void setSewerPassingUnderprivateBuilding(long sewerPassingUnderprivateBuilding) {
//		this.sewerPassingUnderprivateBuilding = sewerPassingUnderprivateBuilding;
//	}
//
//	public long getGapinSewer() {
//		return gapinSewer;
//	}
//
//	public void setGapinSewer(long gapinSewer) {
//		this.gapinSewer = gapinSewer;
//	}
//
//	/*public ProblemType getProblem_type() {
//		return problem_type;
//	}
//
//	public void setProblem_type(ProblemType problem_type) {
//		this.problem_type = problem_type;
//	}*/
//	
//}
