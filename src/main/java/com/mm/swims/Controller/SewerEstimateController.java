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
//import com.mm.swims.Entity.SwEstimate;
//import com.mm.swims.Entity.SwSewerBranch;
//import com.mm.swims.Repository.SewerEstimateRepository;
//
//import io.swagger.annotations.Api;
//
//@Controller
//@RequestMapping(value = "/swims/estimate")
//@Api(value="Sewer-EstimateController",tags = "SWIMS API")
//
//public class SewerEstimateController {
//
//	@Autowired
//	private SewerEstimateRepository sewerestimaterepo;
//
//	@RequestMapping(value = "/estimate", method = RequestMethod.GET)
//	@ResponseBody
//	public String sample() {
//
//		return "Sample in  estimate Ok!!!!!";
//
//	}
//
//	@RequestMapping(value = "/insertestimate", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<Map<String, Object>> saveImage(@RequestBody String data) throws IOException, ParseException {
//		System.out.println("sewer insertestimate service is Calling !.");
//		SwEstimate sewermain = new SwEstimate();
//
//		try {
//			sewermain = new ObjectMapper().readValue(data, SwEstimate.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println("entered");
//		Date ts=new Date(System.currentTimeMillis());
//		sewermain.setCreation_date(ts);
//		SwEstimate fecthed = sewerestimaterepo.save(sewermain);
//		System.out.println("Checking sewer  method" +fecthed.getAgency());
//
//		map.put("Data", fecthed);
//		map.put("message", "Successfull. !.");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}
//
//	@RequestMapping(value = "/view-estimates", method = RequestMethod.GET)
//	public ResponseEntity<Map<String, Object>> viewAll() {
//
//		List<SwEstimate> feteched = sewerestimaterepo.findAll();
//		System.out.println(feteched);
//		Map<String, Object> res = new HashMap<String, Object>();
//		res.put("Successfully fetched deteails.!", feteched);
//		res.put("statusCode", HttpStatus.OK.value());
//
//		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.OK);
//
//	}
//
//	@RequestMapping(value = "/deletebyid", method = RequestMethod.DELETE)
//	public ResponseEntity<Map<String, Object>> delete(@RequestParam long id) {
//		System.out.println("deleetbyid is caalling");
//		SwEstimate fecthed = sewerestimaterepo.findOne(id);
//		sewerestimaterepo.delete(id);
//		// System.out.println("fecthed"+fecthed.getManhole_id()
//		// +fecthed.getLocation());
//		Map<String, Object> res = new HashMap<String, Object>();
//		res.put("data", fecthed);
//		Object message = "Succesfully deleted!.";
//		res.put("message", message);
//		res.put("successful", true);
//		res.put("statusCode", HttpStatus.OK.value());
//
//		return new ResponseEntity<Map<String, Object>>(res, HttpStatus.CREATED);
//	}
//
//	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
//	@ResponseBody
//	public ResponseEntity<Map<String, Object>> deleteAll() throws IOException {
//		System.out.println("fetching All in delete alld");
//		sewerestimaterepo.deleteAll();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("message", "Successfull!..");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}
//
//	@RequestMapping(value = "/update-details", method = RequestMethod.POST)
//    public ResponseEntity<Map<String, Object>> updateimage(@RequestParam long id,@RequestBody String data) throws IOException {
//		SwEstimate shole = null;
//		try {
//			shole = new ObjectMapper().readValue(data, SwEstimate.class);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		SwEstimate fetched= sewerestimaterepo.findOne(id);
//		Date ts=new Date(System.currentTimeMillis());
//		shole.setEstimate_id(id);
//		shole.setCreation_date(ts);
//
//		
//		System.out.println("before updating"+ fetched.getAgency()+"" +fetched.getEstimate_id());
//		  
//		SwEstimate updated= sewerestimaterepo.save(shole);
//		System.out.println("after updating"+ updated.getAgency()+"" +updated.getEstimate_id());
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