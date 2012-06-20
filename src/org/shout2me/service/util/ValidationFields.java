package org.shout2me.service.util;

public enum ValidationFields {
	MAIL("mail"), USER_NAME("user name"), DESCRIPTION("description"), PASSWORD(
			"password"), TEXT("text"), TOPIC("topic"), ISLAND_NAME(
			"island name"), LONGITUDE("longitude"), LATITUDE("latitude"), USER(
			"user"), DISTANCE("distance"), EMPTY_FIELD("");

	private String message;

	private ValidationFields(String message) {
		this.setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
