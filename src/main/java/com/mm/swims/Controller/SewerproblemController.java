package com.mm.swims.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.swims.Entity.Docket;
import com.mm.swims.Entity.Section;
import com.mm.swims.Entity.SwProblem;
import com.mm.swims.Entity.SwProblem.ProblemType;
import com.mm.swims.Repository.SewerProblemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value="/swims/problem")
@Api(value="Sewer-ProblemController",tags = "SWIMS API")

public class SewerproblemController {
	
	@Autowired
	private SewerProblemRepository sewerprblmrepo;
	
	
    @ApiOperation(value = "sample in problem controller", response = SwProblem.class)

	@RequestMapping(value="/problem",method=RequestMethod.GET)
	@ResponseBody
	public String sample(){
		
		return "Sample in  problem  is Up boy!!!!!";
		
	}

    @ApiOperation(value = "Insert a problem for a Docket", response = SwProblem.class)
	@RequestMapping(value="/insertproblem",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String,Object>> saveImage(@RequestParam Section sec_id,@RequestParam Docket id,@RequestBody String data ) throws IOException, ParseException{
		System.out.println("sewer insertproblem service is Calling !.");
		SwProblem sewermain =  new SwProblem();

		try {
			sewermain = new ObjectMapper().readValue(data, SwProblem.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("entered");
		/*Date ts=new Date(System.currentTimeMillis());
		sewermain.setSchedule_start(ts);
		sewermain.setSchedule_end(ts);
		sewermain.setActual_start(ts);
		sewermain.setActual_end(ts);*/
		
		sewermain.setDocket(id);
		sewermain.setSection(sec_id);
		SwProblem fecthed = sewerprblmrepo.save(sewermain);
 		System.out.println("Checking sewer  method");
 		
		
		map.put("Data", fecthed);
		map.put("message", "Successfull !..");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
    @RequestMapping(value = "/view-problems", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> viewAll() {

		List<SwProblem> feteched = sewerprblmrepo.findAll();
		
 		System.out.println(feteched);
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("Successfully fetched deteails.!", feteched);
		res.put("statusCode", HttpStatus.OK.value());

		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);

	}
    
    @RequestMapping(value = "/find-one", method = RequestMethod.GET)
  	public ResponseEntity<Map<String, Object>> findone(@RequestParam long id) {

  		SwProblem feteched = sewerprblmrepo.findOne(id);
  		
   		System.out.println(feteched);
  		Map<String, Object> res = new HashMap<String, Object>();
  		res.put("Successfully fetched deteails.!", feteched);
  		res.put("statusCode", HttpStatus.OK.value());

  		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);

  	}
     
   
    @RequestMapping(value = "/find-pbolems-res", method = RequestMethod.GET)
   	public ResponseEntity<Map<String, Object>> findprobswithres(@RequestParam long id) throws JSONException {

    	List<SwProblem> feteched = sewerprblmrepo.findbyidd(id);
    	
    	ResponseEntity<Map<String, Object>>    fecthd= viewAllproblemtypes(id);
   		
    	 System.out.println("fecthd<><><><><>"+fecthd);
    	 
    	 
   /* 	 ObjectMapper objectMapper = new ObjectMapper();
    	 SwProblem pb =objectMapper.readValues(feteched, SwProblem.class);*/

    	 org.json.JSONObject obje= new org.json.JSONObject();
    	 obje.put("D", fecthd) ;
    	 obje.putOpt("", feteched);
    	 System.out.println("obje<><>.."+obje);
    	  
    	System.out.println(feteched);
   		Map<String, Object> res = new HashMap<String, Object>();
   		res.put("Successfully fetched deteails.!", obje);
   		res.put("statusCode", HttpStatus.OK.value());

   		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);

   	}
   @RequestMapping(value = "/find-all-problemtype", method = RequestMethod.GET)
   	public ResponseEntity<Map<String, Object>> viewAllproblemtypes(@RequestParam long id) {
	   
	    
	    List<ProblemType> enums = Arrays.asList(ProblemType.values());
	    System.out.println(enums.size());

    	List<ProblemType> feteched = sewerprblmrepo.findproblemtypes(id);
     	
            
    	 
     	/*HashSet<ProblemType> unique = new HashSet<ProblemType>(feteched);
    	for (ProblemType key : unique) {
    	    System.out.println(key + ": " + Collections.frequency(feteched, key));
    	    
    	    unique.add(key);
    	}*/
    	
    	Map<ProblemType, Integer> map = new HashMap<ProblemType, Integer>();

    	for (ProblemType temp : feteched) {
    		Integer count = map.get(temp);
    		map.put(temp, (count == null) ? 1 : count + 1);
    	}
    	printMap(map);
    	 
    	/*JSONObject obj =new JSONObject();
    	 obj.merge(map);
    	 obj.merge(fetechedone);*/
    	
       //System.out.println(map);
       System.out.println(map);

   		Map<String, Object> res = new HashMap<String, Object>();
   		//res.put("Successfully fetched deteails.!", feteched);
   		res.put("fetched ProblemTypes!", map);
    	res.put("statusCode", HttpStatus.OK.value());

   		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);

   	}
    
   public static void printMap(Map<ProblemType, Integer> map){

		for (Entry<ProblemType, Integer> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
				+ entry.getValue());
		}
   }
   public static void printMapproblem(Map<SwProblem, Integer> map){

		for (Entry<SwProblem, Integer> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
				+ entry.getValue());
		}
  }
    

	@RequestMapping(value = "/deletebyid", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> delete(@RequestParam long id) {
		 System.out.println("deleetbyid is caalling");
		 SwProblem fecthed = sewerprblmrepo.findOne(id);
		 sewerprblmrepo.delete(id);
		//System.out.println("fecthed"+fecthed.getManhole_id() +fecthed.getLocation());
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("data", null);
		Object message = "Succesfully deleted!.";
		res.put("message", message);
		res.put("successful", true);
		res.put("statusCode", HttpStatus.OK.value());

		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);
	}
	 
    @RequestMapping(value="/deleteAll",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Map<String,Object>> deleteAll() throws IOException{
	    System.out.println("fetching All in delete alld");
	    sewerprblmrepo.deleteAll();
		Map<String,Object> map = new HashMap<String,Object>();
        map.put("message", "Successfull!..");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
  
    @RequestMapping(value = "/update-details", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> updateimage(@RequestParam long id,@RequestBody String data) throws IOException {
    	SwProblem shole = null;
		try {
			shole = new ObjectMapper().readValue(data, SwProblem.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SwProblem fetched= sewerprblmrepo.findOne(id);
		shole.setId(id);
		
		//System.out.println("before updating"+ fetched.getProblem_type()+"" +fetched.getSwproblem_id());
		  
		SwProblem updated= sewerprblmrepo.save(shole);
		//System.out.println("after updating"+ updated.getProblem_type()+"" +updated.getSwproblem_id());

		Map<String, Object> res = new HashMap<String, Object>();
		Object message = "Updated Succesfully.!.";
		res.put("Data", updated);
		res.put("message", message);
		res.put("successful", true);
		res.put("statusCode", HttpStatus.OK.value());

		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);

	}
}