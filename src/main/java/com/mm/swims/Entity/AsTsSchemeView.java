package com.mm.swims.Entity;

import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@ManagedBean
@Entity
@Table(name="as_ts_scheme_view")
//@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
//@NamedQuery(name = "AsTsDivisionView.findalldivisionvsworks", query="select asdiv from AsTsDivisionView asdiv")
public class AsTsSchemeView {
	
	@Id
	/*@Column(name="estimate_Id")
	private long id;*/
	
	@Column(name = "funding_project_scheme")
	private String funding_project_scheme;
	
	@Column(name="noofworks2014_2015")
	private long noofworks2014_2015;

	@Column(name="totalcost2014_2015")
	private long totalcost2014_2015;

	@Column(name="noofworks2015_2016")
	private long noofworks2015_2016;

	@Column(name="totalcost2015_2016")
	private long totalcost2015_2016;

	@Column(name="noofworks2016_2017")
	private long noofworks2016_2017;
	
	@Column(name="totalcost2016_2017")
	private long totalcost2016_2017;

	@Column(name="noofworks2017_2018")
	private long noofworks2017_2018;

	@Column(name="totalcost2017_2018")
	private long totalcost2017_2018;
   
	@Column(name="noofworks2018_2019")
	private long noofworks2018_2019;

	@Column(name="totalcost2018_2019")
	private long totalcost2018_2019;

/*	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}*/

	

	public String getFunding_project_scheme() {
		return funding_project_scheme;
	}

	public void setFunding_project_scheme(String funding_project_scheme) {
		this.funding_project_scheme = funding_project_scheme;
	}

	public long getNoofworks2014_2015() {
		return noofworks2014_2015;
	}

	public void setNoofworks2014_2015(long noofworks2014_2015) {
		this.noofworks2014_2015 = noofworks2014_2015;
	}

	public long getTotalcost2014_2015() {
		return totalcost2014_2015;
	}

	public void setTotalcost2014_2015(long totalcost2014_2015) {
		this.totalcost2014_2015 = totalcost2014_2015;
	}

	public long getNoofworks2015_2016() {
		return noofworks2015_2016;
	}

	public void setNoofworks2015_2016(long noofworks2015_2016) {
		this.noofworks2015_2016 = noofworks2015_2016;
	}

	public long getTotalcost2015_2016() {
		return totalcost2015_2016;
	}

	public void setTotalcost2015_2016(long totalcost2015_2016) {
		this.totalcost2015_2016 = totalcost2015_2016;
	}

	public long getNoofworks2016_2017() {
		return noofworks2016_2017;
	}

	public void setNoofworks2016_2017(long noofworks2016_2017) {
		this.noofworks2016_2017 = noofworks2016_2017;
	}

	public long getTotalcost2016_2017() {
		return totalcost2016_2017;
	}

	public void setTotalcost2016_2017(long totalcost2016_2017) {
		this.totalcost2016_2017 = totalcost2016_2017;
	}

	public long getNoofworks2017_2018() {
		return noofworks2017_2018;
	}

	public void setNoofworks2017_2018(long noofworks2017_2018) {
		this.noofworks2017_2018 = noofworks2017_2018;
	}

	public long getTotalcost2017_2018() {
		return totalcost2017_2018;
	}

	public void setTotalcost2017_2018(long totalcost2017_2018) {
		this.totalcost2017_2018 = totalcost2017_2018;
	}

	public long getNoofworks2018_2019() {
		return noofworks2018_2019;
	}

	public void setNoofworks2018_2019(long noofworks2018_2019) {
		this.noofworks2018_2019 = noofworks2018_2019;
	}

	public long getTotalcost2018_2019() {
		return totalcost2018_2019;
	}

	public void setTotalcost2018_2019(long totalcost2018_2019) {
		this.totalcost2018_2019 = totalcost2018_2019;
	}

	

}

				/*scheme*/

/*CREATE OR REPLACE FUNCTION as_ts_scheme_count_fn
(  div_name      as_data.funding_project_scheme%type
 , frmdate        as_data.ts_date%type
 , todate        as_data.ts_date%type
)
RETURNs integer AS $v_count$
declare
v_count    integer:=0; 
BEGIN
select count(*)
 INTO v_count
from as_data_view asa
where asa.ts_date between frmdate and todate
 AND  asa.funding_project_scheme = div_name;

return v_count;
END;
$v_count$ LANGUAGE plpgsql;



CREATE OR REPLACE FUNCTION as_ts_scheme_sum_fn
(  div_name      as_data.funding_project_scheme%type
 , frmdate       as_data.ts_date%type
 , todate        as_data.ts_date%type
)
RETURNs integer AS $v_count$
declare
v_count    integer:=0; 
BEGIN
select sum(asa.total_cost)
 INTO v_count
from as_data_view asa
where asa.ts_date between frmdate and todate
 AND  asa.funding_project_scheme = div_name;

 if v_count is null 
 then
    v_count :=0;
  end if;

return v_count;
END;
$v_count$ LANGUAGE plpgsql;




CREATE OR REPLACE VIEW as_ts_scheme_view AS
SELECT sch.funding_project_scheme
, as_ts_scheme_count_fn(sch.funding_project_scheme,'2014-04-01 00:00:00+05:30' , '2015-03-31 00:00:00+05:30') as noofworks2014_2015
, as_ts_scheme_sum_fn(sch.funding_project_scheme,'2014-04-01 00:00:00+05:30' , '2015-03-31 00:00:00+05:30') as totalcost2014_2015

, as_ts_scheme_count_fn(sch.funding_project_scheme,'2015-04-01 00:00:00+05:30' , '2016-03-31 00:00:00+05:30') as noofworks2015_2016
, as_ts_scheme_sum_fn(sch.funding_project_scheme,'2015-04-01 00:00:00+05:30' , '2016-03-31 00:00:00+05:30') as totalcost2015_2016

, as_ts_scheme_count_fn(sch.funding_project_scheme,'2016-04-01 00:00:00+05:30' , '2017-03-31 00:00:00+05:30') as noofworks2016_2017
, as_ts_scheme_sum_fn(sch.funding_project_scheme,'2016-04-01 00:00:00+05:30' , '2017-03-31 00:00:00+05:30') as totalcost2016_2017

, as_ts_scheme_count_fn(sch.funding_project_scheme,'2017-04-01 00:00:00+05:30' , '2018-03-31 00:00:00+05:30') as noofworks2017_2018
, as_ts_scheme_sum_fn(sch.funding_project_scheme,'2017-04-01 00:00:00+05:30' , '2018-03-31 00:00:00+05:30') as totalcost2017_2018

, as_ts_scheme_count_fn(sch.funding_project_scheme,'2018-04-01 00:00:00+05:30' , '2019-03-31 00:00:00+05:30') as noofworks2018_2019
, as_ts_scheme_sum_fn(sch.funding_project_scheme,'2018-04-01 00:00:00+05:30' , '2019-03-31 00:00:00+05:30') as totalcost2018_2019


FROM as_data_view sch
group by sch.funding_project_scheme

*
*/

