package com.example.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.example.model.CatFact;

@Component
public class RestCatFactService implements CatFactService {

	private static final String API_URL = "https://cat-data.netlify.app/api/facts/random";    //Need to fix this.

	private RestTemplate restTemplate = new RestTemplate();
	
    public CatFact getFact() throws RestClientResponseException {
        CatFact catFact = restTemplate.getForObject(API_URL, CatFact.class);
        return catFact;
    }

}
