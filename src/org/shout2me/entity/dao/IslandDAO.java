package org.shout2me.entity.dao;

import java.util.ArrayList;
import java.util.List;

import org.shout2me.entity.Island;
import org.shout2me.entity.Message;

import com.beoui.geocell.GeocellManager;
import com.beoui.geocell.model.GeocellQuery;
import com.beoui.geocell.model.Point;

public class IslandDAO extends DAO<Island> {

	public IslandDAO(Class<Island> classe) {
		super(classe);
	}

	public List<Island> getIslandsByArea(Double longitude, Double latitude,
			Double distance, Integer maxResults) {
		Point center = new Point(latitude, longitude);
		GeocellQuery query = new GeocellQuery();
		List<Island> islands = null;
		islands = GeocellManager.proximitySearch(center, maxResults, distance,
				Island.class, query, getPersistenceManager());
		return islands;
	}

	@Override
	public void create(Island island) {
		island.setCells(GeocellManager.generateGeoCell(new Point(island
				.getLatitude(), island.getLongitude())));
		super.create(island);
	}

	public List<Message> getMessages(Long destination_id, Integer limit,
			Long base_date_in_millis, Boolean up) {
		List<Message> messages = find(destination_id).getMessages();
		List<Message> result = null;
		// lista nula, vazia, ou serviço deve retornar todos
		if (messages == null || messages.size() == 0 || limit == 0
				|| base_date_in_millis == null) {
			return messages;
		}
		int i = 0;
		result = new ArrayList<Message>();
		for (; i < messages.size(); i++) {
			if (base_date_in_millis > messages.get(i).getDate_in_millis()) {
				break;
			}
		}
		if (up) {
			while (limit-- > 0 && --i >= 0) {
				result.add(messages.get(i));
			}
		} else {
			while (limit-- > 0 && ++i < messages.size()) {
				result.add(messages.get(i));
			}
		}
		return result;
	}
}
