package org.shout2me.entity.to;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "islands")
public class IslandTOWrapper {

	private List<IslandTO> islands;

	public IslandTOWrapper() {
		this.islands = new ArrayList<IslandTO>();
	}

	public void setIslands(List<IslandTO> islands) {
		this.islands = islands;
	}

	public List<IslandTO> getIslands() {
		return islands;
	}
}
