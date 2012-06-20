package org.shout2me.entity.to;

import javax.xml.bind.annotation.XmlRootElement;

import org.shout2me.entity.User;

@XmlRootElement(name = "user")
public class UserTO {
	private String name;
	private String description;
	private Long id;

	public UserTO() {
	}

	public UserTO(User user) {
		this.name = user.getName();
		this.description = user.getDescription();
		this.id = user.getKey().getId();
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

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
