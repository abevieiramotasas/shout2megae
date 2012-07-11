package org.shout2me.entity.dao;

import java.util.List;

import javax.jdo.Query;

import org.shout2me.entity.User;

public class UserDAO extends DAO<User> {

	public UserDAO(Class<User> classe) {
		super(classe);
	}

	@SuppressWarnings("unchecked")
	public User findByMail(String mail) {
		Query query = getQuery();
		query.setFilter("mail == mail_user");
		query.declareParameters("String mail_user");
		List<User> result = (List<User>) query.execute(mail);
		if (result == null || result.size() == 0) {
			return null;
		}
		return result.get(0);
	}

}
