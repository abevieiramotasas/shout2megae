package org.shout2me.entity.to;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messages")
public class MessageTOWrapper {

	private List<MessageTO> messages;

	public void setMessages(List<MessageTO> messages) {
		this.messages = messages;
	}

	public List<MessageTO> getMessages() {
		return messages;
	}

}
