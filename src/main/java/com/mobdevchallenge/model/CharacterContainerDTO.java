package com.mobdevchallenge.model;

import java.util.ArrayList;

/**
 * Clase contenedora del RESPONSE del endponit https://rickandmortyapi.com/api/character/
 * @author ppenaloza
 *
 */
public class CharacterContainerDTO {
	private InfoDTO info;
	private ArrayList<CharacterDTO> results = new ArrayList<CharacterDTO>();
	
	public InfoDTO getInfo() {
		return info;
	}
	public void setInfo(InfoDTO info) {
		this.info = info;
	}
	public ArrayList<CharacterDTO> getResults() {
		return results;
	}
	public void setResults(ArrayList<CharacterDTO> results) {
		this.results = results;
	}
	
}
