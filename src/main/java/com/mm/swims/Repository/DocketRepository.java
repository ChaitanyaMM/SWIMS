package com.mm.swims.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mm.swims.Entity.Docket;
import com.mm.swims.Entity.Section;


@Repository
@Transactional(readOnly = true)
public interface DocketRepository extends JpaRepository<Docket, Long>  {

  	  
      //@Query(nativeQuery=true,value= "select d from Docket d where d.section.Id = ?" )
	//@Query(value="select d from Docket d inner join d.section on d.section.Id = ?")
	@Query(value="select d  from Docket d,SwProblem r inner join d.section on d.section.Id = ?")
   //@Query(nativeQuery=true,"select b from docket b,section p where b.section_id =3")
	//@Query(nativeQuery=true, value="select d.docket_name from docket d where d.section_id= ?3")
     Set<Docket> findAlldocketsforsection(@Param("section_id") long id);
	
	@Query(value="select d ,r.problem_type,r.responsibility from Docket d,SwProblem r inner join d.divisiondocket on d.divisiondocket.Id = ?")
    List<Docket> findAlldocketsfordivision(@Param("section_id") long id);
	
	@Query(value="select d ,r.problem_type,r.responsibility from Docket d,SwProblem r inner join d.cirledocket on d.cirledocket.Id = ?")
	List<Docket> findAlldocketsforcircle(@Param("section_id") long id);
	
	@Query(value="select d ,r.problem_type,r.responsibility from Docket d,SwProblem r inner join d.subdividocket on d.subdividocket.Id = ?")
	List<Docket> findAlldocketsforsubdivision(@Param("section_id") long id);

    
	@Query("FROM SwProblem p WHERE p.docket.Id = ?")
	/* @Query("Select s from  Docket s "
	            + "join s.problem as se "
	            + "where se.docket.Id = ? ")*/
    List<Docket> findOnedocket(@Param("docket_id") long id);
	//@Query(value= "select d from docket d inner join section s on s.section_id =d.sec_docket_id where d.sec_docket_id = ?1  ",nativeQuery=true)

   
	@Query("select d , r.problem_type,r.responsibility from  Docket d, SwProblem r WHERE d.section.Id= ? group by d , r.problem_type,r.responsibility")
	List<Docket> finddockets(@Param("section_id") long id);

  
	@Query("select d from Docket d where d.docket_name = ?")
	   List<Docket> findname(String name);

	@Query("select sum(d.number_of_manholes) from Docket d where d.section.Id= ?")
	List<Docket> findtotalanholesinasection(long id);

//	@Query("select d.docket_name from Docket d")
//	List<Docket> finddocketnames();

   	}
 