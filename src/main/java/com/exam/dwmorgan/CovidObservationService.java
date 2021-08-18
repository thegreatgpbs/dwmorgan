package com.exam.dwmorgan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.exam.domain.CovidObservation;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class CovidObservationService {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public List<CovidObservation> getListByDateAndCount(Date convertedDate, Integer count){
		List<CovidObservation> list = new ArrayList<CovidObservation>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String inputDate = sdf.format(convertedDate);
		
		String sql = "SELECT * FROM covid_observations WHERE observation_date = '" + inputDate + "' ORDER BY confirmed DESC LIMIT " + count;
		
		try {
			list = jdbctemplate.query(sql, new CovidObservationRowMapper());
		} catch (DataAccessException e) {
			System.err.println(e);
		}
		
		return list;
	}
	
	public static void readCSV(String fileName) throws FileNotFoundException, IOException, CsvValidationException {
		System.out.println(">>>Read CSV in");
		SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
		try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
		    List<CovidObservation> covidList = new CsvToBeanBuilder<CovidObservation>(new FileReader(fileName))
	                .withType(CovidObservation.class)
	                .build()
	                .parse();

		    for(CovidObservation obj : covidList) {
	        	session.save(obj);
	        	session.flush();
	        }
		    session.close();
		}
		System.out.println(">>>Read CSV out");
	}
}
