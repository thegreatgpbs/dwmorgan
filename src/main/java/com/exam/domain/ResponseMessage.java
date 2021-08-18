package com.exam.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true) 
@JsonInclude(Include.NON_NULL)
public class ResponseMessage<T> {

	private String observationDate;
	private T countries;
	
	public ResponseMessage(String action) {
		observationDate = action;
	}

	public String getObservationDate() {
		return observationDate;
	}

	public void setObservationDate(String observationDate) {
		this.observationDate = observationDate;
	}

	public T getCountries() {
		return countries;
	}

	public void setCountries(T countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "{observationDate=" + observationDate + ", "
				+ "countries=" + countries + "}";
	}

	

}