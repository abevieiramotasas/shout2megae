package org.shout2me.entity.to;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {

	private JAXBContext context;
	private Class<?>[] types = { IslandTOWrapper.class, MessageTOWrapper.class };

	public JAXBContextResolver() throws JAXBException {
		// configuracao de arrays para retornar com notacao de array json
		// '[...]' para array com um elemento
		this.context = new JSONJAXBContext(JSONConfiguration.mapped()
				.arrays("islands").arrays("messages").build(), types);
	}

	@Override
	public JAXBContext getContext(Class<?> objectType) {
		for (Class<?> type : types) {
			if (type == objectType) {
				return context;
			}
		}
		return null;
	}

}
