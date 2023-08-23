package com.kavyaja.restapi.messenger3.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.kavyaja.restapi.messenger3.models.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

			@Override
			public Response toResponse(DataNotFoundException ex) {
				ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),404,"http://DataNotFoundException");
				return Response.status(Status.NOT_FOUND).build();
			}

			private ResponseBuilder Status_NOT_FOUND() {
				// TODO Auto-generated method stub
				return null;
			}
}
