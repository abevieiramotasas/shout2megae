package org.shout2me.service.exceptionmapper;

import javax.jdo.JDOObjectNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityNotFoundExceptionMapper implements
		ExceptionMapper<JDOObjectNotFoundException> {

	@Override
	public Response toResponse(JDOObjectNotFoundException arg0) {
		return Response.status(404).entity(arg0.getMessage())
				.type("text/plain").build();
	}

}
