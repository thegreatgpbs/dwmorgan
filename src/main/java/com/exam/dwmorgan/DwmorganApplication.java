package com.exam.dwmorgan;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.exceptions.CsvValidationException;

@SpringBootApplication
public class DwmorganApplication {
	
	@Autowired
	public CovidObservationService coService;
	
	public static void main(String[] args) throws CsvValidationException, FileNotFoundException, IOException {
		SpringApplication.run(DwmorganApplication.class, args);
		
		String fileName = "C:\\Users\\Paolo\\Downloads\\covid_19_data.csv";
		CovidObservationService.readCSV(fileName);
	}
}
