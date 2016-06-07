package com.example.restservicedemo;	

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Jedzenie;
import com.example.restservicedemo.domain.JedzenieResponse;
import com.jayway.restassured.RestAssured;

public class JedzenieServiceDBTest {
		
	private static IDatabaseConnection connection ;
	private static IDatabaseTester databaseTester;	

	@BeforeClass
	public static void setUp() throws Exception {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
			
		Connection jdbcConnection;
		jdbcConnection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		connection = new DatabaseConnection(jdbcConnection);	
	}

	@Before
	public void setUpDB() throws Exception {
		//force creating db
		RestAssured.get("/jedzenie/");
		databaseTester = new JdbcDatabaseTester(
				"org.hsqldb.jdbcDriver", "jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(
				new FileInputStream(new File("src/test/resources/jedzenieData.xml")));
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}
		
	@Test
	public void addJedzenie() throws Exception {
		
		Jedzenie aJedzenie = new Jedzenie(4L, "Kiwi", "Warzywo" ,2810);
			given().contentType(MediaType.APPLICATION_JSON).body(aJedzenie)
			.when().post("/jedzenie/").then().assertThat().statusCode(201);
			
		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("JEDZENIE");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"ID"});
			
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/jedzenieNData.xml"));
		ITable expectedTable = expectedDataSet.getTable("JEDZENIE");
			
		Assertion.assertEquals(expectedTable, filteredTable);
	}
		
	@Test
	public void getAllJedznie() throws Exception {
		RestAssured.when().get("/jedzenie/").then().assertThat().statusCode(200);
			
		JedzenieResponse jedzenie = get("/jedzenie/").as(JedzenieResponse.class);
		List<Jedzenie> j = jedzenie.getJedzenie();
			
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/jedzenieNData.xml"));
		ITable expectedTable = expectedDataSet.getTable("JEDZENIE");
			
		int i = 0;
		for (Jedzenie jedz : j) {
			assertEquals(expectedTable.getValue(i, "nazwa"), jedz.getNazwa());
			i++;
		}
	}
		
	@Test
	public void deleteJedzenie() throws Exception {
		RestAssured.when().delete("/jedzenie/").then().assertThat().statusCode(200);
			
		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("JEDZENIE");
			
		assertEquals(0, actualTable.getRowCount());		
	}
		
	@AfterClass
	public static void tearDown() throws Exception {
		databaseTester.onTearDown();
	}	
}
