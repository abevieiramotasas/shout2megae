package org.shout2me.entity.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.shout2me.jdo.PMF;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public abstract class DAO<E> {
	protected Class<E> classe;
	private static PersistenceManager pm;

	public DAO(Class<E> classe) {
		this.classe = classe;
	}

	public void create(E entity) {
		getPersistenceManager().makePersistent(entity);
	}

	protected PersistenceManager getPersistenceManager() {
		if (pm == null || pm.isClosed()) {
			pm = PMF.get().getPersistenceManager();
		}
		return pm;
	}

	public void closePersistenceManager() {
		if (pm != null && !pm.isClosed()) {
			pm.close();
		}
	}

	public E find(Long id) {
		Key key = KeyFactory.createKey(classe.getSimpleName(), id);
		E entity = getPersistenceManager().getObjectById(classe, key);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		List<E> result = null;
		Query query = getPersistenceManager().newQuery(classe);
		try {
			result = (List<E>) query.execute();
		} finally {
			query.closeAll();
		}
		return result;
	}
}
