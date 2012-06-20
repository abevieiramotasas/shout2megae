package org.shout2me.service.util;

import org.shout2me.entity.User;
import org.shout2me.entity.dao.UserDAO;
import org.shout2me.service.exception.ValidationException;

public class ValidationUtil {
	// TODO alterar validações regex, lembrar dos docs
	private final static String regex_mail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$";
	private final static String regex_user_name = "^[A-Z ]{4,30}$";
	private final static String regex_description = "^.{5,400}$";
	private final static String regex_password = "^.{5,12}$";
	private final static String regex_text = "^.{5,1000}$";
	private final static String regex_topic = "^.{2,100}$";
	private final static String regex_island_name = "^.{5,30}$";

	public static void validatesMail(String mail) {
		if (!mail.toUpperCase().matches(regex_mail)) {
			throw new ValidationException(ValidationErrors.INVALID,
					ValidationFields.MAIL);
		}
	}

	public static void validatesUserName(String name) {
		if (!name.toUpperCase().matches(regex_user_name)) {
			throw new ValidationException(ValidationErrors.INVALID,
					ValidationFields.USER_NAME);
		}
	}

	public static void validatesDescription(String description) {
		if (!description.toUpperCase().matches(regex_description)) {
			throw new ValidationException(ValidationErrors.INVALID,
					ValidationFields.DESCRIPTION);
		}

	}

	public static void validatesPassword(String password) {
		if (!password.toUpperCase().matches(regex_password)) {
			throw new ValidationException(ValidationErrors.INVALID,
					ValidationFields.PASSWORD);
		}
	}

	public static void validatesText(String text) {
		if (!text.toUpperCase().matches(regex_text)) {
			throw new ValidationException(ValidationErrors.INVALID,
					ValidationFields.TEXT);
		}
	}

	public static void validatesTopic(String topic) {
		if (!topic.toUpperCase().matches(regex_topic)) {
			throw new ValidationException(ValidationErrors.INVALID,
					ValidationFields.TOPIC);
		}
	}

	public static void validatesIslandName(String name) {
		if (!name.toUpperCase().matches(regex_island_name)) {
			throw new ValidationException(ValidationErrors.INVALID,
					ValidationFields.ISLAND_NAME);
		}
	}

	public static void validatesDouble(Double value,
			ValidationFields validationField) {
		if (value == null) {
			throw new ValidationException(ValidationErrors.INVALID,
					validationField);
		}
	}

	public static void validatesLongitude(Double longitude) {
		validatesDouble(longitude, ValidationFields.LONGITUDE);
	}

	public static void validatesLatitude(Double latitude) {
		validatesDouble(latitude, ValidationFields.LATITUDE);
	}

	public static void validatesUserFound(User u) {
		if (u == null) {
			throw new ValidationException(ValidationErrors.NOTFOUND,
					ValidationFields.USER);
		}

	}

	public static void validatesDistance(Double distance) {
		validatesDouble(distance, ValidationFields.DISTANCE);
	}

	public static void validatesNotExistsMail(String mail) {
		if ((new UserDAO(User.class)).findByMail(mail) != null) {
			throw new ValidationException(ValidationErrors.ALREADY_EXISTS,
					ValidationFields.MAIL);
		}
	}

	public static User validatesExistsMail(String mail) {
		User u = (new UserDAO(User.class)).findByMail(mail);
		if (u == null) {
			throw new ValidationException(ValidationErrors.NOTFOUND,
					ValidationFields.MAIL);
		}
		return u;
	}
}
