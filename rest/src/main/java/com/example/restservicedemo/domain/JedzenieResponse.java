package com.example.restservicedemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class JedzenieResponse {
	List<Jedzenie> jedzenie = new ArrayList<Jedzenie>();

	public List<Jedzenie> getJedzenie() {
		return jedzenie;
	}

	public void setJedzenie(List<Jedzenie> jedzenie) {
		this.jedzenie = jedzenie;
	}
}
