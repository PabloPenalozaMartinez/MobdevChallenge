package com.mobdevchallenge.model;

import java.util.ArrayList;

/**
 * Clase contenedora del RESPONSE del endponit https://rickandmortyapi.com/api/character/
 * @author ppenaloza
 *
 */
public class LocationContainerDTO {
	private InfoDTO info;
	private ArrayList<LocationDTO> results = new ArrayList<LocationDTO>();
	
	public InfoDTO getInfo() {
		return info;
	}
	public void setInfo(InfoDTO info) {
		this.info = info;
	}
	public ArrayList<LocationDTO> getResults() {
		return results;
	}
	public void setResults(ArrayList<LocationDTO> results) {
		this.results = results;
	}
	
}
