package com.mm.swims.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Multiset.Entry;
import com.mm.swims.Entity.AsData;
import com.mm.swims.Entity.AsDataView;
import com.mm.swims.Entity.AsTsActivityView;
import com.mm.swims.Entity.AsTsAwardView;
import com.mm.swims.Entity.AsTsConstituencyView;
import com.mm.swims.Entity.AsTsDivisionView;
import com.mm.swims.Entity.AsTsHeadwiseView;
import com.mm.swims.Entity.AsTsSchemeView;
import com.mm.swims.Entity.AsTsSectionView;
import com.mm.swims.Entity.Constituency;
import com.mm.swims.Entity.SwEstimate;
import com.mm.swims.Entity.SwProblem;
import com.mm.swims.Repository.ASDataRepository;
import com.mm.swims.Repository.ASDataViewRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/swims/asdata")
@Api(value = "Sewer-ASDataController", tags = "SWIMS API")
public class ASDataController {
	
   @PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ASDataRepository asdataRepo;
	
	@Autowired
	private ASDataViewRepository asdataviewRepo;
	
/*	 @Autowired
     private SessionFactory sessionFactory;*/
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String sample() {

		return "ASDATA in SWIMS is UP !!..";

	}
	
	@ApiOperation(value = "as creation", response = AsData.class)
	@RequestMapping(value = "/insert-as", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Createsection(@RequestParam SwEstimate id, @RequestBody String data)
			throws IOException, ParseException {
		System.out.println("insert-as service is Calling !.");
		AsData estimate = new AsData();

		try {
			estimate = new ObjectMapper().readValue(data, AsData.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entered");
		AsData fecthed = asdataRepo.save(estimate);
		System.out.println("Checking sewer  method");

		map.put("Data", fecthed);
		map.put("message", "AS-Data Created Successfully. !.");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	
	@ApiOperation(value = "find-by-division", response = AsData.class)
	@RequestMapping(value = "/find-by-division", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbydivision(@RequestParam long id)
			throws IOException, ParseException {
		System.out.println("find-all-estimates  Service is Calling !!!!");
		List<AsData> fecthed = asdataRepo.findbydivisionId(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
//		@ApiOperation(value = "find-by-division", response = AsData.class)
//	@RequestMapping(value = "/find-by-constitunecy", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<Map<String, Object>> findbyconstitunecy(@RequestParam long id)
//			throws IOException, ParseException {
//		System.out.println("find-all-estimates  Service is Calling !!!!");
//		List<AsData> fecthed = asdataRepo.findbyconstitunecyId(id);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("Data", fecthed);
//		map.put("message", "Successfully Retrieved data");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}
	
	@ApiOperation(value = "find-by-section", response = AsData.class)
	@RequestMapping(value = "/find-by-section", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbysection(@RequestParam long id) throws IOException {
		
		System.out.println("find-all-estimates  Service is Calling !!!!");
		System.out.println("asdataRepo<><><!!" +asdataRepo);
		List<AsData> fecthed = asdataRepo.findbysectionId(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	
	
	@ApiOperation(value = "find-all-as-data", response = AsData.class)
	@RequestMapping(value = "/find-all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findasdata() throws IOException {
		
		System.out.println("find-all-estimates  Service is Calling !!!!");
		System.out.println("asdataRepo<><><!!" +asdataRepo);
		List<AsData> fecthed = asdataRepo.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	@ApiOperation(value = "find-all-as-data", response = AsData.class)
	@RequestMapping(value = "/find-by-id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbyid(@RequestParam long id) throws IOException {
		
		System.out.println("find-all-estimates  Service is Calling !!!!");
		System.out.println("asdataRepo<><><!!" +asdataRepo);
		AsData fecthed = asdataRepo.findOne(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "find-by-date", response = AsData.class)
	@RequestMapping(value = "/find-by-date", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbydate(@RequestParam(name ="date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws IOException {
		
		System.out.println("find-by-date  Service is Calling !!!!");
		System.out.println("asdataRepo<><><!!" +asdataRepo);
		List<AsData> fecthed = asdataRepo.findOnebydate(date);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "find-constituencyname", response = Constituency.class)
	@RequestMapping(value = "/find-constituencyname", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findconstituencyname() throws IOException {
		
		System.out.println("find-constituencyname  Service is Calling !!!!");
		System.out.println("asdataRepo<><><!!" +asdataRepo);
		List<Constituency> fecthed = asdataRepo.findallconstitunecynames();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "find-all-estimates-by-id", response = AsData.class)
	@RequestMapping(value = "/find-all-by-ids", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findestimatesviewbyid(@RequestParam Long[] id) throws IOException {
		
		System.out.println("find-all-estimates  Service is Calling !!!!");
		System.out.println("asdataRepo"+asdataRepo);
		List<AsData> fecthed = asdataRepo.findasdatabyids(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	

	
	 /*AS DATA VIEW SERVICES TO ACCSS THE VIEW*/
	
	@ApiOperation(value = "find-all-asdataview", response = AsDataView.class)
	@RequestMapping(value = "/find-all-asdataview", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findAsDataView() throws IOException {
		
		System.out.println("find-all-estimates  Service is Calling !!!!");
		System.out.println("asdataRepo<><><!!" +asdataRepo);
		List<AsDataView> fecthed = asdataviewRepo.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findalldivisionworks", response = AsTsDivisionView.class)
	@RequestMapping(value = "/find-all-divisionworks", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findalldivisionvsworks() throws IOException {
		System.out.println("fetching by id");
 		List<AsTsDivisionView> fecthed = asdataviewRepo.findalldivisionvsworks();
 		/*List<AsDataView> fecthed1 = asdataviewRepo.findalldivisionvsworks1();
 		List<AsDataView> fecthed2 = asdataviewRepo.findalldivisionvsworks2();
 		List<AsDataView> fecthed3 = asdataviewRepo.findalldivisionvsworks3();*/
 		/*List<AsDataView> object = new ArrayList<AsDataView>();
 		object.addAll(fecthed);
 		object.addAll(fecthed1);
 		object.addAll(fecthed2);
 		object.addAll(fecthed3);
 		System.out.println("object<><>"+object);
 		System.out.println("object<><>"+object.size());*/  
 		
 		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("Data", fecthed);
     /* map.put("2015-2016", fecthed1);
        map.put("2016-2017", fecthed2);
        map.put("2017-2018", fecthed3);*/
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	

	/*@ApiOperation(value = "findalldivisionworks", response = AsDataView.class)
	@RequestMapping(value = "/find-all-divisionworks", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findalldivisionvsworks() throws IOException {
		System.out.println("fetching by id");
		List<AsDataView> fecthed = asdataviewRepo.findalldivisionvsworks();

		Gson gson = new Gson();
		String json = gson.toJson(fecthed);
		System.out.println("json<><>" + json);

		List<AsDataView> fecthed1 = asdataviewRepo.findalldivisionvsworks1();
		List<AsDataView> fecthed2 = asdataviewRepo.findalldivisionvsworks2();
		List<AsDataView> fecthed3 = asdataviewRepo.findalldivisionvsworks3();

		System.out.println("fecthed" + fecthed);
		System.out.println("fecthed1" + fecthed1);
		System.out.println("fecthed2" + fecthed2);
		System.out.println("fecthed3" + fecthed3);

		
		 * String serverResponse = "fecthed"; JSONArray serverJsonArray = new
		 * JSONArray(serverResponse);
		 * 
		 * ArrayList<String> products = new
		 * ArrayList<>(serverJsonArray.length()); for(int i = 0; i <
		 * serverJsonArray.length(); i++){
		 * products.add(serverJsonArray.getString(i)); }
		 

		
		 * TreeMap<String, Object> myMap = new TreeMap<String, Object>();
		 * myMap.put(myMap.firstKey(), ((TreeMap<String, Object>)
		 * fecthed).firstEntry().getValue()); myMap.firstEntry().getValue();
		 * myMap.get(myMap.firstKey());
		 * 
		 * System.out.println("myMap<><>"+myMap.firstKey());
		 

		// for(AsDataView asv :fecthed ){
		// asv.getDivison_name();
		// asv.getTs_date();
		// asv.getTotal_cost();
		//
		// System.out.println(asv);
		//
		// }

		List<AsDataView> object = new ArrayList<AsDataView>();
		object.addAll(fecthed);
		object.addAll(fecthed1);
		object.addAll(fecthed2);
		object.addAll(fecthed3);
		System.out.println("object<><>" + object);
		Map<String, Object> map = new HashMap<String, Object>();

		
		 * map.put("divisionname", object.get(0)); map.put("date",
		 * object.get(1)); map.put("total_amount", object.get(2));
		 
		
		 * map.put("Data14-15", fecthed); map.put("Data15-16", fecthed1);
		 * map.put("Data16-17", fecthed2); map.put("Data17-18", fecthed3);
		 

		JSONObject jResult = new JSONObject();// main object
		JSONArray jArray = new JSONArray(object);// /ItemDetail jsonArray
		System.out.println("jArray<><><>" + jArray);

		
		 * for (int i = 0; i < fecthed.size(); i++) { JSONObject jGroup = new
		 * JSONObject();// /sub Object
		 * 
		 * try { jGroup.put("division_name", fecthed.get(0).getDivison_name());
		 * jGroup.put("no_of_works", fecthed.get(1).getTs_date());
		 * jGroup.put("total_cost", fecthed.get(2).getTotal_cost());
		 * 
		 * jArray.put(jGroup);
		 * 
		 * // /itemDetail Name is JsonArray Name jResult.put("Data", jArray); }
		 * catch (JSONException e) { e.printStackTrace(); }
		 * 
		 * }
		 

		// map.put("Data", json.toString());

		map.put("Data", jArray);

		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
        
	  public static void printMap(Map<AsDataView, Integer> map){

			for (Entry<AsDataView, Integer> entry : map.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " Value : "
					+ entry.getValue());
			}
	   }
	
	
        
        public void itemListToJsonConvert(ArrayList<HashMap<String, String>> list) {

            JSONObject jResult = new JSONObject();// main object
            JSONArray jArray = new JSONArray();// /ItemDetail jsonArray

            for (int i = 0; i < list.size(); i++) {
                JSONObject jGroup = new JSONObject();// /sub Object

                try {
                    jGroup.put("ItemMasterID", list.get(i).get("ItemMasterID"));
                    jGroup.put("ID", list.get(i).get("id"));
                    jGroup.put("Name", list.get(i).get("name"));
                    jGroup.put("Category", list.get(i).get("category"));

                    jArray.put(jGroup);

                    // /itemDetail Name is JsonArray Name
                    jResult.put("itemDetail", jArray);
                    return jResult;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }
	*/
	
	@ApiOperation(value = "findallsection", response = AsTsSectionView.class)
	@RequestMapping(value = "/find-all-sectionworks", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallsectionworks() throws IOException {
		System.out.println("fetching by id");
 		List<AsTsSectionView> fecthed = asdataviewRepo.findallsectionvsworks();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findallconstitunecyworks", response = AsTsConstituencyView.class)
	@RequestMapping(value = "/find-all-constitunecyworks", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallconstitunecyworks() throws IOException {
		System.out.println("fetching by id");
 		List<AsTsConstituencyView> fecthed = asdataviewRepo.findallconstituencyworks();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findallheadwiseworks", response = AsTsHeadwiseView.class)
	@RequestMapping(value = "/find-all-headwiseworks", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallheadwiseworks() throws IOException {
		System.out.println("fetching by id");
 		List<AsTsHeadwiseView> fecthed = asdataviewRepo.findallheadwiseworks();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findallawardworksworks", response = AsTsAwardView.class)
	@RequestMapping(value = "/find-all-awardworks", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallawardworks() throws IOException {
		System.out.println("fetching awardworks<><>");
 		List<AsTsAwardView> fecthed = asdataviewRepo.findallawardsworks();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findallactivityworks", response = AsTsActivityView.class)
	@RequestMapping(value = "/find-all-activityworks", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallactivityworks() throws IOException {
		System.out.println("fetching by id");
 		List<AsTsActivityView> fecthed = asdataviewRepo.findallactivityworks();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findallschemeworks", response = AsTsSchemeView.class)
	@RequestMapping(value = "/find-all-schemeworks", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallschemeworks() throws IOException {
		System.out.println("fetching by id");
 		List<AsTsSchemeView> fecthed = asdataviewRepo.findallschemeworks();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findallamountwiseworks", response = AsDataView.class)
	@RequestMapping(value = "/find-all-amountwiseworks", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallamountwiseworks() throws IOException {
		System.out.println("fetching by id");
 		List<AsDataView> fecthed = asdataviewRepo.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "generate-report", response = AsDataView.class)
	@RequestMapping(value = "/generate-report", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> generatereport(@RequestParam(required = false, value = "activity") Optional<String>  activity,@RequestParam(required = false, value = "head_of_account") Optional<String> head_of_account,@RequestParam(required = false, value = "award_of_work") Optional<String> award_of_work ,@RequestParam(required =false, defaultValue = "null",value = "funding_project_scheme") Optional<String> funding_project_scheme ,@RequestParam(required = true, value = "contract_amount") float contract_amount) throws IOException {
		//@RequestParam String boundary ,
		//@RequestParam long[] id
		//(required = false, value = "sortby")
		System.out.println("fetching by id");
 		List<AsDataView> fecthed = asdataviewRepo.generatereportdivision(activity,head_of_account,award_of_work,funding_project_scheme,contract_amount);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "generate-report", response = AsDataView.class)
	@RequestMapping(value = "/generate-report2", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> generatereport2(@RequestParam(name ="startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,
			@RequestParam(name ="enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate,
			@RequestParam(value = "division", required = false) String[] division,
			@RequestParam(value = "constituency", required = false) String[] constituency,
			@RequestParam(value = "section", required = false) String[] section,
			@RequestParam(value = "activity", required = false) String[] activity,
			@RequestParam(value = "head_of_account", required = false) String[] head_of_account,
			@RequestParam(value = "award_of_work", required = false) String[] award_of_work,
			@RequestParam(value = "funding_project_scheme", required = false) String[] funding_project_scheme ,
			@RequestParam(value = "contract_amount", required = false, defaultValue="0") float contract_amount)
			 throws Exception {
		//
		
		System.out.println("group -report 2 service is caalling");
		
		
	  
		System.out.println("hai");
		   		
		List<AsDataView> fecthed = Dynamic2(startdate,enddate,division,constituency,section,activity,head_of_account,award_of_work,funding_project_scheme,contract_amount);
		
		//Map<String, Object> fecthed2 = Dynamic(startdate,enddate,division,constituency,section,activity,head_of_account,award_of_work,funding_project_scheme,contract_amount);

		//,contract_amount
 		System.out.println("afer dynamic method");

 		System.out.println("fecthed<><"+fecthed);
 		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		//map.put("Data-2", fecthed2);

		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	/*//@Transactional
	@SuppressWarnings("unchecked")
	public Map<String, Object> Dynamic(Date startdate,Date enddate,String[] division,String[] constituency,String[] section,String[] activity,String[] head_of_account,String[] award_of_work,String[] funding_project_scheme,float contract_amount) throws Exception{
		//
		System.out.println("into dynamic method");
 		Map<String, Object> paramterMap = new HashMap<String, Object>();
 		
 		//AsDataView object = new AsDataView();
		StringBuilder query = new StringBuilder();
	    query.append("select ");
	     //input  play !!!
	    
	    
	      if(division !=null){
			  query.append("asa.division_name");
	    	  query.append(",");
	      }
	      
	      if(constituency !=null){
			  query.append("asa.name");
      	  	  query.append(",");
	      }
	      
	      if(section !=null){
			  query.append("asa.section_name");
      	  	  query.append(",");
	      }
	      
	      if(head_of_account !=null){
			  query.append("asa.head_of_account");
	      	  query.append(",");
	      }
	      
		  if(activity !=null){
			  query.append("asa.activity");
		  	  query.append(",");
		  }
		  
          if(award_of_work!=null){
        	  query.append("asa.award_of_work");
          	  query.append(",");
          }
          if(contract_amount !=0){
        	  query.append("asa.contract_amount");
          	  query.append(",");
          }
          if(funding_project_scheme!=null){
        	  query.append("asa.funding_project_scheme");
      	      query.append(",");
          }
          	 query.append("count(*),sum(asa.total_cost) from AsDataView asa where ");

	    
	    //conditions play !!!
          	 
           if(startdate!=null & enddate !=null){
           	  //query.append("and ");
           	  query.append("asa.ts_date BETWEEN '");
           	  query.append(startdate);
           	  query.append("'");
           	  query.append(" AND ");
                 query.append("'");
   			  query.append(enddate);
           	  query.append("'");

             }
	      if(division !=null){
           	  query.append("and ");
			  query.append("asa.division_name in (");
			  for(String strdiv :division){
				  query.append("'"+strdiv+"',");
				  System.out.println("strdiv"+strdiv.toString());

			   }
			  	  query.deleteCharAt(query.length() -1);
//	    	   query.append(division);
//	           query.append("'");

			  System.out.println("division"+division.toString());
			  query.append(")");
			  paramterMap.put("division",division);
			  
			  
	      }
	      
	      if(constituency !=null){
			  query.append("and ");
			  query.append("asa.name in (");
			  for(String strconsti :constituency){
				  query.append("'"+strconsti+"',");
			   }
			  	  query.deleteCharAt(query.length() -1);
//			  query.append(constituency);
//        	  query.append("'");

			  query.append(")");
			  paramterMap.put("name", constituency);

	      }
	      if(section !=null){
	    	  query.append("and ");
			  query.append("asa.section_name in (");
			  for(String strsec :section){
				  query.append("'"+strsec+"',");
			   }
			  	  query.deleteCharAt(query.length() -1);
        	  //query.append("'");
			  query.append(")");
			  paramterMap.put("section_name", section);

			  
	      }
	      if(head_of_account !=null){
	    	  query.append("and ");
			  query.append("asa.head_of_account in (");
			  for(String strhe :head_of_account){
				  query.append("'"+strhe+"',");
			  }
			  	  query.deleteCharAt(query.length() -1);
			  System.out.println("head_of_account"+head_of_account);
        	  //query.append("'");
			  query.append(")");
			  paramterMap.put("head_of_account", head_of_account);

	      }  
		  if(activity !=null){
			  query.append("and ");
			  query.append("asa.activity in (");
			  for(String stra :activity){
				  query.append("'"+stra+"',");
				  }
				  query.deleteCharAt(query.length() -1);
        	 // query.append("'");
			  	query.append(")");
			paramterMap.put("activity", activity);

		  }
          if(award_of_work!=null){
        	  query.append("and ");
        	  query.append(" asa.award_of_work in (");
        	  for(String straward :award_of_work){
				  query.append("'"+straward+"',");
				  }
				  query.deleteCharAt(query.length() -1);
			  query.append(")");
			paramterMap.put("award_of_work", award_of_work);

          }
          if(funding_project_scheme!=null){
        	  query.append("and ");
        	  query.append("asa.funding_project_scheme in (");
        	  for(String strfun :funding_project_scheme){
				  query.append("'"+strfun+"',");
				  }
				  query.deleteCharAt(query.length() -1);
        	 // query.append("'");
			  query.append(")");
			paramterMap.put("funding_project_scheme", funding_project_scheme);

          }  
          if(contract_amount !=0){
        	 
		       query.append("and ");
			   query.append("asa.contract_amount >= ('");
			   query.append(contract_amount);
			   query.append("'");
			   query.append(")");
			paramterMap.put("contract_amount", contract_amount);

			   
		    }
         
          
          
    	     query.append(" group by ");
    	     //group by play!!!
    	     
    	     String values[] ={"asa.division_name","asa.name","asa.section_name","asa.head_of_account","asa.activity","asa.award_of_work",
    	    		 			"asa.funding_project_scheme","asa.contract_amount"};
    	     
    	         for(String val : values){
    	        	 
    	        	 query.append(val).append(",");
    	         }
    	          System.out.println();
    	         query.deleteCharAt(query.length() -1);
    	   if(division !=null && constituency !=null && section !=null && head_of_account !=null && activity !=null && award_of_work !=null
    			   && funding_project_scheme !=null && contract_amount==-1 ){
   			  		query.append("asa.division_name").append(",")
   			  			 .append("asa.name").append(",")
   			  			 .append("asa.section_name").append(",")
   			  			 .append("asa.head_of_account")
   			  			 .append(",").append("asa.activity").append(",")
   			  			 .append("asa.award_of_work").append(",")
   			  			 .append("asa.funding_project_scheme").append(",")
   			  			 .append("asa.contract_amount");
   			  //query.append(",");
    	  // }
    	       if(division !=null){
    	    	 query.append("asa.division_name")
    	     }
   	       if(constituency !=null){
   			  query.append("asa.name");
   			  query.append(",");

   	       }
   	       if(section !=null){
   			  query.append("asa.section_name");
   			  query.append(",");

   	       }
   	       if(head_of_account !=null){
   			  query.append("asa.head_of_account");
   			  query.append(",");

   	       }
   		   if(activity !=null){
   			  query.append("asa.activity");
   			  query.append(",");

   		   }
           if(award_of_work!=null){
           	  query.append("asa.award_of_work");
   			  query.append(",");

           }
           if(funding_project_scheme!=null){
           	  query.append("asa.funding_project_scheme");
   			  query.append(",");

           }
          if(contract_amount==-1){
           	  query.append("asa.contract_amount");
   			  //query.append(",");

 	       }
    	      //query.toString();
    	      //Query query2= new 
    	  	//SessionFactory sessionFactory;

			//Session session =sessionFactory.openSession() ;
    			System.out.println("above the entitiamanger query  ");
    			System.out.println("em  "+em);
    			
    			Query result = em.createQuery(query.toString());
    			
    			
			   System.out.println("result "+result);
			   System.out.println("query,.,."+query);
		       System.out.println("keyvalues,.,."+paramterMap);
		            
		            
		          
		           
				List<AsDataView> results  =result.getResultList();
				System.out.println("results,.,,"+results.size());
				return paramterMap;
		
		
		
	}
	*/
	
	@SuppressWarnings("unchecked")
	public List<AsDataView> Dynamic2(Date startdate,Date enddate,String[] division,String[] constituency,String[] section,String[] activity,String[] head_of_account,String[] award_of_work,String[] funding_project_scheme,float contract_amount) throws Exception{
		//
		System.out.println("into dynamic method");
 		Map<String, Object> paramterMap = new HashMap<String, Object>();
 		
 		//AsDataView object = new AsDataView();
		StringBuilder query = new StringBuilder();
	    query.append("select ");
	     //input  play !!!
	    
	    
	      if(division !=null){
			  query.append("asa.division_name");
	    	  query.append(",");
	      }
	      
	      if(constituency !=null){
			  query.append("asa.name");
      	  	  query.append(",");
	      }
	      
	      if(section !=null){
			  query.append("asa.section_name");
      	  	  query.append(",");
	      }
	      
	      if(head_of_account !=null){
			  query.append("asa.head_of_account");
	      	  query.append(",");
	      }
	      
		  if(activity !=null){
			  query.append("asa.activity");
		  	  query.append(",");
		  }
		  
          if(award_of_work!=null){
        	  query.append("asa.award_of_work");
          	  query.append(",");
          }
          if(contract_amount !=0){
        	  query.append("asa.contract_amount");
          	  query.append(",");
          }
          if(funding_project_scheme!=null){
        	  query.append("asa.funding_project_scheme");
      	      query.append(",");
          }
          	 query.append("count(*),sum(asa.total_cost) from AsDataView asa where ");

          	  //query.append("select asa.division_name,count(*),sum(asa.total_cost) from AsDataView asa where");
	    
	    //conditions play !!!
          
         if(startdate!=null & enddate !=null){
          	//  query.append("and ");
          	  query.append("asa.ts_date BETWEEN '");
          	  query.append(startdate);
          	  query.append("'");
          	  query.append(" AND ");
                query.append("'");
  			  query.append(enddate);
          	  query.append("'");

            }
	      if(division !=null){
          	  query.append("and ");
			  query.append("asa.division_name in (");
			  for(String strdiv :division){
				  query.append("'"+strdiv+"',");
				  System.out.println("strdiv"+strdiv.toString());

			   }
			  	  query.deleteCharAt(query.length() -1);
//	    	   query.append(division);
//	           query.append("'");

			  System.out.println("division"+division.toString());
			  query.append(")");
			  paramterMap.put("division",division);
			  
			  
	      }
	      
	      if(constituency !=null){
			  query.append("and ");
			  query.append("asa.name in (");
			  for(String strconsti :constituency){
				  query.append("'"+strconsti+"',");
			   }
			  	  query.deleteCharAt(query.length() -1);
//			  query.append(constituency);
//        	  query.append("'");

			  query.append(")");
			  paramterMap.put("name", constituency);

	      }
	      if(section !=null){
	    	  query.append("and ");
			  query.append("asa.section_name in (");
			  for(String strsec :section){
				  query.append("'"+strsec+"',");
			   }
			  	  query.deleteCharAt(query.length() -1);
        	  //query.append("'");
			  query.append(")");
			  paramterMap.put("section_name", section);

			  
	      }
	      if(head_of_account !=null){
	    	  query.append("and ");
			  query.append("asa.head_of_account in (");
			  for(String strhe :head_of_account){
				  query.append("'"+strhe+"',");
			  }
			  	  query.deleteCharAt(query.length() -1);
			  System.out.println("head_of_account"+head_of_account);
        	  //query.append("'");
			  query.append(")");
			  paramterMap.put("head_of_account", head_of_account);

	      }  
		  if(activity !=null){
			  query.append("and ");
			  query.append("asa.activity in (");
			  for(String stra :activity){
				  query.append("'"+stra+"',");
				  }
				  query.deleteCharAt(query.length() -1);
        	 // query.append("'");
			  	query.append(")");
			paramterMap.put("activity", activity);

		  }
          if(award_of_work!=null){
        	  query.append("and ");
        	  query.append(" asa.award_of_work in (");
        	  for(String straward :award_of_work){
				  query.append("'"+straward+"',");
				  }
				  query.deleteCharAt(query.length() -1);
			  query.append(")");
			paramterMap.put("award_of_work", award_of_work);

          }
          if(funding_project_scheme!=null){
        	  query.append("and ");
        	  query.append("asa.funding_project_scheme in (");
        	  for(String strfun :funding_project_scheme){
				  query.append("'"+strfun+"',");
				  }
				  query.deleteCharAt(query.length() -1);
        	 // query.append("'");
			  query.append(")");
			paramterMap.put("funding_project_scheme", funding_project_scheme);

          }  
          if(contract_amount !=0){
        	 
		       query.append("and ");
			   query.append("asa.contract_amount = ('");
			   query.append(contract_amount);
			   query.append("'");
			   query.append(")");
			paramterMap.put("contract_amount", contract_amount);

			   
		    }
          
          
          
    	     query.append(" group by ");
    	     //group by play!!!
    	     
//    	     String values[] ={"asa.division_name","asa.name","asa.section_name","asa.head_of_account","asa.activity","asa.award_of_work",
//    	    		 			"asa.funding_project_scheme","asa.contract_amount"};
//    	     
//    	         for(String val : values){
//    	        	 
//    	        	 query.append(val).append(",");
//    	         }
//    	          System.out.println();
//    	         query.deleteCharAt(query.length() -1);
    	   /*if(division !=null && constituency !=null && section !=null && head_of_account !=null && activity !=null && award_of_work !=null
    			   && funding_project_scheme !=null && contract_amount==-1 ){
   			  		query.append("asa.division_name").append(",")
   			  			 .append("asa.name").append(",")
   			  			 .append("asa.section_name").append(",")
   			  			 .append("asa.head_of_account")
   			  			 .append(",").append("asa.activity").append(",")
   			  			 .append("asa.award_of_work").append(",")
   			  			 .append("asa.funding_project_scheme").append(",")
   			  			 .append("asa.contract_amount");*/
   			  //query.append(",");
    	  // } */
    	         
    	    if(division !=null){
    	    	 query.append("asa.division_name");
      			  query.append(",");

    	     }
   	       if(constituency !=null){
   			  query.append("asa.name");
   			  query.append(",");

   	       }
   	       if(section !=null){
   			  query.append("asa.section_name");
   			  query.append(",");

   	       }
   	       if(head_of_account !=null){
   			  query.append("asa.head_of_account");
   			  query.append(",");

   	       }
   		   if(activity !=null){
   			  query.append("asa.activity");
   			  query.append(",");

   		   }
           if(award_of_work!=null){
           	  query.append("asa.award_of_work");
   			  query.append(",");

           }
           if(funding_project_scheme!=null){
           	  query.append("asa.funding_project_scheme");
   			  query.append(",");

           }
          if(contract_amount !=0){
        	  query.append("asa.contract_amount");
          	  query.append(",");
          }
           query.deleteCharAt(query.length() -1);

			//Session session =sessionFactory.openSession() ;
    			System.out.println("above the entitiamanger query  ");
    			System.out.println("em  "+em);
    			
    			Query result = em.createQuery(query.toString());
    			
    			
			   System.out.println("into entitiy querying ");
			   System.out.println("result "+result);



    	            /*result.setParameter("division", Arrays.asList(division));
    	            result.setParameter("constituency",Arrays.asList (constituency));
    	            result.setParameter("section", Arrays.asList(section));
    	            result.setParameter("head_of_account", Arrays.asList(head_of_account));
    	            result.setParameter("activity", Arrays.asList(activity));
    	            result.setParameter("award_of_work", Arrays.asList(award_of_work));
    	            result.setParameter("funding_project_scheme",Arrays.asList( funding_project_scheme));
    	            result.setParameter("contract_amount", contract_amount);
    	            result.setParameter("startdate", startdate);
    	            result.setParameter("enddate", enddate);
                        System.out.println("after transcation issssss");*/
    	      
		    	     // Session session = sessionFactory.openSession();
		             // org.hibernate.Query result= session.createQuery(query.toString());
		
					    //ObjectQuery query = em.createQuery(sqlQuery.toString());
					// for(String key :query.get) {
					//	result.setParameter(key, query.get(key));
					//	 }
	            
	            

			   
		            System.out.println("query,.,."+query);
		            System.out.println("keyvalues,.,."+paramterMap);
		            /*for(String key :paramterMap.keySet()) {
		            	result.setParameter(key, paramterMap.get(key));
		            }*/
		            
		          
		           
				List<AsDataView> results  =result.getResultList();
				/*for(java.util.Map.Entry<String, Object[]> entry : paramterMap.entrySet())
			    {   
  
			         System.out.println("Values <><."+entry.getKey() + " : " +entry.getValue().toString());
			    }*/
				
				/*for (AsDataView rank : results) {
					  if (!paramterMap.containsKey(rank.getDivision_name())) {
						  paramterMap.put(rank.getDivision_name(), division);
					  }
			        System.out.println("rank"+rank);
				}*/
				System.out.println("results,.,,"+results.size());
				return results;
		
		
		
	}

	
	
	@ApiOperation(value = "AsTs-report-details", response = AsDataView.class)
	@RequestMapping(value = "/AsTs-report-details", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Astsreportdetails(@RequestParam(name ="startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,
			@RequestParam(name ="enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate,
			@RequestParam(value = "division", required = false) String[] division,
			@RequestParam(value = "constituency", required = false) String[] constituency,
			@RequestParam(value = "section", required = false) String[] section,
			@RequestParam(value = "activity", required = false) String[] activity,
			@RequestParam(value = "head_of_account", required = false) String[] head_of_account,
			@RequestParam(value = "award_of_work", required = false) String[] award_of_work,
			@RequestParam(value = "funding_project_scheme", required = false) String[] funding_project_scheme ,
			@RequestParam(value = "contract_amount", required = false, defaultValue="0") float contract_amount)
			 throws Exception {
		
		System.out.println("AsTs-report-details service is caalling");
		List<AsDataView> fecthed = Reportdetais(startdate,enddate,division,constituency,section,activity,head_of_account,award_of_work,funding_project_scheme,contract_amount);
		System.out.println("afer dynamic method");
		System.out.println("fecthed<><"+fecthed);
		System.out.println("fecthed<><"+fecthed.size());

 		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@SuppressWarnings("unchecked")
	public List<AsDataView> Reportdetais(Date startdate,Date enddate,String[] division,String[] constituency,String[] section,String[] activity,String[] head_of_account,String[] award_of_work,String[] funding_project_scheme,float contract_amount) throws Exception{
		//
		System.out.println("into Reportdetais method");
 		Map<String, Object> paramterMap = new HashMap<String, Object>();
 		
		StringBuilder query = new StringBuilder();
	    query.append("select ");
	    query.append("asa from AsDataView asa where ");

	    
	    //conditions play !!!

	    if(startdate!=null & enddate !=null){
      	  //query.append("and ");
      	  query.append("asa.ts_date BETWEEN '");
      	  query.append(startdate);
      	  query.append("'");
      	  query.append(" AND ");
            query.append("'");
			  query.append(enddate);
      	  query.append("'");

        }
	    
	      if(division !=null){
	    	  query.append("and ");
			  query.append("asa.division_name in (");
			  for(String strdiv :division){
				  query.append("'"+strdiv+"',");
				  System.out.println("strdiv"+strdiv.toString());

			   }
			  	  query.deleteCharAt(query.length() -1);


			  System.out.println("division"+division.toString());
			  query.append(")");
			  paramterMap.put("division",division);
			  
			  
	      }
	      
	      if(constituency !=null){
			  query.append("and ");
			  query.append("asa.name in (");
			  for(String strconsti :constituency){
				  query.append("'"+strconsti+"',");
			   }
			  	  query.deleteCharAt(query.length() -1);
			  query.append(")");
			  paramterMap.put("name", constituency);

	      }
	      if(section !=null){
	    	  query.append("and ");
			  query.append("asa.section_name in (");
			  for(String strsec :section){
				  query.append("'"+strsec+"',");
			   }
			  	  query.deleteCharAt(query.length() -1);
			  query.append(")");
			  paramterMap.put("section_name", section);

			  
	      }
	      if(head_of_account !=null){
	    	  query.append("and ");
			  query.append("asa.head_of_account in (");
			  for(String strhe :head_of_account){
				  query.append("'"+strhe+"',");
			  }
			  	  query.deleteCharAt(query.length() -1);
			  System.out.println("head_of_account"+head_of_account);
			  query.append(")");
			  paramterMap.put("head_of_account", head_of_account);

	      }  
		  if(activity !=null){
			  query.append("and ");
			  query.append("asa.activity in (");
			  for(String stra :activity){
				  query.append("'"+stra+"',");
				  }
				  query.deleteCharAt(query.length() -1);
			  	query.append(")");
			paramterMap.put("activity", activity);

		  }
          if(award_of_work!=null){
        	  query.append("and ");
        	  query.append(" asa.award_of_work in (");
        	  for(String straward :award_of_work){
				  query.append("'"+straward+"',");
				  }
				  query.deleteCharAt(query.length() -1);
			  query.append(")");
			paramterMap.put("award_of_work", award_of_work);

          }
          if(funding_project_scheme!=null){
        	  query.append("and ");
        	  query.append("asa.funding_project_scheme in (");
        	  for(String strfun :funding_project_scheme){
				  query.append("'"+strfun+"',");
				  }
				  query.deleteCharAt(query.length() -1);
			  query.append(")");
			paramterMap.put("funding_project_scheme", funding_project_scheme);

          }  
          if(contract_amount !=0){
        	 
		       query.append("and ");
			   query.append("asa.contract_amount = ('");
			   query.append(contract_amount);
			   query.append("'");
			   query.append(")");
			paramterMap.put("contract_amount", contract_amount);

			   
		    }
        
          
    			System.out.println("em  "+em);
    			Query result = em.createQuery(query.toString());
    			
    			
			   System.out.println("into entitiy querying ");
			   System.out.println("result "+result);


			   
		       System.out.println("query,.,."+query);
		       System.out.println("keyvalues,.,."+paramterMap);
		          
				List<AsDataView> results  =result.getResultList();
				
				System.out.println("results,.,,"+results.size());
				return results;
		
		
		
	}
	/*Individual data details service*/
	
	@ApiOperation(value = "findheadwisedetails", response = AsDataView.class)
	@RequestMapping(value = "/findheadwisedetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findheadwisedetails(@RequestParam(name ="startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,@RequestParam(name ="enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate,@RequestParam String headwise) throws IOException {
		System.out.println("fetching by id");
 		List<AsDataView> fecthed = asdataviewRepo.findheadwisedetails(startdate,enddate,headwise);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findheactivitydetails", response = AsDataView.class)
	@RequestMapping(value = "/findactivitydetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findactivitydetails(@RequestParam String activity,@RequestParam(name ="startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,@RequestParam(name ="enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate) throws IOException {
		System.out.println("fetching by id");
 		List<AsDataView> fecthed = asdataviewRepo.findactivitydetails(activity,startdate,enddate);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findawarddetails", response = AsDataView.class)
	@RequestMapping(value = "/findawarddetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findheactivitydetails(@RequestParam String award_of_work,@RequestParam(name ="startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,@RequestParam(name ="enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate) throws IOException {
		System.out.println("fetching by id");
 		List<AsDataView> fecthed = asdataviewRepo.findawarddetails(award_of_work,startdate,enddate);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findschemedetails", response = AsDataView.class)
	@RequestMapping(value = "/findschemedetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findschemedetails(@RequestParam String scheme,@RequestParam(name ="startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,@RequestParam(name ="enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate) throws IOException {
		System.out.println("fetching by id");
 		List<AsDataView> fecthed = asdataviewRepo.findschemedetails(scheme,startdate,enddate);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findconstituencydetails", response = AsDataView.class)
	@RequestMapping(value = "/findconstituencydetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findconstituencydetails(@RequestParam String Cname,@RequestParam(name ="startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,@RequestParam(name ="enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate) throws IOException {
		System.out.println("fetching by id");
 		List<AsDataView> fecthed = asdataviewRepo.findconstituencydetails(Cname,startdate,enddate);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "finddivisiondetails", response = AsDataView.class)
	@RequestMapping(value = "/finddivisiondetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finddivisiondetails(@RequestParam String divisionname,@RequestParam(name ="startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,@RequestParam(name ="enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate) throws IOException {
		System.out.println("fetching by id");
 		List<AsDataView> fecthed = asdataviewRepo.finddivisiondetails(divisionname,startdate,enddate);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findsectiondetails", response = AsDataView.class)
	@RequestMapping(value = "/findsectiondetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findsectiondetails(@RequestParam String sectionname,@RequestParam(name ="startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startdate,@RequestParam(name ="enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date enddate) throws IOException {
		System.out.println("fetching by id");
 		List<AsDataView> fecthed = asdataviewRepo.findsectiondetails(sectionname,startdate,enddate);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "find-headwise-names", response = AsDataView.class)
	@RequestMapping(value = "/find-headwise-names", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findheadwisenames() throws IOException {
		System.out.println("fetching by id");
 		Set<AsDataView> fecthed = asdataviewRepo.findheadwisenames();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "find-scheme-names", response = AsDataView.class)
	@RequestMapping(value = "/find-scheme-names", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findschemeenames() throws IOException {
		System.out.println("fetching by id");
		Set<AsDataView> fecthed = asdataviewRepo.findschemeenames();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);

		
	}

		
	@ApiOperation(value = "CSV-Reader", response = AsDataView.class)
	@RequestMapping(value = "/CSV-Reader", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public ResponseEntity<Map<String, Object>> CSVReader() throws IOException {
		System.out.println("CSV-Reader service is called <>!");

		String csvFile = "C:\\Users\\Chaitanya\\Downloads\\Emp.csv";
		String line = "";
		String cvsSplitBy = ",";
       // SwProblem prob = new SwProblem();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] csv = line.split(cvsSplitBy);
				System.out.println("csv<.,.."+csv);
				
				String TableSwproblem = "SwProblem";
				String TableobjectAsData = "AsData";
				String TableSwEstimate= "SwEstimate";


				System.out.println("insert into Tableobject "+"name="+ csv[0] +" , name="+ csv[1] + " , name=" + csv[2]);

				
				StringBuilder query = new  StringBuilder();
				   
				
				query.append("insert into sw_problem" );
				/*query.append("(id,actual_end,actual_start,schedule_end,schedule_start,");
				query.append("drain_type,location,pipe_length,pipe_size,pk_number,");
				query.append("problem_status,problem_type,remarks,responsibiblity,");
				query.append("solution_category,docket_id,section_id,constituency_id,activitiy)");*/
				
				query.append("(sw_problem_Id,actual_end,actual_start,schedule_end,schedule_start,");
	            query.append("drain_type,problem_status,problem_type,remarks,responsibility,");
				query.append("solution_category,docket_id,location,pipe_size,pipe_length,");
				query.append("pk_number,section_id,constituency_id,activity) ");

     			query.append("values( ");
                //if(csv[0] ==null)
				query.append(csv[0]);
				query.append(",");
				
				query.append("'");
				query.append(csv[1]);
				query.append("'");
				query.append(",");
				
				query.append("'");
				query.append(csv[2]);
				query.append("'");
				query.append(",");
				
				query.append("'");
				query.append(csv[3]);
				query.append("'");
				query.append(",");
				
				query.append("'");
				query.append(csv[4]);
				query.append("'");
				query.append(",");
				
				query.append(csv[5]);
				query.append(",");
				
				query.append(csv[6]);
				query.append(",");
				
				query.append("'");
				query.append(csv[7]);
				query.append("'");
				query.append(",");
				
				//query.append("'");
				query.append(csv[8]);
				//query.append("'");
				query.append(",");
				
				query.append(csv[9]);
				query.append(",");
				
				query.append("'");
				query.append(csv[10]);
				query.append("'");
				query.append(",");
				
				query.append(csv[11]);
				query.append(",");
				
				query.append("'");
				query.append(csv[12]);
				query.append("'");
				query.append(",");
				
				query.append(csv[13]);
				query.append(",");
				query.append(csv[14]);
				query.append(",");
				query.append(csv[15]);
				query.append(",");
				query.append(csv[16]);
				query.append(",");
				query.append(csv[17]);
				query.append(",");
				
				query.append("'");
				query.append(csv[18]);
				query.append("'");

				query.append(")");

				
		
				/*String insert="insert into SwProblem (id,actual_end,actual_start,schedule_end,schedule_start,"
						+ "drain_type,location,pipe_length,pipe_size,pk_number,problem_status,"
						+"problem_type,remarks,responsibiblity,"
						+"solution_category,docket_id,section_id,constituency_id,activitiy)"
						+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";*/
				//System.out.println("query.."+query);
				
				Query insertCsv =em.createNativeQuery(query.toString(), SwProblem.class)
						/*.setParameter(1, prob.getId())
						.setParameter(2, prob.getActual_end())
						.setParameter(3, prob.getActual_start())
						.setParameter(4, prob.getSchedule_end())
						.setParameter(5, prob.getSchedule_start())
						.setParameter(6, prob.getDrain_type())
						.setParameter(7, prob.getLocation())
						.setParameter(8, prob.getPipe_length())
						.setParameter(9, prob.getPipe_size())
						.setParameter(10, prob.getPk_number())
						.setParameter(11, prob.getProblem_status())
						.setParameter(12, prob.getProblem_type())
						.setParameter(13, prob.getRemarks())
						.setParameter(14, prob.getResponsibility())
						.setParameter(15, prob.getSolution_category())
						.setParameter(16, prob.getDocket())
						.setParameter(17, prob.getSection())
						.setParameter(18, prob.getConstituency())
						.setParameter(19, prob.getActivity())
						.executeUpdate()*/
						;
				
                
				System.out.println("insertCsv,.,."+insertCsv.executeUpdate());
				//System.out.println("query.."+query);
				System.out.println("insertCsv.."+insertCsv);

				
				
			}
//              insert into EMPLOYEET(empname,empAge,salary,empaddress) values (:name,:age,:salary,:address)

		} catch (IOException e) {
			e.printStackTrace();
		}
		//Set<AsDataView> fecthed = asdataviewRepo.CSV-Reader();
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);

		
	}




}


