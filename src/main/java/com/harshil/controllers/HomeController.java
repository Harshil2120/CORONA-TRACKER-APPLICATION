package com.harshil.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harshil.models.CountriesObject;
import com.harshil.services.CoronaVirusDataService;

@Controller
public class HomeController {

	@Autowired
	CoronaVirusDataService coronavirusdataservice;
	
	@GetMapping("/")
	public String home(Model model) {
		List<CountriesObject> allStats=coronavirusdataservice.getAllstats();
		int totalReportedCases =allStats.stream().mapToInt(stat -> stat.getCases()).sum();
		int recovercases=allStats.stream().mapToInt(stat -> stat.getRecovered()).sum();
		int totalDeathCases=allStats.stream().mapToInt(stat -> stat.getDeaths()).sum();
		int ActiveCases=allStats.stream().mapToInt(stat -> stat.getActive()).sum();
		int PrevReportedCases =allStats.stream().mapToInt(stat -> stat.getTodayCases()).sum();
		int PrevDeathCases=allStats.stream().mapToInt(stat -> stat.getTodayDeaths()).sum();
		int PrevRecoverCases=allStats.stream().mapToInt(stat -> stat.getTodayRecovered()).sum();
		model.addAttribute("countryStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		model.addAttribute("PrevReportedCases", PrevReportedCases);
		model.addAttribute("totalDeathCases", totalDeathCases);
		model.addAttribute("recovercases", recovercases);
		model.addAttribute("PrevDeathCases", PrevDeathCases);
		model.addAttribute("PrevRecoverCases", PrevRecoverCases);
		model.addAttribute("ActiveCases", ActiveCases);
		return "home";
	}
	
	@RequestMapping("/covid19")
	public String covid19() {
		return "covid19";
	}
    
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
}
