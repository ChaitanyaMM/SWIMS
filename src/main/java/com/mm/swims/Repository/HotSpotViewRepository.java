package com.mm.swims.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mm.swims.Entity.HotSpotView;

@Repository
public interface HotSpotViewRepository extends JpaRepository<HotSpotView,Long>,PagingAndSortingRepository<HotSpotView, Long>{
	
	
	//@Query("select HV from HotSpotView HV")
	List<HotSpotView> findestimatesview();

	@Query("select hv from HotSpotView hv where hv.Id in :ids")
	List<HotSpotView> findestimatesviewbyid(@Param("ids")Long[] id);
	
    String sql="select hv from HotSpotView hv where hv.Id in :ids";

}
