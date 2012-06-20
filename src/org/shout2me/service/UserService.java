package org.shout2me.service;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.shout2me.entity.User;
import org.shout2me.entity.dao.UserDAO;
import org.shout2me.entity.to.UserTO;
import org.shout2me.jdo.util.EncryptUtil;
import org.shout2me.service.util.KeyUtil;
import org.shout2me.service.util.ValidationUtil;

@Path("/user")
public class UserService {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/create")
	public Response create(@FormParam("name") String name,
			@FormParam("mail") String mail,
			@FormParam("password") String password,
			@FormParam("description") String description,
			@Context HttpServletResponse response) {
		// validation
		ValidationUtil.validatesMail(mail);
		ValidationUtil.validatesUserName(name);
		ValidationUtil.validatesPassword(password);
		ValidationUtil.validatesDescription(description);
		ValidationUtil.validatesNotExistsMail(mail);
		// persist
		User u = new User();
		u.setName(name);
		u.setMail(mail);
		u.setPassword(EncryptUtil.makePassword(password));
		u.setDescription(description);
		u.setSalt(EncryptUtil.generateRandomString());
		UserDAO u_dao = new UserDAO(User.class);
		u_dao.create(u);
		return Response
				.status(200)
				.entity(KeyUtil.makeKey(String.valueOf(u.getKey().getId()),
						u.getSalt())).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserTO getById(@QueryParam("id") Long id) {
		UserDAO u_dao = new UserDAO(User.class);
		User u = u_dao.find(id);
		return new UserTO(u);
	}
}
