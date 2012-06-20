package org.shout2me.entity.to;

import javax.xml.bind.annotation.XmlRootElement;

import org.shout2me.entity.Island;

@XmlRootElement(name = "island")
public class IslandTO {
	private String name;
	private String description;
	private Double longitude;
	private Double latitude;
	private Long id;
	private Double rank;

	public IslandTO() {

	}

	public IslandTO(Island island) {
		this.name = island.getName();
		this.description = island.getDescription();
		this.longitude = island.getLongitude();
		this.latitude = island.getLatitude();
		this.id = island.getKey().getId();
		this.rank = island.getRank();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
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

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

	public Double getRank() {
		return rank;
	}

}
