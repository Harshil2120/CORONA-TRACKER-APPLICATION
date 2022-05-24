package com.harshil.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountriesObject {
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("cases")
	private int cases;
	
	@JsonProperty("todayCases")
	private int todayCases;
	
	@JsonProperty("deaths")
	private int deaths;
	
	@JsonProperty("todayDeaths")
	private int todayDeaths;
	
	@JsonProperty("recovered")
	private int recovered;
	
	@JsonProperty("todayRecovered")
	private int todayRecovered;
	
	@JsonProperty("active")
	private int active;
	

	public CountriesObject() {
	}

	public CountriesObject(String country, int cases, int deaths, int todayDeaths, int recovered, int todayRecovered,
			int active,int todayCases) {
		this.country = country;
		this.cases = cases;
		this.deaths = deaths;
		this.todayDeaths = todayDeaths;
		this.recovered = recovered;
		this.todayRecovered = todayRecovered;
		this.active = active;
		this.todayCases = todayCases;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCases() {
		return cases;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public int getDeaths() {
		return deaths;
	}
	
	public int getTodayCases() {
		return todayCases;
	}

	public void setTodayCases(int todayCases) {
		this.todayCases = todayCases;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getTodayDeaths() {
		return todayDeaths;
	}

	public void setTodayDeaths(int todayDeaths) {
		this.todayDeaths = todayDeaths;
	}

	public int getRecovered() {
		return recovered;
	}

	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}

	public int getTodayRecovered() {
		return todayRecovered;
	}

	public void setTodayRecovered(int todayRecovered) {
		this.todayRecovered = todayRecovered;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "CountriesObject [country=" + country + ", cases=" + cases + ", todayCases=" + todayCases + ", deaths="
				+ deaths + ", todayDeaths=" + todayDeaths + ", recovered=" + recovered + ", todayRecovered="
				+ todayRecovered + ", active=" + active + "]";
	}

	
}
