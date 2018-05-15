package com.mm.swims.Repository;

import java.awt.geom.Arc2D.Float;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mm.swims.Entity.AsDataView;
import com.mm.swims.Entity.AsTsActivityView;
import com.mm.swims.Entity.AsTsAwardView;
import com.mm.swims.Entity.AsTsConstituencyView;
import com.mm.swims.Entity.AsTsDivisionView;
import com.mm.swims.Entity.AsTsHeadwiseView;
import com.mm.swims.Entity.AsTsSchemeView;
import com.mm.swims.Entity.AsTsSectionView;

@Repository
public interface ASDataViewRepository extends JpaRepository<AsDataView, Long>{
//,AsdataViewRepo2
	 
	//@Query("select asa.division_name,asa.approved_date,asa.total_cost from AsDataView asa ")
	
	//@Query(sql1)
	@Query("select astsdiv from AsTsDivisionView astsdiv ")
	List<AsTsDivisionView> findalldivisionvsworks();
	
	@Query("select astssec from AsTsSectionView astssec order by astssec.section_name")
	List<AsTsSectionView> findallsectionvsworks();

	@Query("select astscosti from AsTsConstituencyView astscosti order by astscosti.name")
	List<AsTsConstituencyView> findallconstituencyworks();
	
	@Query("select astsheadw from AsTsHeadwiseView astsheadw ")
	List<AsTsHeadwiseView> findallheadwiseworks();
	
	@Query("select astsawards from AsTsAwardView astsawards")
	List<AsTsAwardView> findallawardsworks();
	
	@Query("select act from AsTsActivityView act")
	List<AsTsActivityView> findallactivityworks();
	
	@Query("select shc from AsTsSchemeView shc")
	List<AsTsSchemeView> findallschemeworks();
	
	
	        @Query(HeadwiseDetails)
			List<AsDataView> findheadwisedetails(@Param("startdate")Date startdate,@Param("enddate")Date enddate,@Param("headwise")String headwise);
                String HeadwiseDetails="select asa from AsDataView asa where "
						 
										 + "asa.head_of_account = :headwise "
				                         + "and asa.ts_date BETWEEN :startdate AND :enddate ";
	 
	 
	        @Query(ActivityDetails)
	        List<AsDataView> findactivitydetails(@Param("activity")String activity, @Param("startdate")Date startdate,@Param("enddate")Date enddate);
		 		String ActivityDetails="select asa from AsDataView asa where "
				 
								 + "asa.activity = :activity "
		                         + "and asa.ts_date BETWEEN :startdate AND :enddate ";
		 		
	        @Query(AwardDetails)		
			List<AsDataView> findawarddetails(@Param("award_of_work") String award_of_work,@Param("startdate") Date startdate,@Param("enddate") Date enddate);

		 		String AwardDetails="select asa from AsDataView asa where "
				 
								 + "asa.award_of_work = :award_of_work "
		                         + "and asa.ts_date BETWEEN :startdate AND :enddate ";
	 		
	 		
	 		@Query(SchemeDetails)		
			List<AsDataView> findschemedetails(@Param("scheme") String scheme,@Param("startdate") Date startdate,@Param("enddate") Date enddate);
				String SchemeDetails="select asa from AsDataView asa where "
				 
								 + "asa.funding_project_scheme = :scheme "
		                         + "and asa.ts_date BETWEEN :startdate AND :enddate ";
			
	        @Query(ConstituencyDetails)		
		    List<AsDataView> findconstituencydetails(@Param("cname") String cname,@Param("startdate") Date startdate,@Param("enddate") Date enddate);
	     
			     String ConstituencyDetails="select asa from AsDataView asa where "
					 
									 + "asa.name = :cname "
			                         + "and asa.ts_date BETWEEN :startdate AND :enddate ";
	     
	        @Query(DivisionDetails)		
            List<AsDataView> finddivisiondetails(@Param("divisionname")String divisionname,@Param("startdate") Date startdate,@Param("enddate") Date enddate);
	 	     
		 	     String DivisionDetails="select asa from AsDataView asa where "
		 			 
		 							 + "asa.division_name = :divisionname "
		 	                         + "and asa.ts_date BETWEEN :startdate AND :enddate ";
	 	     
	 	    @Query(SeletionDetails)		
	 		List<AsDataView> findsectiondetails(@Param("sectionname")String sectionname,@Param("startdate") Date startdate,@Param("enddate")Date enddate);
	 		     
	 		     String SeletionDetails="select asa from AsDataView asa where "
	 				 
	 								 + "asa.section_name = :sectionname "
	 		                         + "and asa.ts_date BETWEEN :startdate AND :enddate ";



	
	@Query(sql2)

	List<AsDataView> findalldivisionvsworks1();

	@Query(sql3)

	List<AsDataView> findalldivisionvsworks2();

	@Query(sql4)

	List<AsDataView> findalldivisionvsworks3();


	
	
	  String sql1=	"select asa.division_name,sum(asa.total_cost) as total_cost_14_15,count(*) as no_of_works_14_15 from AsDataView asa where ts_date > to_date('31-3-2014' ,'dd-mm-yyyy') "+ 
	               " and ts_date > to_date('01-4-2015' ,'dd-mm-yyyy') group by asa.division_name";
  
	  String sql2=	"select asa.division_name,sum(asa.total_cost) as total_cost_15_16,count(*) as no_of_works_15_16 from AsDataView asa where ts_date > to_date('31-3-2015' ,'dd-mm-yyyy') "+ 
          " and ts_date > to_date('01-4-2016' ,'dd-mm-yyyy') group by asa.division_name";
  
	  String sql3=	"select asa.division_name,sum(asa.total_cost) as total_cost_16_17,count(*) as no_of_works_16_17 from AsDataView asa where ts_date > to_date('31-3-2016' ,'dd-mm-yyyy') "+ 
          " and ts_date > to_date('01-4-2017' ,'dd-mm-yyyy') group by asa.division_name";
  
	  String sql4=	"select asa.division_name,sum(asa.total_cost) as total_cost_17_18,count(*) as no_of_works_17_18 from AsDataView asa where ts_date > to_date('31-3-2017' ,'dd-mm-yyyy') "+ 
          " and ts_date > to_date('01-4-2018' ,'dd-mm-yyyy') group by asa.division_name";

	  
	 @Query(report)
	List<AsDataView> generatereportdivision(Optional<String> head_of_account ,Optional<String> activity,Optional<String> award_of_work ,Optional<String> funding_project_scheme ,float contract_amount);
	//@Param("ids") long[] id ,
	
	  String report= "select asa.division_name,count(*),sum(asa.total_cost) from AsDataView asa where "
	  		//+ "where asa.division_id in :ids "
	  		+ "asa.head_of_account = ? " 
	  		
	  		+ "and asa.activity = ? " 
	  		
			+ "and asa.award_of_work = ? " 
			
			+ "and asa.funding_project_scheme = ? " 
			
			+ "and asa.contract_amount <= ? " 



	  		+ " group by asa.division_name ";

    @Query(report2)
   List<AsDataView> generatereportdivision2(@Param("startdate")Date startdate,@Param("enddate") Date enddate,@Param("aids")String[] activity,@Param("hids") String[] head_of_account,@Param("awids") String[] award_of_work,@Param("fsids") String[] funding_project_scheme,@Param("caids") float contract_amount);
   		
              
    
   String report2= "select asa.division_name,count(*),sum(asa.total_cost) from AsDataView asa where "
              
			             + "asa.head_of_account in (:hids)" 
			           // +"and ((:aids is null and asa.activity  is null) or asa.activity  in (:aids))"
			             + "and asa.activity in (:aids)"
			          
					    // +"((:hids IS NULL) OR (:hids IS NOT NULL AND asa.head_of_account IN (:hids) ) )"
						
						// + "and asa.activity in (:aids)"
						//+ "and (:aids IS NOT NULL or :aids = '' or asa.activity  in (:aids) ) "
				  		
				  		+ "and asa.award_of_work in (:awids)" 
						
					    + "and asa.funding_project_scheme in (:fsids)" 
					
					    + "and asa.contract_amount >= (:caids)" 
					    
					    + "and asa.ts_date BETWEEN :startdate AND :enddate "
		               
					    + "group by asa.division_name";


   
	@Query(divunderconstituency)
	List<AsDataView> finddivisionsbyconstituencyid(@Param("ids")String[] id);
	
	@Query(constituencyunderdiv)
	List<AsDataView> findconstituencybydivisionid(@Param("ids") String[] id);


	String constituencyunderdiv = "select distinct(asa.name) from AsDataView asa where " +
				"asa.division_name in :ids" ;
	
	String divunderconstituency = "select distinct(asa.division_name) from AsDataView asa where " +
			"asa.name in :ids" ;


	@Query("select asa.head_of_account from AsDataView asa ")
	Set<AsDataView> findheadwisenames();
	
	@Query("select asa.funding_project_scheme from AsDataView asa ")
	Set<AsDataView> findschemeenames();

  
//      @Modifying
//      @Query(value = ":str", nativeQuery = true)
//      List<AsDataView> report(@Param("str") String str);
   
   /*@Modifying
   @Query(dynamicquery)
   List<AsDataView> report(@Param("dynamic") String dynamic,@Param("dynamicconditions") String dynamicconditions);
   
        //String dynamicquery ="select :dynamic from AsDataView where  : dynamicconditions" ;
*/      
         /* String tablename ="AsDataView";
          String selection ="select";
          
            StringBuilder obj = new StringBuilder();
            obj.append(selection);
              */
            
      

          /*String str1="select asa.division_name,count(asa.division_name),sum(asa.total_cost) from AsDataView asa where "
          		+ "asa.division_name = (:str) "
        		  
			    + "group by asa.division_name";*/





	 //   + "and asa.ts_date > to_date('31-3-2014' ,'dd-mm-yyyy')  and ts_date > to_date('01-4-2015' ,'dd-mm-yyyy')"

 /* "select * from usage where process_time >= :start_date and process_time < :end_date"); */
	  
	  
/*   String sql2=	"select sum(total_cost) from as_data_view  where ts_date > to_date('31-3-2014' ,'dd-mm-yyyy')" + 
				"and ts_date > to_date('01-4-2015' ,'dd-mm-yyyy')"+
				"and division_name = 'Division - V'";*/

	 
	/*StringBuilder queryBuilder = new StringBuilder();
	    queryBuilder.append("select asa.division_name,count(*),sum(asa.total_cost) from AsDataView asa where"); 
	    Boolean flag = true;
	    if(activity != null){
	      if(flag){
	          queryBuilder.append("asa.activity in (:aids)");
	            flag=false;
	        } 
	      }
	    if(award_of_work != null){
	    if(flag){
	     queryBuilder.append("and asa.award_of_work in (:awids)");
	     flag = false;
	    }else{
	      queryBuilder.append("and condition...");
	    }
	   Query query = entityManager.createQuery(queryBuilder.toString());*/
	  


}
