package com.kavyaja.restapi.messenger3.resources;

import java.net.http.HttpHeaders;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)


public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String getParamUsingAnnotations(@MatrixParam("param")String matrixParam,
			@HeaderParam("customHeaderValue")String header,
			@CookieParam("none")String cookie) {
		return "Matrix param: " + matrixParam + " Header Param:" + header + "Cookie param:" + cookie;
		
	}
	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo, 
			@Context HttpHeaders headers) {
		
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getoString();

		return "Path : "+path +"Cookies:" + cookies;
	}
	

}
