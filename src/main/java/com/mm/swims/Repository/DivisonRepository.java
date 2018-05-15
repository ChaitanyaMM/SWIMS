package com.mm.swims.Repository;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mm.swims.Entity.Division;

@Repository
public interface DivisonRepository extends JpaRepository<Division, Long> {
 
}
