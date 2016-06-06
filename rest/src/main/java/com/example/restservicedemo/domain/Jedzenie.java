package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Jedzenie {
	
	private long id;
	private String nazwa;
	private String rodzaj;	
	private int rokProdukcji;
	
	public Jedzenie(long id, String nazwa, String rodzaj, int rokProdukcji) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.rodzaj = rodzaj;
		this.rokProdukcji = rokProdukcji;
	}
	
	public Jedzenie() {
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getRodzaj() {
		return rodzaj;
	}
	public void setRodzaj(String rodzaj) {
		this.rodzaj = rodzaj;
	}
	public int getRokProdukcji() {
		return rokProdukcji;
	}
	public void setRokProdukcji(int rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}
	
	
	
}
