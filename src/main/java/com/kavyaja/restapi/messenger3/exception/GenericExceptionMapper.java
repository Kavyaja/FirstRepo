package com.kavyaja.restapi.messenger3.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.Errors.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {


	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),404,"http://DataNotFoundException");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

	private ResponseBuilder Status_NOT_FOUND() {
		// TODO Auto-generated method stub
		return null;
	}
}

