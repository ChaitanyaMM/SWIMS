package com.mm.swims.Entity;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@ManagedBean
@Entity
@Table(name="hotspot_view_one")
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedQuery(name = "HotSpotView.findestimatesview", query="select hv from HotSpotView hv")

public class HotSpotView implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "section_Id")
	private long Id;
	
	@Column(name="section_name")
	private String section_name;
	
	@Column(name="number_of_manholes")
	private long number_of_manholes;
	
	@Column(name="sewer_connected_to_storm")
	private long sewer_connected_to_storm;
	
	@Column(name="storm_connected_to_sewer")
	private long storm_connected_to_sewer;
	
	@Column(name="sewer_passing_under_private_building")
	private long sewer_passing_under_private_building;
	
	@Column(name="gap_in_sewer")
	private long gap_in_sewer;
	
	@Column(name="mh_require_plastering")
	private long mh_require_plastering;
	
	@Column(name="mh_buried")
	private long mh_buried;
	
	@Column(name="mh_require_intermediate")
	private long mh_require_intermediate;
	
	@Column(name="mh_require_raising")
	private long mh_require_raising;
	
	@Column(name="damaged_pipe")
	private long damaged_pipe;
	
	@Column(name="a_done")
	private long A;
	
	@Column(name="a_to_be_done")
	private long ATD;
	
	@Column(name="bgm_done")
	private long BGM;
	
	@Column(name="bgm_to_be_done")
	private long BGMTD;
	
	@Column(name="bcgm_done")
	private long BCGM;
	
	@Column(name="bcgm_to_be_done")
	private long BCGMTD;
	
	@Column(name="c_done")
	private long C;
	
	@Column(name="c_to_be_done")
	private long CTD;
	
	@Column(name="d")
	private long D;
	
	
	public HotSpotView(){
		
	}
	
	
	public HotSpotView(String section_name,long number_of_manholes,long sewer_connected_to_storm ,long storm_connected_to_sewer,long sewer_passing_under_private_building,long gap_in_sewer,long mh_require_plastering,
			long mh_buried,long mh_require_intermediate,long mh_require_raising,long damaged_pipe,long A,long BGM,
			long BCGM,long C,long CTD, long BCGMTD , long BGMTD , long ATD,
		       long D ) {
	      
		   this.section_name = section_name;
	       this.number_of_manholes = number_of_manholes;
	       this.sewer_connected_to_storm=sewer_connected_to_storm;
	       this.storm_connected_to_sewer=storm_connected_to_sewer;
	       this.sewer_passing_under_private_building=sewer_passing_under_private_building;
	       this.gap_in_sewer = gap_in_sewer;
	       this.mh_require_plastering=mh_require_plastering;
	       this.mh_buried=mh_buried;
	       this.mh_require_intermediate=mh_require_intermediate;
	       this.mh_require_raising=mh_require_raising;
	       this.damaged_pipe=damaged_pipe;
	       this.A=A;
	       this.BGM=BGM;
	       this.BCGM=BCGM;
	       this.C=C;
	       this.D=D;
	       this.CTD=CTD;
	       this.BCGMTD=BCGMTD;
	       this.BGMTD=BGMTD;
	       this.ATD=ATD;


	       
	   }


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getSection_name() {
		return section_name;
	}


	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}


	public long getNumber_of_manholes() {
		return number_of_manholes;
	}


	public void setNumber_of_manholes(long number_of_manholes) {
		this.number_of_manholes = number_of_manholes;
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


	public long getMh_require_plastering() {
		return mh_require_plastering;
	}


	public void setMh_require_plastering(long mh_require_plastering) {
		this.mh_require_plastering = mh_require_plastering;
	}


	public long getMh_buried() {
		return mh_buried;
	}


	public void setMh_buried(long mh_buried) {
		this.mh_buried = mh_buried;
	}


	public long getMh_require_intermediate() {
		return mh_require_intermediate;
	}


	public void setMh_require_intermediate(long mh_require_intermediate) {
		this.mh_require_intermediate = mh_require_intermediate;
	}


	public long getMh_require_raising() {
		return mh_require_raising;
	}


	public void setMh_require_raising(long mh_require_raising) {
		this.mh_require_raising = mh_require_raising;
	}


	public long getDamaged_pipe() {
		return damaged_pipe;
	}


	public void setDamaged_pipe(long damaged_pipe) {
		this.damaged_pipe = damaged_pipe;
	}


	public long getA() {
		return A;
	}


	public void setA(long a) {
		A = a;
	}


	public long getAtobedone() {
		return ATD;
	}


	public void setAtobedone(long atobedone) {
		ATD = atobedone;
	}


	public long getBGM() {
		return BGM;
	}


	public void setBGM(long bGM) {
		BGM = bGM;
	}


	public long getBGMtobedone() {
		return BGMTD;
	}


	public void setBGMtobedone(long bGMtobedone) {
		BGMTD = bGMtobedone;
	}


	public long getBCGM() {
		return BCGM;
	}


	public void setBCGM(long bCGM) {
		BCGM = bCGM;
	}


	public long getBCGMtobedone() {
		return BCGMTD;
	}


	public void setBCGMtobedone(long bCGMtobedone) {
		BCGMTD = bCGMtobedone;
	}


	public long getC() {
		return C;
	}


	public void setC(long c) {
		C = c;
	}


	public long getCtobedone() {
		return CTD;
	}


	public void setCtobedone(long ctobedone) {
		CTD = ctobedone;
	}


	public long getD() {
		return D;
	}


	public void setD(long d) {
		D = d;
	}


	
		/*hotspot_view in DB*/
	

	/*CREATE OR REPLACE FUNCTION section_type_count_fn2
	  (  sec_id        section.section_id%type
	  ,  type_id        sw_problem.problem_type%type
	  )
	RETURNs integer AS $v_count$
	declare
	  v_count    integer:=0; 
	BEGIN
	  select count(*)
	   INTO v_count
	  from sw_problem SP ,docket D
	  where SP.Problem_Type = type_id
	   AND SP.DOCKET_ID = D.docket_id
	   AND D.SECTION_ID=sec_id;
	 
	  return v_count;
	  END;
	$v_count$ LANGUAGE plpgsql;
	
	
	
	
	
	
	
	
	
	   
	   
	   
	   
	CREATE OR REPLACE FUNCTION section_manholes_fn
	  (  sec_id        section.section_id%type
	   
	  )
	RETURNs integer AS $v_count$
	declare
	  v_count    integer:=0; 
	BEGIN
	  select sum(D.number_of_manholes) into v_count
	  from docket D
	  where D.SECTION_ID=sec_id;
	 
	  return v_count;
	  END;
	$v_count$ LANGUAGE plpgsql;
	
	
	
	
	
	
	 CREATE OR REPLACE FUNCTION estimate_approved_type_count_fn
	  (  sec_id        section.section_id%type
	  ,  type_id        sw_estimate.project_category%type
	  )
	RETURNs integer AS $v_count$
	declare
	  v_count    integer:=0; 
	BEGIN
	  select count(*)
	   INTO v_count
	  from sw_estimate SE ,sw_problem sp
	  where SE.project_category = type_id
	   AND  sp.SECTION_ID = sec_id
	   AND SE.SW_PROBLEM_ID=SP.SW_PROBLEM_ID
	   AND SE.STATUS IN('3','4');
	     
	  
	  return v_count;
	  END;
	$v_count$ LANGUAGE plpgsql;
	
	
	
	
	CREATE OR REPLACE FUNCTION estimate_tobe_approved_type_count_fn
	  (  sec_id        section.section_id%type
	  ,  type_id        sw_estimate.project_category%type
	  )
	RETURNs integer AS $v_count$
	declare
	  v_count    integer:=0; 
	BEGIN
	  select count(*)
	   INTO v_count
	  from sw_estimate SE ,sw_problem sp
	  where SE.project_category = type_id
	   AND  sp.SECTION_ID = sec_id
	   AND SE.SW_PROBLEM_ID=SP.SW_PROBLEM_ID
	   AND SE.STATUS IN('0','1','2');
	     
	  
	  return v_count;
	  END;
	$v_count$ LANGUAGE plpgsql;
	
	
	
	
	
	
	
	   
	   
	   CREATE OR REPLACE VIEW hotspot_view_one AS
	    SELECT s.section_id,
	    s.section_name,
	    section_manholes_fn (s.section_id) AS number_of_manholes,
	    section_type_count_fn2(s.section_id, '0') AS sewer_connected_to_storm,
	    section_type_count_fn2(s.section_id, '1') AS storm_connected_to_sewer,
	    section_type_count_fn2(s.section_id, '2') AS sewer_passing_under_private_building,
	    section_type_count_fn2(s.section_id, '3') AS gap_in_sewer,
	    section_type_count_fn2(s.section_id, '4') AS mh_require_plastering,
	    section_type_count_fn2(s.section_id, '5') AS mh_buried,
	    section_type_count_fn2(s.section_id, '6') AS mh_require_intermediate,
	    section_type_count_fn2(s.section_id, '7') AS mh_require_raising,
	    section_type_count_fn2(s.section_id, '8') AS damaged_pipe,
	    estimate_approved_type_count_fn(s.section_id, 'A') as a_done,
	    estimate_tobe_approved_type_count_fn(s.section_id, 'A') as a_to_be_done
	    , estimate_approved_type_count_fn(s.section_id, 'B-GM') as bgm_done
	    , estimate_tobe_approved_type_count_fn(s.section_id, 'B-GM') as bgm_to_be_done
		, estimate_approved_type_count_fn(s.section_id, 'B-CGM') as bcgm_done
	    , estimate_tobe_approved_type_count_fn(s.section_id, 'B-CGM') as bcgm_to_be_done
		, estimate_approved_type_count_fn(s.section_id, 'C') as c_done
	    , estimate_tobe_approved_type_count_fn(s.section_id, 'C') as c_to_be_done
		, estimate_approved_type_count_fn(s.section_id, 'D') as d
	    FROM section s;*/
	
	
	
		
		
		
	
	
	

}
