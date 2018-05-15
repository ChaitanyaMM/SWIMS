package com.mm.swims.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.swims.Entity.AsDataView;
import com.mm.swims.Entity.Circle;
import com.mm.swims.Entity.Division;
import com.mm.swims.Entity.Docket;
import com.mm.swims.Entity.Section;
import com.mm.swims.Entity.SirView;
import com.mm.swims.Entity.SubDivision;
import com.mm.swims.Entity.SwProblem;
import com.mm.swims.Entity.SwProblem.ProblemType;
import com.mm.swims.Repository.ASDataViewRepository;
import com.mm.swims.Repository.DivisonRepository;
import com.mm.swims.Repository.DocketRepository;
import com.mm.swims.Repository.SectionRepository;
import com.mm.swims.Repository.SewerProblemRepository;
//import com.mm.swims.Repository.DocketRepository;
//import com.mm.swims.Repository.SectionRepository;
import com.mm.swims.Repository.SewerServiceAreaRepository;
import com.mm.swims.Repository.SirViewRepository;
//import com.mm.swims.Repository.SubDivisionRepository;
import com.mm.swims.Repository.SubDivisionRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 
@Controller
@RequestMapping(value = "/swims/servicearea")
@Api(value = "Sewer-ServiceAreaController", tags = "SWIMS API")

public class SewerServiceAreaController {

	@Autowired
	private SewerServiceAreaRepository sewerrepo;

	@Autowired
	private DivisonRepository divisonrepo;
	@Autowired
	private SubDivisionRepository subdivisonrepo;
	@Autowired
	private SectionRepository setiononrepo;
	@Autowired
	private DocketRepository docketrepo;
	
	@Autowired
	private ASDataViewRepository asdataviewRepo;
	
	@Autowired
	private SewerProblemRepository prblmrepo;
	
	@Autowired
	private SirViewRepository sirviewrepo;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String sample() {

		return "Sample in servicearea is Up boy!!!!!";

	}

	@ApiOperation(value = "circle creation", response = Circle.class)
	@RequestMapping(value = "/create-circle", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Createcircle(@RequestBody String data)
			throws IOException, ParseException {
		System.out.println("sewer create-circle service is Calling !.");
		Circle swmanhole = new Circle();

		try {
			swmanhole = new ObjectMapper().readValue(data, Circle.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entered");
		// Date ts=new Date(System.currentTimeMillis());
		Circle fecthed = sewerrepo.save(swmanhole);

		System.out.println("Checking sewer  method");

		map.put("Data", fecthed);
		map.put("message", "Circle Created Successfully. !.");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "division creation", response = Division.class)
	@RequestMapping(value = "/create-division", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Createdivision(@RequestParam Circle id, @RequestBody String data)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("sewer create-division service is Calling !.");
		Division division = new Division();

		try {
			division = new ObjectMapper().readValue(data, Division.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entered");
		// Date ts=new Date(System.currentTimeMillis());

		division.setCircle(id);
		Division fecthed = divisonrepo.save(division);

		System.out.println("Checking sewer  method");

		map.put("Data", fecthed);
		map.put("message", "Division Created Successfully. !.");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "subdivision creation", response = SubDivision.class)
	@RequestMapping(value = "/create-subdivision", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Createsubdivision(@RequestParam Division id, @RequestBody String data)
			throws IOException, ParseException {
		System.out.println("sewer Createsubdivision service is Calling !.");
		SubDivision subdiv = new SubDivision();

		try {
			subdiv = new ObjectMapper().readValue(data, SubDivision.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entered");
		// Date ts=new Date(System.currentTimeMillis());
		subdiv.setDivision(id);
		SubDivision fecthed = subdivisonrepo.save(subdiv);

		System.out.println("Checking sewer  method");

		map.put("Data", fecthed);
		map.put("message", "Subdivision Created Successfully. !.");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "section creation", response = Section.class)
	@RequestMapping(value = "/create-section", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Createsection(@RequestParam SubDivision id, @RequestBody String data)
			throws IOException, ParseException {
		System.out.println("sewer create-circle service is Calling !.");
		Section swmanhole = new Section();

		try {
			swmanhole = new ObjectMapper().readValue(data, Section.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entered");
		// Date ts=new Date(System.currentTimeMillis());
		swmanhole.setSubdivision(id);

		Section fecthed = setiononrepo.save(swmanhole);
		System.out.println("Checking sewer  method");

		map.put("Data", fecthed);
		map.put("message", "Section Created Successfully. !.");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "docket creation", response = SwProblem.class)
	@RequestMapping(value = "/create-docket", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Createdocket(@RequestParam Circle cid,@RequestParam Division did,@RequestParam SubDivision sdid,@RequestParam Section sid, @RequestBody String data)
			throws IOException, ParseException {
		System.out.println("sewer create-circle service is Calling !.");
		Docket swmanhole = new Docket();

		try {
			swmanhole = new ObjectMapper().readValue(data, Docket.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entered");
		// Date ts=new Date(System.currentTimeMillis());
		swmanhole.setCirledocket(cid);
		swmanhole.setDivisiondocket(did);
		swmanhole.setSubdividocket(sdid);
		swmanhole.setSection(sid);

		Docket fecthed = docketrepo.save(swmanhole);
		System.out.println("Checking sewer  method");

		map.put("Data", fecthed);
		map.put("message", "Section Created Successfully. !.");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

//	@ApiOperation(value = "docket creation", response = SwProblem.class)
//	@RequestMapping(value = "/create-docket_view", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<Map<String, Object>> Createdocketfinalviewdo(@RequestBody String data)
//			throws IOException, ParseException {
//		System.out.println("sewer create-circle service is Calling !.");
//		DocketView swmanhole = new DocketView();
//
//		try {
//			swmanhole = new ObjectMapper().readValue(data, DocketView.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println("entered");
//		// Date ts=new Date(System.currentTimeMillis());
//		// swmanhole.setSection(id);
//
//		DocketView fecthed = docketviewrepo.save(swmanhole);
//		System.out.println("Checking sewer  method");
//
//		map.put("Data", fecthed);
//		map.put("message", "Section Created Successfully. !.");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}

//	@ApiOperation(value = "fetching-circle-info", response = Circle.class)
//	@RequestMapping(value = "/find-all-docket-view", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<Map<String, Object>> findalldocketviews() throws IOException {
//		System.out.println("fetching by id");
//		List<DocketView> fecthed = docketviewrepo.findAll();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("Data", fecthed);
//		map.put("message", "Successfully Retrieved data");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}

//	@ApiOperation(value = "fetching-circle-info", response = Circle.class)
//	@RequestMapping(value = "/find-docketview-by-id", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<Map<String, Object>> findalldocketbyid(@RequestParam long id) throws IOException {
//		System.out.println("fetching by id");
//		DocketView fecthed = docketviewrepo.findOne(id);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("Data", fecthed);
//		map.put("message", "Successfully Retrieved data");
//		map.put("status", true);
//		return ResponseEntity.ok().body(map);
//	}

	@ApiOperation(value = "fetching-circle-info", response = Circle.class)
	@RequestMapping(value = "/find-all-circles", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallcircles() throws IOException {
		System.out.println("fetching by id");
		List<Circle> fecthed = sewerrepo.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "fetching-circle-info", response = Circle.class)
	@RequestMapping(value = "/find-circle-by-id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findcirclebyid(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
		Circle fecthed = sewerrepo.findOne(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "fetching-divison-info", response = Division.class)
	@RequestMapping(value = "/find-all-divisions", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findalldivs() throws IOException {
		System.out.println("fetching by id");
		List<Division> fecthed = divisonrepo.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "fetching-divison-info", response = Division.class)
	@RequestMapping(value = "/find-division-by-id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finddivisionbyid(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
		Division fecthed = divisonrepo.findOne(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "fetching-subdivison-info", response = SubDivision.class)
	@RequestMapping(value = "/find-all-subdivisions", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallsubdivisons() throws IOException {
		System.out.println("fetching by id");
		List<SubDivision> fecthed = subdivisonrepo.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "fetching-subdivison-info", response = SubDivision.class)
	@RequestMapping(value = "/find-subdivision-by-id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallsubdivisonbyid(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
		List<SubDivision> fecthed = subdivisonrepo.findOnebydivision(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "fetching-section-info", response = Section.class)
	@RequestMapping(value = "/find-all-sections", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallsections() throws IOException {
		System.out.println("fetching by id");
		List<Section> fecthed = setiononrepo.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	@ApiOperation(value = "fetching-section-info", response = Section.class)
	@RequestMapping(value = "/find-section-by-id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallsectionbyid(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
		List<Section> fecthed = setiononrepo.findOnebydivision(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	@ApiOperation(value = "find-sections-by-division-id", response = Section.class)
	@RequestMapping(value = "/find-sections-by-division-id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findsectionsbydivisionid(@RequestParam String[] id) throws IOException {
		System.out.println("fetching by id");
		List<Section> fecthed = setiononrepo.findsectionsbydivision(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	@ApiOperation(value = "find-division-by-constituency-id", response = AsDataView.class)
	@RequestMapping(value = "/find-division-by-constituency-id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finddivisionsbyconstituencyid(@RequestParam String[] id) throws IOException {
		System.out.println("fetching by id");
		List<AsDataView> fecthed = asdataviewRepo.finddivisionsbyconstituencyid(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	@ApiOperation(value = "find-constituency-by-division-id", response = AsDataView.class)
	@RequestMapping(value = "/find-constituency-by-division-id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findconstituencybydivisionid(@RequestParam String[] id) throws IOException {
		System.out.println("fetching by id");
		List<AsDataView> fecthed = asdataviewRepo.findconstituencybydivisionid(id);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	
	
	//for first cut of SIR
	

	@RequestMapping(value = "/find-dockes-for-section", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finddocketsforsection(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
		Set<Docket> fecthed = docketrepo.findAlldocketsforsection(id);
 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	@RequestMapping(value = "/find-dockes-for-subdivision", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finddocketsforsubdivision(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
		List<Docket> fecthed = docketrepo.findAlldocketsforsubdivision(id);
 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	@RequestMapping(value = "/find-dockes-for-division", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finddocketsfordivision(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
		List<Docket> fecthed = docketrepo.findAlldocketsfordivision(id);
 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	@RequestMapping(value = "/find-dockes-for-circle", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finddocketsforcircle(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
		List<Docket> fecthed = docketrepo.findAlldocketsforcircle(id);
 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	
	
	@ApiOperation(value = "fetching-docket-info-by-id", response = Docket.class)
	@RequestMapping(value = "/find-docket-by-id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finddocketbyid(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
		List<Docket> fecthed = docketrepo.findOnedocket(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	
	@ApiOperation(value = "fetching-docket-info-by-id", response = Docket.class)
	@RequestMapping(value = "/find-dockets", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finddocketbyidss(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
		List<Docket> fecthed = docketrepo.finddockets(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	@ApiOperation(value = "fetching-docket-info", response = Docket.class)
	@RequestMapping(value = "/find-all-dockets", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findalldockets() throws IOException {
		System.out.println("fetching by id");
		//List<Docket> fecthed = docketrepo.findAll();
		List<SirView> fecthed = sirviewrepo.findAllwithproblem();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	} 
	
	
	@ApiOperation(value = "fetching-docket-info", response = Docket.class)
	@RequestMapping(value = "/find-by-boundary-circle", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbyboundary(@RequestParam Long[] id) throws IOException {
		//@RequestParam String name,
		System.out.println("fetching by id");
		//List<Docket> fecthed = docketrepo.findAll();
		List<SirView> fecthed = sirviewrepo.findAllwithproblem2(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	} 
	

	@ApiOperation(value = "fetching-docket-info", response = Docket.class)
	@RequestMapping(value = "/find-by-boundary-division", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbyboundarydivision(@RequestParam Long[] id) throws IOException {
		//@RequestParam String name,
		System.out.println("fetching by id");
		//List<Docket> fecthed = docketrepo.findAll();
		List<SirView> fecthed = sirviewrepo.findAllwithproblem3(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	} 

	@ApiOperation(value = "fetching-docket-info", response = Docket.class)
	@RequestMapping(value = "/find-by-boundary-subdivision", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbyboundarysubdivision(@RequestParam Long[] id) throws IOException {
		//@RequestParam String name,
		System.out.println("fetching by id");
		//List<Docket> fecthed = docketrepo.findAll();
		List<SirView> fecthed = sirviewrepo.findAllwithproblem4(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	} 

	@ApiOperation(value = "fetching-docket-info", response = Docket.class)
	@RequestMapping(value = "/find-by-boundary-section", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbyboundarysection(@RequestParam Long[] id) throws IOException {
		//@RequestParam String name,
		System.out.println("fetching by id");
		//List<Docket> fecthed = docketrepo.findAll();
		List<SirView> fecthed = sirviewrepo.findAllwithproblem5(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	} 
	
	@ApiOperation(value = "fetching-docket-info", response = SwProblem.class)
	@RequestMapping(value = "/find-problem-details", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findproblemdetails(@RequestParam String type,@RequestParam String name) throws IOException {
		//@RequestParam String name,
		System.out.println("fetching by id");
		//List<Docket> fecthed = docketrepo.findAll();
		List<SwProblem> fecthed = prblmrepo.findproblemdetails(type,name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	} 
	
	@ApiOperation(value = "fetching-docket-info", response = Docket.class)
	@RequestMapping(value = "/find-problem-details-name", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findname(@RequestParam String name) throws IOException {
		//@RequestParam String name,
		System.out.println("fetching by id");
		//List<Docket> fecthed = docketrepo.findAll();
		List<Docket> fecthed = docketrepo.findname(name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	} 
	
	
	@ApiOperation(value = "fetching-docket-info", response = Docket.class)
	@RequestMapping(value = "/find-docket-details", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> finddocketnames() throws IOException {
		System.out.println("fetching by id");
		List<Docket> fecthed = docketrepo.findAll();
		System.out.println("Docket--names"+fecthed.size());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "fetching-docket-info", response = SwProblem.class)
	@RequestMapping(value = "/total-manholes-in-section", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findmanholesinasection(@RequestParam long id) throws IOException {
		System.out.println("fetching by id");
 		List<Docket> fecthed = docketrepo.findtotalanholesinasection(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	@ApiOperation(value = "findallsectionnames", response = SwProblem.class)
	@RequestMapping(value = "/find-all-sectionnames", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findallsectionnames() throws IOException {
		System.out.println("fetching by id");
 		List<Section> fecthed = setiononrepo.findallsectionnames();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}
	
	
	@ApiOperation(value = "fetching-docket-info", response = Docket.class)
	@RequestMapping(value = "/find-by-boundary", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbyboundarys(@RequestParam String name,@RequestParam Long[] id) throws IOException {
		//@RequestParam String name,
		
		List<SirView> fetched = null;
		
		try {
			fetched = (List<SirView>) new ObjectMapper().readValue(name, SirView.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 if (name == "circle") {

			fetched = sirviewrepo.findAllwithproblem2(id);

		} else if (name == "division") {

			fetched = sirviewrepo.findAllwithproblem3(id);

		}

		else if (name == "subdivision") {

			fetched = sirviewrepo.findAllwithproblem4(id);

		} else if (name == "section") {

			fetched = sirviewrepo.findAllwithproblem5(id);

		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fetched);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	} 
	
	
	/*@ApiOperation(value = "fetching-docket-info", response = SwProblem.class)
	@RequestMapping(value = "/find-by-boundary1", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findbyboundaryid(@RequestParam String id,@RequestParam String name) throws IOException {
		//@RequestParam String name,
		System.out.println("fetching by id");
		//List<Docket> fecthed = docketrepo.findAll();
		List<SirView> fecthed = sirviewrepo.findbyboundaryid(id,name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}*/ 


}