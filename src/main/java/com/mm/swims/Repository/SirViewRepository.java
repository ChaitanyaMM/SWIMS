package com.mm.swims.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.mm.swims.Entity.SirView;

@Repository
public interface SirViewRepository extends JpaRepository<SirView, Long>{
   
	
	//@Query("from SirView SV")
	List<SirView> findAllwithproblem();
	
	// String sqlstr2="select D,P.problem_type from Docket D ,SwProblem P   where P.docket.Id = D.cirledocket.Id  AND D.cirledocket.Id = ?";
	// String sqlstr3="select SV from SirView SV where SV.Id IN( select d.Id from docket d where d.circle.id = ?)";
	/*join_tab_name = prm_1 "_id"
	dkt_ids = select d.docket_id from docket d where join_tab_name = 2*/
   String sqlstr ="select SV from SirView SV" ;
   String sqlstr4 ="select SV from SirView SV where SV.Id IN( select d.Id from Docket d where d.cirledocket.Id = ?)" ;

   String sqlstr5="select SV from SirView SV, Docket D where  SV.Id =  D.Id  AND D.cirledocket.Id in :ids";
   String sqlstr6="select SV from SirView SV, Docket D where  SV.Id =  D.Id  AND D.divisiondocket.Id in :ids";
   String sqlstr7="select SV from SirView SV, Docket D where  SV.Id =  D.Id  AND D.subdividocket.Id in :ids";
   String sqlstr8="select SV from SirView SV, Docket D where  SV.Id =  D.Id  AND D.section.Id in :ids";
//    @Modifying   
 	@Query(sqlstr5)
	List<SirView> findAllwithproblem2(@Param("ids")Long[] id);
 	@Query(sqlstr6)
	List<SirView> findAllwithproblem3(@Param("ids")Long[] id);
 	@Query(sqlstr7)
	List<SirView> findAllwithproblem4(@Param("ids")Long[] id);
 	@Query(sqlstr8)
	List<SirView> findAllwithproblem5(@Param("ids")Long[] id);
 	
// 	@Query("select from ")
//	List<SirView> findbyboundaryid(String id, String name);
}
