package com.exam.dwmorgan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.domain.CovidObservation;
import com.exam.domain.ResponseMessage;

@RestController
public class HomeController {
	
	@Autowired
	CovidObservationService coService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to GPBS APP!!!";
	}
	
	@GetMapping("/top/confirmed")
	public @ResponseBody ResponseMessage<List<CovidObservation>> getData(@RequestParam("observation_date") String observationDate, @RequestParam("max_results") Integer maxResults) throws ParseException { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date convertedDate = sdf.parse(observationDate);
		ResponseMessage<List<CovidObservation>> response= new ResponseMessage<>(observationDate);
		List<CovidObservation> list = new ArrayList<CovidObservation>();
		
		try {
			list = coService.getListByDateAndCount(convertedDate, maxResults);
			response.setCountries(list);
			response.setObservationDate(observationDate);
		} catch (DataAccessException e) {
			System.err.println(e);
		}
		
		return response;
	}
}
