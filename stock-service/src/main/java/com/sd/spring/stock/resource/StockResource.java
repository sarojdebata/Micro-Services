package com.sd.spring.stock.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{username}")
	public @ResponseBody List<String> getStock(@PathVariable("username")final String userName){
		
		ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://db-service/rest/db/"+userName, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
		});
		
		List<String> quotes = quoteResponse.getBody();
		
		return quotes;
		
	}
	
}


