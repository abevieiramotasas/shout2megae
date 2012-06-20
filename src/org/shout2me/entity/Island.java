package org.shout2me.entity;

import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NullValue;
import javax.jdo.annotations.Order;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.beoui.geocell.annotations.Geocells;
import com.beoui.geocell.annotations.Latitude;
import com.beoui.geocell.annotations.Longitude;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Island {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent(nullValue = NullValue.EXCEPTION)
	private String name;
	@Persistent(nullValue = NullValue.EXCEPTION)
	@Longitude
	private Double longitude;
	@Persistent(nullValue = NullValue.EXCEPTION)
	@Latitude
	private Double latitude;
	@Persistent(nullValue = NullValue.EXCEPTION)
	private String description;
	@Persistent(mappedBy = "destination")
	@Order(extensions = @Extension(vendorName = "datanucleus", key = "list-ordering", value = "date_in_millis desc"))
	private List<Message> messages;
	@Persistent(nullValue = NullValue.EXCEPTION)
	private Long owner_id;
	@Persistent
	@Geocells
	private List<String> cells;
	@Persistent
	private Double rank;

	public Island() {

	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Key getKey() {
		return key;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

	public Double getRank() {
		return rank;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}

	public Long getOwner_id() {
		return owner_id;
	}

	public void setCells(List<String> cells) {
		this.cells = cells;
	}

	public List<String> getCells() {
		return cells;
	}
}
