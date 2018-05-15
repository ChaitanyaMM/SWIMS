package com.mm.swims.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mm.swims.Entity.Sample;

@Repository 
public interface SampleRepo  extends JpaRepository<Sample, Long>{

	
	//@Query("select s from Sample s where s.name=?")
	@Query(query)

	List<Sample> findbypay(String name);
	
	
	String query="SELECT s, EXTRACT(MONTH FROM paying_date) as month from Sample s where s.name= ?";


    //String sql="select s from section s where hv.paying_date in :ids";



 
}
