package org.shout2me.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/help")
public class PageHihiService {

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/create")
	public String criarIlha() {
		// Abelardo user, use com cuidado remoto
		String key_abe = "9001|ffffffaf757effffffc13a5361ffffff91ffffffc0fffffff6ffffffa1ffffffe54a0bffffffeaffffffd67affffffcbffffff88ffffffd7ffffff84ffffffefffffffd3215e24186bffffffd613516b";
		// Juliana user, local
		String key_ju = "78|ffffff98ffffffea5f5b28ffffffa22affffffe5ffffffbaffffffd9ffffffd602ffffffeaffffffb85f2fffffffaeffffffea40ffffffa3ffffffea34ffffff93ffffffdf74ffffffea36fffffff27559ffffff9dffffffce";
		String meuFormLindo = "<form action=\"/island/create\">"
				+ "name : <input type=\"text\" name=\"name\" /><br />"
				+ "longitude : <input type=\"text\" name=\"longitude\" /><br />"
				+ "latitude : <input type=\"text\" name=\"latitude\" /><br />"
				+ "description : <input type=\"text\" name=\"description\" /><br />"
				+ "key : <input type=\"text\" name=\"key\" value=\"" + key_abe
				+ "\" /><br />" + "<input type=\"submit\" value=\"papoco\" />"
				+ "</form>";
		return meuFormLindo;
	}

}
