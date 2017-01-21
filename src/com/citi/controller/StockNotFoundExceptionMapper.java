package com.citi.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.citi.viewBean.ExceptionMessage;
import com.citi.exception.StockNotFoundException;

@Provider
public class StockNotFoundExceptionMapper implements ExceptionMapper<StockNotFoundException>{

	@Override
	public Response toResponse(StockNotFoundException cnfe) {
		
		ExceptionMessage exceptionMessage= new ExceptionMessage(cnfe.getExceptionMessage(),"404");
		return Response.status(Status.NOT_FOUND).entity(exceptionMessage).build();
	}

	
}

