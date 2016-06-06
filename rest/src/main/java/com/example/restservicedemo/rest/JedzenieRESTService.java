package com.example.restservicedemo.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.Jedzenie;
import com.example.restservicedemo.service.JedzenieManager;

@Path("jedzenie")
public class JedzenieRESTService {
	
	private JedzenieManager jm = new JedzenieManager();
	
	@GET
	@Path("/{jedzenieId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Jedzenie getJedzenie(@PathParam("jedzenieId") Long id) {
		Jedzenie b = jm.getJedzenie(id);
		return b;
	}
	
	@GET
	@Path("/szukaj/{nazwa}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Jedzenie> getJedzenie(@PathParam("nazwa") String nazwa) {
		List<Jedzenie> b = jm.getJedzenieByNazwa(nazwa);
		return b;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addJedzenie(Jedzenie jedzenie) {
		jm.addJedzenie(jedzenie);
		return Response.status(201).entity("Jedzenie").build();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Jedzenie> getAllJedzenie() {
		List<Jedzenie> Jedzenie = jm.getAllJedzenie();
		return Jedzenie;
	}
	
	@GET
	@Path("/testJedzenie")
	@Produces(MediaType.TEXT_HTML)
	public String testJedzenie() {
		return "REST API /jedzenie is running";
	}
	
	@DELETE
	public Response clearJedzenie() {
		jm.clearJedzenie();
		return Response.status(200).build();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateJedzenie(Jedzenie jedzenie) {
		jm.updateJedzenie(jedzenie);
		return Response.status(200).build();
	}
	
				

}