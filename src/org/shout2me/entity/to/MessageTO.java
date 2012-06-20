package org.shout2me.entity.to;

import javax.xml.bind.annotation.XmlRootElement;

import org.shout2me.entity.Message;

@XmlRootElement(name = "message")
public class MessageTO {
	private Long message_id;
	private String text;
	private String topic;
	private Long author_id;
	private String author_name;
	private Long date_in_millis;
	private Long destination_id;

	public MessageTO(Message message) {
		this.text = message.getText();
		this.topic = message.getTopic();
		this.author_id = message.getAuthor_id();
		this.author_name = message.getAuthor_name();
		this.date_in_millis = message.getDate_in_millis();
		this.destination_id = message.getDestination().getKey().getId();
		this.message_id = message.getKey().getId();
	}

	public MessageTO() {

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

	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}

	public Long getAuthor_id() {
		return author_id;
	}

	public void setDestination_id(Long destination_id) {
		this.destination_id = destination_id;
	}

	public Long getDestination_id() {
		return destination_id;
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

	public void setMessage_id(Long message_id) {
		this.message_id = message_id;
	}

	public Long getMessage_id() {
		return message_id;
	}

}
