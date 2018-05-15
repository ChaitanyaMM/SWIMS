package com.mm.swims.Controller;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.mm.swims.Entity.Sample;
import com.mm.swims.Repository.SampleRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/sample")
@Api(value = "Sewer-SampleController", tags = "SWIMS API")

public class SampleController {

	@Autowired()
	private SampleRepo samplerepo;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String sample() {

		return "Sample in SWIMS is Up boy!!!!!";

	}

	/*
	 * @RequestMapping(value="/")
	 * 
	 * @ResponseBody public String home() { return "Hello MMBit"; }
	 */
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	@ResponseBody
	public String getHello() {
		return "Hello image Api is working";
	}

	@ApiOperation(value = "pay", response = Sample.class)
	@RequestMapping(value = "/insert-pay", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Createsection(@RequestBody String data)
			throws IOException, ParseException {
		System.out.println("create estimate service is Calling !.");
		Sample estimate = new Sample();

		try {
			estimate = new ObjectMapper().readValue(data, Sample.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entered");
		// Date ts=new Date(System.currentTimeMillis());

		Sample fecthed = samplerepo.save(estimate);
		System.out.println("Checking sewer  method");

		map.put("Data", fecthed);
		map.put("message", "Estimate Created Successfully. !.");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	 @ApiOperation(value = "find-all", response = Sample.class)
	 @RequestMapping(value = "/find-all", method = RequestMethod.GET)
	 @ResponseBody
	 public ResponseEntity<Map<String, Object>> findestimatebystatus(@RequestParam String name) throws
	 IOException {
	 System.out.println("find-estimates");
	 List<Sample> fecthed = samplerepo.findbypay(name);
	 Map<String, Object> map = new HashMap<String, Object>();
	 map.put("Data", fecthed);
	 map.put("message", "Successfully Retrieved data");
	 map.put("status", true);
	 return ResponseEntity.ok().body(map);
	 }
	 
	 
	 
//	 @ApiOperation(value = "find-all", response = Sample.class)
//	 @RequestMapping(value = "/find-by-intervels", method = RequestMethod.GET)
//	 @ResponseBody
//	 public ResponseEntity<Map<String, Object>> findbyinntervels() throws IOException, ParseException {
//	 System.out.println("find-estimates");
//	 
//	 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//	 Date parse = sdf.parse("18/08/2012");
//	 Calendar cal = Calendar.getInstance();
//	 cal.setTime(parse);
//	 cal.get(Calendar.MONTH);
//	 System.out.println("<><<>cal.get(Calendar.MONTH);"+	 cal.get(Calendar.MONTH +1));
//	    Month month = Month.from(LocalDate.now()); 
//	    Calendar cal1 = Calendar.getInstance();
//	    int months =cal1.MONTH +1;
//	    
//
//		 System.out.println("month"+months);
//
//	//samp.getPaying_date();
//			// 2018-02-21
////			 String str[] = "18/08/2012".split("/");
////			 int day = Integer.parseInt(str[0]);
////			 int month = Integer.parseInt(str[1]);
////			 
////			 String[] months = new DateFormatSymbols().getMonths();
////		        for (String month : months) {
////		            System.out.println("month = " + month);
////		        }
////
////		        String[] shortMonths = new DateFormatSymbols().getShortMonths();
////		        for (String shortMonth : shortMonths) {
////		            System.out.println("shortMonth = " + shortMonth);
////		        }
//		 int month1 = cal.get( Calendar.MONTH );
//		 cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
//		 if( cal.get( month1 ) > month1 + 1 ) {
//		     cal.set( Calendar.MONTH, month1 + 1 );
//		     System.out.println("month1<><><>"+month1);
// 		     //cal.set( Calendar.DAY, /* here comes your day amount finding algorithm */ );
//		 }
//	 List<Sample> fecthed = samplerepo.findAll();
//	 	for(Sample samp: fecthed){
//		 
//		 System.out.println("samp"+samp.getPaying_date());
//		 samp.getPaying_date().setMonth(months);
//		 System.out.println("obj"+obj);
//
//		  List<Sample> A =new ArrayList<Sample>();//everymonth
//	 	 if(samp.getPaying_date() != null ){
//	 	 boolean Alist =A.addAll(fecthed);
//	 	 }
//	 	 
//	 	 
//	 	 
//	
//
//		 
//	 }
//	 
// 	// List<Sample> users =new ArrayList<Sample>();
// 	 
//	/* 	 List<Sample> B =new ArrayList<Sample>();//2months
//	 	 List<Sample> C =new ArrayList<Sample>();//3months
//	 	 List<Sample> D =new ArrayList<Sample>();//4months
//*/
//	// boolean userintevels =users.addAll(fecthed);
//
//	 
//
//	 
//	 
//	 
//	 
//	 
//	 
//	 Map<String, Object> map = new HashMap<String, Object>();
//	 map.put("Data", fecthed);
//	 map.put("message", "Successfully Retrieved data");
//	 map.put("status", true);
//	 return ResponseEntity.ok().body(map);
//	 }
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	 
//	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @ApiOperation(value = "find-all", response = Sample.class)
	 @RequestMapping(value = "/find-by-intervels", method = RequestMethod.GET)
	 @ResponseBody
	 public ResponseEntity<Map<String, Object>> findbyinntervels() throws IOException, ParseException {
	 System.out.println("find-estimates");
	 
     List<Sample> fecthed = samplerepo.findAll();
     
     for(Sample samp : fecthed){
    	 
    	 
    	 Calendar cal = Calendar.getInstance();
    	 cal.get(Calendar.MONTH +1);    	
         int month=cal.get(Calendar.MONTH +1);
    	 Date obj= samp.getPaying_date();
         System.out.println("Date"+samp.getPaying_date());
         samp.getPaying_date().setMonth(month);
     	
     }

	 
	 
	 Map<String, Object> map = new HashMap<String, Object>();
	 map.put("Data", fecthed);
	 map.put("message", "Successfully Retrieved data");
	 map.put("status", true);
	 return ResponseEntity.ok().body(map);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}