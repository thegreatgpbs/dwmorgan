package com.exam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name="covid_observations")
@JsonInclude(Include.NON_NULL)
public class CovidObservation {
	
	@Id
	@Column(name="id")
	@CsvBindByName(column = "SNo")
	private Integer id;
	
	@Column(name="city")
	@CsvBindByName(column = "Province/State")
	private String city;
	
	@Column(name="country")
	@CsvBindByName(column = "Country/Region")
	private String country;
	
	@Column(name="confirmed")
	@CsvBindByName(column = "Confirmed")
	private Double confirmedDouble;
	
	@Column(name="deaths")
	@CsvBindByName(column = "Deaths")
	private Double deathsDouble;
	
	@Column(name="recovered")
	@CsvBindByName(column = "Recovered")
	private Double recoveredDouble;
	
	@Column(name="observation_date")
	@CsvBindByName(column = "ObservationDate")
	private String observationDate;
	
	@Transient
	private Long confirmed;
	
	@Transient
	private Long deaths;
	
	@Transient
	private Long recovered;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getConfirmedDouble() {
		return confirmedDouble;
	}

	public void setConfirmedDouble(Double confirmedDouble) {
		this.confirmedDouble = confirmedDouble;
	}

	public Double getDeathsDouble() {
		return deathsDouble;
	}

	public void setDeathsDouble(Double deathsDouble) {
		this.deathsDouble = deathsDouble;
	}

	public Double getRecoveredDouble() {
		return recoveredDouble;
	}

	public void setRecoveredDouble(Double recoveredDouble) {
		this.recoveredDouble = recoveredDouble;
	}

	public String getObservationDate() {
		return observationDate;
	}

	public void setObservationDate(String observationDate) {
		this.observationDate = observationDate;
	}

	public Long getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Long confirmed) {
		this.confirmed = confirmed;
	}

	public Long getDeaths() {
		return deaths;
	}

	public void setDeaths(Long deaths) {
		this.deaths = deaths;
	}

	public Long getRecovered() {
		return recovered;
	}

	public void setRecovered(Long recovered) {
		this.recovered = recovered;
	}

	@Override
	public String toString() {
		return "CovidObservation [id=" + id + ", city=" + city + ", country=" + country + ", confirmed=" + confirmed
				+ ", deaths=" + deaths + ", recovered=" + recovered + ", observationDate=" + observationDate + "]";
	}
}
