package com.mm.swims.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import com.mm.swims.Entity.AsData;
import com.mm.swims.Entity.Constituency;
import com.mm.swims.Entity.HotSpotView;

@Repository
public interface ASDataRepository extends JpaRepository<AsData, Long>{


	
	@Query(StrSECTION)
	 List<AsData> findbysectionId(long id);

	
	String StrSECTION  ="select asa from AsData asa,SwEstimate se ,SwProblem sp ,Section s where se.problem.Id =sp.Id and sp.section.Id=s.Id and s.Id= ?";
	
	@Query(StrDIVISION)
	List<AsData> findbydivisionId(long id);
	String StrDIVISION  ="select asa from AsData asa,SwEstimate se ,SwProblem sp ,Docket d,Division di "
			+ " where se.problem.Id =sp.Id and sp.docket.Id =d.Id and d.divisiondocket.Id =di.Id and di.Id= ?";

	
	@Query("select AD from AsData AD where AD.Id in :ids")
	List<AsData> findasdatabyids(@Param("ids")Long[] id);
	
	@Query(StrCONSTITUENCY)
   List<AsData> findbyconstitunecyId(long id);
	
	String StrCONSTITUENCY ="select asa from AsData asa,SwEstimate se ,SwProblem sp ,Constituency c where se.problem.Id =sp.Id and sp.constituency.Id=c.Id and c.Id= ?";

	
	
	@Query("select c from Constituency c order by name")
	List<Constituency> findallconstitunecynames();


	@Query("select AD from AsData AD where AD.ts_date= ?")
	List<AsData> findOnebydate(@Param("date")Date date);

	
	//@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
}
