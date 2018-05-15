//package com.mm.swims.Controller;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
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
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mm.swims.Entity.SwManhole;
//import com.mm.swims.Repository.SewerManholeRepository;
//
//import io.swagger.annotations.Api;
//
//@Controller
//@RequestMapping(value="/swims/swmanhole")
//@Api(value="Sewer-ManholeController", tags = "SWIMS API")
//
//public class SewerManholeController {
//	
//	@Autowired
//	private SewerManholeRepository sewerrepo;
//	
//	
//	@RequestMapping(value="/test",method=RequestMethod.GET)
//	@ResponseBody
//	public String sample(){
//		
//		return "Sample in manhole is Up boy!!!!!";
//		
//	}
//	@RequestMapping(value="/insertmanhole",method=RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<Map<String,Object>> saveImage(@RequestBody String data ) throws IOException, ParseException{
//		System.out.println("sewer insertmanhole service is Calling !.");
//		SwManhole swmanhole =  new SwManhole();
//
//		try {
//			swmanhole = new ObjectMapper().readValue(data, SwManhole.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
// 		Map<String,Object> map = new HashMap<String,Object>();
//		System.out.println("entered");
//		//Date ts=new Date(System.currentTimeMillis());
//		SwManhole fecthed = sewerrepo.save(swmanhole);
// 		System.out.println("Checking sewer  method");
//		
//		map.put("Data", fecthed);
//		map.put("message", "Manhole inserted Successfully. !.");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}
//    @RequestMapping(value = "/view-manholes", method = RequestMethod.GET)
//	public ResponseEntity<Map<String, Object>> viewAll() {
//
//		List<SwManhole> feteched = sewerrepo.findAll();
//		System.out.println(feteched);
//		Map<String, Object> res = new HashMap<String, Object>();
//		res.put("Successfully fetched details.!", feteched);
//		res.put("statusCode", HttpStatus.OK.value());
//
//		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
//
//	}
//    @RequestMapping(value = "/deletebyid", method = RequestMethod.DELETE)
//	public ResponseEntity<Map<String, Object>> delete(@RequestParam long id) {
//		 System.out.println("deleetbyid is caalling");
//		 SwManhole fecthed = sewerrepo.findOne(id);
//		 sewerrepo.delete(id);
//		//System.out.println("fecthed"+fecthed.getManhole_id() +fecthed.getLocation());
//		Map<String, Object> res = new HashMap<String, Object>();
//		res.put("data", fecthed.getBranch_sewer_name());
//		Object message = "Succesfully deleted!.";
//		res.put("message", message);
//		res.put("successful", true);
//		res.put("statusCode", HttpStatus.OK.value());
//
//		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);
//	}
//    @RequestMapping(value="/viewby-id",method=RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<Map<String,Object>> viewbyid(@RequestParam long id) throws IOException{
//	     System.out.println("fetching by id");
//		 SwManhole fecthed = sewerrepo.findOne(id);
//		Map<String,Object> map = new HashMap<String,Object>();
//        map.put("Data", fecthed);
//        map.put("message", "Successfully Retrieved data");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}
//	 
//    @RequestMapping(value="/deleteAll",method=RequestMethod.DELETE)
//	@ResponseBody
//	public ResponseEntity<Map<String,Object>> deleteAll() throws IOException{
//	    System.out.println("fetching All in delete alld");
//	    sewerrepo.deleteAll();
//		Map<String,Object> map = new HashMap<String,Object>();
//        map.put("message", "Successfully Deleted All manhole Data !..");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}
//    
//   /* @RequestMapping(value = "/update-details", method = RequestMethod.POST)
//    public ResponseEntity<Map<String, Object>> updateimage(@RequestBody String data) throws IOException {
//		System.out.println("update is calling");
// 		 //long time = Utilhelper.getTimeInMillis();
//		 //Date date=new Date(System.currentTimeMillis());
//		SwManhole shole = null;
//			try {
//				shole = new ObjectMapper().readValue(data, SwManhole.class);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		 SwManhole fecthed = sewerrepo.findOne(shole.getManhole_id());
//		 System.out.println("fetched"+fecthed);
//		 //fecthed.setId(id);
//		 //fecthed.setImage(bytes);
//		 //fecthed.setCreatedDate(date);
//		 System.out.println("before updation"+"manhol id <><><><"+fecthed.getManhole_id()+"Location"+ fecthed.getLocation());
//		 SwManhole updated= sewerrepo.save(fecthed);
//		 System.out.println("after updation"+"manhol id <><><><"+fecthed.getManhole_id()+"Location"+ fecthed.getLocation());
//
//		//Image fecthed = imageservice.updateImage(image);
//		System.out.println(fecthed);
//		Map<String, Object> res = new HashMap<String, Object>();
//		Object message = "Manhole Data Updated Succesfully.!.";
//		res.put("Data", updated);
//		res.put("message", message);
//		res.put("successful", true);
//		res.put("statusCode", HttpStatus.OK.value());
//
//		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);
//
//	}*/
//    @RequestMapping(value = "/update-details", method = RequestMethod.POST)
//    public ResponseEntity<Map<String, Object>> updateimage(@RequestParam long id,@RequestBody String data) throws IOException {
//    	SwManhole shole = null;
//		try {
//			shole = new ObjectMapper().readValue(data, SwManhole.class);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		SwManhole fetched= sewerrepo.findOne(id);
//		shole.setId(id);
//		
//		//System.out.println("before updating"+ fetched.getLocation()+"" +fetched.getManhole_id());
//		  
//		SwManhole updated= sewerrepo.save(shole);
//		//System.out.println("after updating"+ updated.getLocation()+"" +updated.getManhole_id());
//
//		Map<String, Object> res = new HashMap<String, Object>();
//		Object message = "Manhole Data Updated Succesfully.!.";
//		res.put("Data", updated);
//		res.put("message", message);
//		res.put("successful", true);
//		res.put("statusCode", HttpStatus.OK.value());
//
//		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);
//
//	}
//	
//	
//}
