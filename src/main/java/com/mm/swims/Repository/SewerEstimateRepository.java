package com.mm.swims.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.mm.swims.Entity.SwEstimate;

 
@Repository
public interface SewerEstimateRepository  extends JpaRepository<SwEstimate, Long>{

	
	@Query(S1)
	List<SwEstimate> findestimatesbystatustobedone(String category,String type);
	
	@Query(S2)
	List<SwEstimate> findestimatesbystatudone(String category,String type);

	String S1="select e,e.problem from SwEstimate e where e.project_category =? and e.problem.section.section_name=? and e.status IN ('0','1','2')";
	
	String S2="select e,e.problem from SwEstimate e where e.project_category =? and e.problem.section.section_name=? and e.status IN ('3','4')";

	
	
	
	//String Ses="select e,count(e.project_category) from SwEstimate e where e.status = ? and e.project_category= ?  group by e.Id";
	
	@Query("select e from SwEstimate e where e.status =?")
	List<SwEstimate> findestimatebystatus();
	
}

//e.problem.pk_number
//e.problem.problem_type
//e.problem.solution_category
//e.problem.problem_status
//e.problem.pipe_length
//e.problem.pipe_size