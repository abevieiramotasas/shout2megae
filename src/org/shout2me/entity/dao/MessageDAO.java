package org.shout2me.entity.dao;

import java.util.Calendar;

import javax.jdo.Transaction;

import org.shout2me.entity.Island;
import org.shout2me.entity.Message;

public class MessageDAO extends DAO<Message> {

	public MessageDAO(Class<Message> classe) {
		super(classe);
	}

	public void addMessage(Message message, Long destination_id) {
		IslandDAO i_dao = new IslandDAO(Island.class);
		Island i = i_dao.find(destination_id);
		message.setDestination(i);
		message.setDate_in_millis(Calendar.getInstance().getTime().getTime());
		Transaction tx = null;
		try {
			tx = getPersistenceManager().currentTransaction();
			tx.begin();
			create(message);
			i.getMessages().add(message);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}
}
