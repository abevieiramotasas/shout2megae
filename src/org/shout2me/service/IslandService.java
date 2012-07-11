package org.shout2me.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.shout2me.entity.Island;
import org.shout2me.entity.Message;
import org.shout2me.entity.User;
import org.shout2me.entity.dao.IslandDAO;
import org.shout2me.entity.to.IslandTO;
import org.shout2me.entity.to.IslandTOWrapper;
import org.shout2me.service.util.KeyUtil;
import org.shout2me.service.util.ValidationUtil;

@Path("/island")
public class IslandService {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/create")
	public String create(@FormParam("name") String name,
			@FormParam("longitude") Double longitude,
			@FormParam("latitude") Double latitude,
			@FormParam("description") String description,
			@FormParam("key") String key) {
		// validations
		ValidationUtil.validatesIslandName(name);
		ValidationUtil.validatesLongitude(longitude);
		ValidationUtil.validatesLatitude(latitude);
		ValidationUtil.validatesDescription(description);
		User u = KeyUtil.getUserByKey(key);
		ValidationUtil.validatesUserFound(u);
		// persist
		Island i = new Island();
		i.setName(name);
		i.setLongitude(longitude);
		i.setLatitude(latitude);
		i.setDescription(description);
		i.setRank(0.0);
		i.setOwner_id(u.getKey().getId());
		i.setMessages(Collections.<Message> emptyList());
		IslandDAO i_dao = new IslandDAO(Island.class);
		i_dao.create(i);
		return String.valueOf(i.getKey().getId());
	}

	@GET
	@Path("/getall")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public IslandTOWrapper getByDistanceW(
			@QueryParam("longitude") Double longitude,
			@QueryParam("latitude") Double latitude,
			@QueryParam("distance") Double distance,
			@QueryParam("max_results") Integer max_results) {
		// validations
		ValidationUtil.validatesLongitude(longitude);
		ValidationUtil.validatesLatitude(latitude);
		ValidationUtil.validatesDistance(distance);
		// get
		IslandDAO i_dao = new IslandDAO(Island.class);
		List<Island> islands = i_dao.getIslandsByArea(longitude, latitude,
				distance, max_results);
		if (islands.size() == 0) {
			return new IslandTOWrapper();
		}
		List<IslandTO> result = new ArrayList<IslandTO>();
		for (Island i : islands) {
			result.add(new IslandTO(i));
		}
		IslandTOWrapper itw = new IslandTOWrapper();
		itw.setIslands(result);
		return itw;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public IslandTO getById(@QueryParam("id") Long id) {
		IslandDAO i_dao = new IslandDAO(Island.class);
		Island i = i_dao.find(id);
		i_dao.closePersistenceManager();
		return (new IslandTO(i));
	}

}
