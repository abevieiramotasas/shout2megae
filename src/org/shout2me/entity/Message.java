package org.shout2me.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NullValue;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
@XmlRootElement
public class Message {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent(nullValue = NullValue.EXCEPTION)
	private String text;
	@Persistent(nullValue = NullValue.EXCEPTION)
	private String topic;
	private Long date_in_millis;
	private Long author_id;
	@Persistent(nullValue = NullValue.EXCEPTION)
	private Island destination;
	@Persistent
	private String author_name;

	public Message() {

	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Key getKey() {
		return key;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	public void setDestination(Island destination) {
		this.destination = destination;
	}

	public Island getDestination() {
		return destination;
	}

	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}

	public Long getAuthor_id() {
		return author_id;
	}

	public void setDate_in_millis(Long date_in_millis) {
		this.date_in_millis = date_in_millis;
	}

	public Long getDate_in_millis() {
		return date_in_millis;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getAuthor_name() {
		return author_name;
	}
}
