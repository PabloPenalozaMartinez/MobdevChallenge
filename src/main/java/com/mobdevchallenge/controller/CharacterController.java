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

import com.mobdevchallenge.model.CharacterContainerDTO;
import com.mobdevchallenge.model.CharacterDTO;


@RestController
@RequestMapping("character")
public class CharacterController {
	
	private final String POST_BY_PAGE = "https://rickandmortyapi.com/api/character/?page={page}";
	private final String POST_BY_ID_API = "https://rickandmortyapi.com/api/character/{id}";
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping(value = {"/list", "/list/?page={page}"}, method= RequestMethod.GET)
	public CharacterContainerDTO getCharacter(@RequestParam(name="page", required=false) String page){
		return webClientBuilder.build()
				 .get()
				 .uri(POST_BY_PAGE, page)
				 .retrieve()
				 .bodyToMono(CharacterContainerDTO.class)
				 .block();
	}
	
	@GetMapping("/list/{id}")
	public List<CharacterDTO> getCharacterById(@PathVariable("id") String id){
		if(id.contains(",")) {
			return webClientBuilder.build()
					.get()
					.uri(POST_BY_ID_API, id)
					.retrieve()
					.bodyToMono(new ParameterizedTypeReference<List<CharacterDTO>>() {})
					.block();	 
		}else{
			List<CharacterDTO> listCharacter = new ArrayList<CharacterDTO>();
			CharacterDTO character = webClientBuilder.build()
									.get()
									.uri(POST_BY_ID_API, id)
									.retrieve()
									.bodyToMono(CharacterDTO.class)
									.block();
			listCharacter.add(character);
			return listCharacter; 
		}
	}

}
