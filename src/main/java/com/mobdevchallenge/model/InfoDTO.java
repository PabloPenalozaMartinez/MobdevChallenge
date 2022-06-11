package com.mobdevchallenge.model;

/**
 * Clase que guarda la informacion de la paginacion de todos los personajes 
 * al solicitar info al endpoint https://rickandmortyapi.com/api/character/?page=2  
 * 
 * @author ppenaloza
 *
 */
public class InfoDTO {
	private int count;
	private int pages;
	private String next;
	private String prev;
	 
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrev() {
		return prev;
	}
	public void setPrev(String prev) {
		this.prev = prev;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	 
}
