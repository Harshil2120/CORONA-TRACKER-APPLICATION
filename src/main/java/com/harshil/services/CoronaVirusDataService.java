package com.harshil.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshil.models.CountriesObject;


@Service
public class CoronaVirusDataService {

	private static String VIRUS_DATA_URL="https://corona.lmao.ninja/v2/countries?yesterday&sort";
	
	private List<CountriesObject> allstats=new ArrayList<>();
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchVirusData() throws IOException, InterruptedException {
		
		List<CountriesObject> newstats=new ArrayList<>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request=HttpRequest.newBuilder()
				.uri(URI.create(VIRUS_DATA_URL))
				.build();
		HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
		ObjectMapper mapper = new ObjectMapper();
		
		newstats = mapper.readValue(response.body(), new TypeReference<List<CountriesObject>>(){});
		this.allstats=newstats;
	
		
	}
	
	public List<CountriesObject> getAllstats() {
		return allstats;
	}
	
	
}
