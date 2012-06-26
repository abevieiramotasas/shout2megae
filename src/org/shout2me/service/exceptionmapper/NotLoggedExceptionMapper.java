package org.shout2me.service.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.shout2me.service.exception.NotLoggedException;

@Provider
public class NotLoggedExceptionMapper implements
		ExceptionMapper<NotLoggedException> {

	@Override
	public Response toResponse(NotLoggedException arg0) {
		return Response.status(401).build();
	}

}
