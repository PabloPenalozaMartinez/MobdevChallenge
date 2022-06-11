package com.mobdevchallenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.mobdevchallenge.model.LocationContainerDTO;
import com.mobdevchallenge.model.LocationDTO;


@RestController
@RequestMapping("location")
public class LocationController {
	
	private final String POST_BY_PAGE = "https://rickandmortyapi.com/api/location/?page={page}";
	private final String POST_BY_ID_API = "https://rickandmortyapi.com/api/location/{id}";
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping(value = {"/list", "/list/?page={page}"}, method= RequestMethod.GET)
	public LocationContainerDTO getCharacter(@RequestParam(name="page", required=false) String page){
		return webClientBuilder.build()
				 .get()
				 .uri(POST_BY_PAGE, page)
				 .retrieve()
				 .bodyToMono(LocationContainerDTO.class)
				 .block();
	}
	
	@GetMapping("/list/{id}")
	public List<LocationDTO> getCharacterById(@PathVariable("id") String id){
		if(id.contains(",")) {
			return webClientBuilder.build()
					.get()
					.uri(POST_BY_ID_API, id)
					.retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<LocationDTO>>() {})
					.block();	 
		}else{
			List<LocationDTO> listLocation = new ArrayList<LocationDTO>();
			listLocation.add(webClientBuilder.build()
									.get()
									.uri(POST_BY_ID_API, id)
									.retrieve()
									.bodyToMono(LocationDTO.class)
									.block());
			return listLocation; 
		}
	}

}
