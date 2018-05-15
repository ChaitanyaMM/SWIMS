package com.mm.swims.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mm.swims.Entity.SubDivision;


@Repository
public interface SubDivisionRepository  extends JpaRepository<SubDivision, Long> {

	
	@Query("select sd from SubDivision sd where sd.division.Id = ?")
	List<SubDivision> findOnebydivision(long id);

	
}
