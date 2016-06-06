package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Jedzenie;
import com.example.restservicedemo.domain.JedzenieResponse;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

public class JedzenieServiceTest {

	public static final String JEDZENIE_NAZWA = "Banan";
	public static final String JEDZENIE_RODZAJ = "Owoc";
	
	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}

	@Test
	public void addJedzenie() {
		delete("/jedzenie/").then().assertThat().statusCode(200);

		Jedzenie jedzenie = new Jedzenie(1L, JEDZENIE_NAZWA, JEDZENIE_RODZAJ, 1994);

		given().contentType(MediaType.APPLICATION_JSON).body(jedzenie).when().post("/jedzenie/").then().assertThat()
				.statusCode(201);

		Jedzenie jJedzenie = get("/jedzenie/1").as(Jedzenie.class);

		assertEquals(JEDZENIE_NAZWA, jJedzenie.getNazwa());
		assertEquals(JEDZENIE_RODZAJ, jJedzenie.getRodzaj());

	}

	@Test
	public void getAllJedzenie() {
		Jedzenie jedzenie = new Jedzenie(1L, JEDZENIE_NAZWA, JEDZENIE_RODZAJ, 1994);
		Jedzenie jedzenie2 = new Jedzenie(2L, JEDZENIE_NAZWA, JEDZENIE_RODZAJ, 2009);
		given().contentType(MediaType.APPLICATION_JSON).body(jedzenie).when().post("/jedzenie/");
		given().contentType(MediaType.APPLICATION_JSON).body(jedzenie2).when().post("/jedzenie/");
		
		RestAssured.when().get("/jedzenie/").then().assertThat().statusCode(200);
		
		JedzenieResponse jedzenie3 = get("/jedzenie/").as(JedzenieResponse.class);
		List<Jedzenie> j = jedzenie3.getJedzenie();
		
		assertEquals(1994, j.get(0).getRokProdukcji());
		assertEquals(2009, j.get(1).getRokProdukcji());
	}
	
	@Test
	public void getJedzenieNazwa() {
		Jedzenie jedzenie = new Jedzenie(1L, JEDZENIE_NAZWA, JEDZENIE_RODZAJ, 1994);
		Jedzenie jedzenie2 = new Jedzenie(2L, JEDZENIE_NAZWA, JEDZENIE_RODZAJ, 2009);
		given().contentType(MediaType.APPLICATION_JSON).body(jedzenie).when().post("/jedzenie/");
		given().contentType(MediaType.APPLICATION_JSON).body(jedzenie2).when().post("/jedzenie/");
		
		RestAssured.when().get("/jedzenie/szukaj/Banan").then().assertThat().statusCode(200);
		
		
		
		
		Jedzenie jJedzenie = get("/jedzenie/1").as(Jedzenie.class);
		assertEquals("Banan", jJedzenie.getNazwa());
		
	}
	
	@Test
	public void getJedzenieId() {
		Jedzenie jedzenie = new Jedzenie(1L, JEDZENIE_NAZWA, JEDZENIE_RODZAJ, 1994);
		Jedzenie jedzenie2 = new Jedzenie(2L, JEDZENIE_NAZWA, JEDZENIE_RODZAJ, 2009);
		given().contentType(MediaType.APPLICATION_JSON).body(jedzenie).when().post("/jedzenie/");
		given().contentType(MediaType.APPLICATION_JSON).body(jedzenie2).when().post("/jedzenie/");
		
		RestAssured.when().get("/jedzenie").then().assertThat().statusCode(200);
		
		JedzenieResponse jedzenie5 = get("/jedzenie").as(JedzenieResponse.class);
		List<Jedzenie> j = jedzenie5.getJedzenie();
		
		assertEquals(1, j.get(0).getId());
	
	}
	
	@Test
	public void deleteJedzenie() {
		Jedzenie jedzenie = new Jedzenie(1L, JEDZENIE_NAZWA, JEDZENIE_RODZAJ, 1994);
		Jedzenie jedzenie2 = new Jedzenie(2L, JEDZENIE_NAZWA, JEDZENIE_RODZAJ, 2009);
		given().contentType(MediaType.APPLICATION_JSON).body(jedzenie).when().post("/jedzenie/");
		given().contentType(MediaType.APPLICATION_JSON).body(jedzenie2).when().post("/jedzenie/");
		
		delete("/jedzenie/").then().assertThat().statusCode(200);
		
		RestAssured.when().get("/jedzenie").then().assertThat().statusCode(200);
	
		String response = get("/jedzenie").asString();
		assertEquals("null",response);
		
	}
	

		
		
		
	@After
	public void clean() {
		delete("/jedzenie/").then().assertThat().statusCode(200);
	}

}
