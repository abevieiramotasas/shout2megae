package org.shout2me.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/help")
public class PagesHelp {

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/create")
	public String criarIlha() {
		String form = "<form action=\"/island/create\">"
				+ "name : <input type=\"text\" name=\"name\" /><br />"
				+ "longitude : <input type=\"text\" name=\"longitude\" /><br />"
				+ "latitude : <input type=\"text\" name=\"latitude\" /><br />"
				+ "description : <input type=\"text\" name=\"description\" /><br />"
				+ "key : <input type=\"text\" name=\"key\" value=\"must be logged"
				+ "\" /><br />" + "<input type=\"submit\" value=\"create\" />"
				+ "</form>";
		return form;
	}

}
