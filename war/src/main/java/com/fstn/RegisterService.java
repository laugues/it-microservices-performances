package com.fstn;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class RegisterService {

	private static final Logger log = Logger.getLogger(RegisterService.class
			.getName());

	@Inject
	private RegistrerConfig registrer;

	@PostConstruct
	private void init(){	
	}
			
	@POST
	@Path("/registerChild")
	@Consumes("application/json")
	public Response registerChild(Api childApi) {
		log.log(Level.INFO,"registering  "+childApi.toString()+" ....");
		registrer.registerChildApi(childApi);
		log.log(Level.INFO, "registering  " + childApi.toString()+" DONE.");
		return Response.ok().build();
	}
	
	@POST
	@Path("/unRegisterChild")
	@Consumes("application/json")
	public Response unRegisterChild(Api childApi) {
		log.log(Level.INFO,"unRegistering "+childApi.toString()+" ....");
		registrer.unRegisterChildApi(childApi);
		log.log(Level.INFO, "unRegistering " + childApi.toString() + " DONE.");
		return Response.ok().build();
	}
}