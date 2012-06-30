package org.shout2me.entity.to;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {

	private JAXBContext contextBadger;
	private JAXBContext contextNatural;
	private Class<?>[] types = { IslandTOWrapper.class };
	private Class<?>[] islandTO = { IslandTO.class };

	public JAXBContextResolver() throws JAXBException {
		this.context = new JSONJAXBContext(JSONConfiguration.badgerFish()
				.build(), types);
		this.contextNatural = new JSONJAXBContext(JSONConfiguration.natural().build(), islandTO);
	}

	@Override
	public JAXBContext getContext(Class<?> objectType) {
		for (Class<?> type : types) {
			if (type == objectType) {
				return context;
			}
		}
		if(objectType == IslandTO.class) {
			return contextNatural;
		}
		return contextNatural;
	}

}
