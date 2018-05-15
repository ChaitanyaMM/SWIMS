package com.mm.swims.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mm.swims.Entity.Docket;
import com.mm.swims.Entity.SwProblem;
import com.mm.swims.Entity.SwProblem.ProblemType;

@Repository
public interface SewerProblemRepository  extends JpaRepository<SwProblem, Long>{
	
	@Query("select p.problem_type from  SwProblem p where p.docket.Id= ? ") 
	List<ProblemType> findproblemtypes(@Param("docket_id") long id);

   @Query("select p.responsibility from SwProblem p where p.docket.Id= ?")
	List<SwProblem> findbyidd(@Param("docket_id") long id);

   @Query(sqlstr8)
   //@Query("select sv from SwProblem sv ,Docket d where sv.problem_type= ? and d.docket_name = ?")
    List<SwProblem> findproblemdetails(String type,String name);
   
   
   String sqlstr5="select sp from SwProblem sp  where sp.problem_type= :problem_type";
   String sqlstr6="select p from SwProblem p ,Docket d  where d.docket_name= 'D-2' AND p.problem_type= 0 ";
   
   
   String sqlstr8="select p from SwProblem p where p.problem_type = ? and p.docket.docket_name =?";


// AND d.docket_name= ?
   
   

}