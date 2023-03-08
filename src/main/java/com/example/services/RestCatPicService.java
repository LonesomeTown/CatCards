package com.example.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.example.model.CatPic;

@Component
public class RestCatPicService implements CatPicService {

	private static final String API_URL = "https://cat-data.netlify.app/api/pictures/random";    //Need to fix this.

	private RestTemplate restTemplate = new RestTemplate();

    public CatPic getPic() throws RestClientResponseException {
    	CatPic catPic = restTemplate.getForObject(API_URL, CatPic.class);
        return catPic;
    }

}
