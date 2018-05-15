//package com.mm.swims.Controller;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mm.swims.Entity.SwManhole;
//import com.mm.swims.Entity.SwSewerBranch;
//import com.mm.swims.Repository.SewerBranchRepository;
//import com.mm.swims.Repository.SewerManholeRepository;
//
//import io.swagger.annotations.Api;
//
//
//@Controller
//@RequestMapping(value="/swims/swbranch")
//@Api(value="Sewer-BranchController",tags = "SWIMS API")
//
//public class SewerBranchController {
//	
//	@Autowired
//	private SewerBranchRepository sewerbranchrepo;
//	
//	
//	@RequestMapping(value="/branch",method=RequestMethod.GET)
//	@ResponseBody
//	public String sample(){
//		
//		return "Sample in  Branch  is Ok!!!!!";
//		
//	}
//	@RequestMapping(value="/insertbranch",method=RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<Map<String,Object>> saveImage(@RequestBody String data ) throws IOException, ParseException{
//		System.out.println("sewer insertbranch service is Calling !.");
//		SwSewerBranch sewerbranch =  new SwSewerBranch();
//
//		try {
//			sewerbranch = new ObjectMapper().readValue(data, SwSewerBranch.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
// 		Map<String,Object> map = new HashMap<String,Object>();
//		System.out.println("entered");
//		Date ts=new Date(System.currentTimeMillis());
//		sewerbranch.setDate_of_commission(ts);
//		SwSewerBranch fecthed = sewerbranchrepo.save(sewerbranch);
// 		System.out.println("Checking sewer  method");
//		
//		map.put("Data", fecthed);
//		map.put("message", "Successfull..!");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}
//    @RequestMapping(value = "/view-branches", method = RequestMethod.GET)
//	public ResponseEntity<Map<String, Object>> viewAll() {
//
//		List<SwSewerBranch> feteched = sewerbranchrepo.findAll();
//		System.out.println(feteched);
//		Map<String, Object> res = new HashMap<String, Object>();
//		res.put("Successfully fetched deteails.!", feteched);
//		res.put("statusCode", HttpStatus.OK.value());
//
//		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
//
//	}
//    @RequestMapping(value = "/deletebyid", method = RequestMethod.DELETE)
//	public ResponseEntity<Map<String, Object>> delete(@RequestParam long id) {
//		 System.out.println("deleetbyid is caalling");
//		 SwSewerBranch fecthed = sewerbranchrepo.findOne(id);
//		 sewerbranchrepo.delete(id);
//		//System.out.println("fecthed"+fecthed.getManhole_id() +fecthed.getLocation());
//		Map<String, Object> res = new HashMap<String, Object>();
//		res.put("data", fecthed.getId());
//		Object message = "Succesfully deleted!.";
//		res.put("message", message);
//		res.put("successful", true);
//		res.put("statusCode", HttpStatus.OK.value());
//
//		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);
//	}
//	 
//    @RequestMapping(value="/deleteAll",method=RequestMethod.DELETE)
//	@ResponseBody
//	public ResponseEntity<Map<String,Object>> deleteAll() throws IOException{
//	    System.out.println("fetching All in delete alld");
//	    sewerbranchrepo.deleteAll();
//		Map<String,Object> map = new HashMap<String,Object>();
//        map.put("message", "Successfull ..!");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}
//    
//    @RequestMapping(value = "/update-details", method = RequestMethod.POST)
//    public ResponseEntity<Map<String, Object>> updateimage(@RequestParam long id,@RequestBody String data) throws IOException {
//    	SwSewerBranch shole = null;
//		try {
//			shole = new ObjectMapper().readValue(data, SwSewerBranch.class);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Date ts=new Date(System.currentTimeMillis());
//		SwSewerBranch fetched= sewerbranchrepo.findOne(id);
//		shole.setId(id);
//		shole.setDate_of_commission(ts);
//
//		
//		//System.out.println("before updating"+ fetched.getSewer_name()+"" +fetched.getSewer_id());
//		  
//		SwSewerBranch updated= sewerbranchrepo.save(shole);
//		//System.out.println("after updating"+ updated.getSewer_name()+"" +updated.getSewer_id());
//
//		Map<String, Object> res = new HashMap<String, Object>();
//		Object message = "Updated Succesfully.!.";
//		res.put("Data", updated);
//		res.put("message", message);
//		res.put("successful", true);
//		res.put("statusCode", HttpStatus.OK.value());
//
//		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);
//
//	}
//}
//	