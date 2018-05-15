package com.mm.swims.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.swims.Entity.HotSpotView;
import com.mm.swims.Entity.Section;
import com.mm.swims.Entity.SubDivision;
import com.mm.swims.Entity.SwEstimate;
import com.mm.swims.Entity.SwProblem;
import com.mm.swims.Repository.HotSpotViewRepository;
import com.mm.swims.Repository.SewerEstimateRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/swims/hotspot")
@Api(value = "Swims-ASDataController", tags = "SWIMS API")
public class HotspotController {
	
	@Autowired
	public SewerEstimateRepository estimaterepo;
	
	@Autowired
	public HotSpotViewRepository  hotspotviewrepo;
	
	
	
	@ApiOperation(value = "estimate creation", response = SwEstimate.class)
	@RequestMapping(value = "/create-estimate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Createsection(@RequestParam SwProblem id, @RequestBody String data)
			throws IOException, ParseException {
		System.out.println("create estimate service is Calling !.");
		SwEstimate estimate = new SwEstimate();

		try {
			estimate = new ObjectMapper().readValue(data, SwEstimate.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entered");
		 Date ts=new Date(System.currentTimeMillis());
		 estimate.setApproved_date(ts);
		 estimate.setCompleted_date(ts);
		 estimate.setSchedule_completed_by(ts);		 
		 estimate.setProblem(id);
		// estimate.setProblem_type(type);

		SwEstimate fecthed = estimaterepo.save(estimate);
		System.out.println("Checking sewer  method");

		map.put("Data", fecthed);
		map.put("message", "Estimate Created Successfully. !.");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	
	@ApiOperation(value = "fetching-estimate-info", response = SwEstimate.class)
	@RequestMapping(value = "/find-estimates-by-status", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findestimatebystatus() throws IOException {
		System.out.println("find-estimates");
		List<SwEstimate> fecthed = estimaterepo.findestimatebystatus();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "fetching-estimate-info", response = SwEstimate.class)
	@RequestMapping(value = "/find-estimates", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallsubdivisons() throws IOException {
		System.out.println("find-estimates");
		List<SwEstimate> fecthed = estimaterepo.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	@ApiOperation(value = "fetching-estimate-info", response = SwEstimate.class)
	@RequestMapping(value = "/find-estimates-by-category-done", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findestimatesbystatusbydone(@RequestParam String category,@RequestParam String sectioname) throws IOException {
		System.out.println("find-estimates-status<><> is calling ");
		System.out.println();

		List<SwEstimate> fecthed = estimaterepo.findestimatesbystatudone(category,sectioname);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	@ApiOperation(value = "fetching-estimate-info", response = SwEstimate.class)
	@RequestMapping(value = "/find-estimates-by-category-to-be-done", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findestimatesbystatusbytobedone(@RequestParam String category,@RequestParam String sectioname) throws IOException {
		System.out.println("find-estimates-status<><> is calling ");
		System.out.println();

		List<SwEstimate> fecthed = estimaterepo.findestimatesbystatustobedone(category,sectioname);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	@ApiOperation(value = "fetching-estimate-view", response = HotSpotView.class)
	@RequestMapping(value = "/find-all-estimates", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findestimatesview() throws IOException {
		
		System.out.println("find-all-estimates  Service is Calling !!!!");
		System.out.println("hotspotviewrepo"+hotspotviewrepo);
		List<HotSpotView> fecthed = hotspotviewrepo.findestimatesview();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "find-all-estimates-by-id", response = HotSpotView.class)
	@RequestMapping(value = "/find-all-estimates-by-id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findestimatesviewbyid(@RequestParam Long[] id) throws IOException {
		
		System.out.println("find-all-estimates  Service is Calling !!!!");
		System.out.println("hotspotviewrepo"+hotspotviewrepo);
		List<HotSpotView> fecthed = hotspotviewrepo.findestimatesviewbyid(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	

}
