package com.mm.swims.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.mm.swims.Entity.Docket;
import com.mm.swims.Entity.Section;


@Repository 
public interface SectionRepository  extends JpaRepository<Section, Long>{

	@Query("select s from Section  s where s.subdivision.Id =?")
	List<Section> findOnebydivision(long id);

	@Query("select s.section_name from Section s")

	List<Section> findallsectionnames();
	
	
	@Query(sectionunderdiv)
	List<Section> findsectionsbydivision(@Param("ids")String[] id);
    
	 
	  String sectionunderdiv = "select s from Section s,SubDivision sd,Division d where " +
			  						"s.subdivision.subdivison_name =sd.subdivison_name " + 
			  						"and sd.division.divison_name=d.divison_name "  + 
			  						"and d.divison_name in :ids" ;
	
	 
	
 }
 