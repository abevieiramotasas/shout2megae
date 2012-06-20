package org.shout2me.service.util;

import java.util.StringTokenizer;

import org.shout2me.entity.User;
import org.shout2me.entity.dao.UserDAO;
import org.shout2me.jdo.util.EncryptUtil;
import org.shout2me.service.exception.NotLoggedException;

public class KeyUtil {
	public static String makeKey(String value, String salt) {
		StringBuffer sb = new StringBuffer();
		sb.append(value);
		sb.append('|');
		sb.append(EncryptUtil.makeHashed(value, salt));
		return sb.toString();
	}

	public static Boolean verifyKey(String key_value, String salt) {
		StringTokenizer st = new StringTokenizer(key_value, "|");
		if (st.countTokens() != 2) {
			return false;
		}
		String value = st.nextToken();
		String hashed = st.nextToken();
		if (hashed.equals(EncryptUtil.makeHashed(value, salt))) {
			return true;
		}
		return false;
	}

	public static String getClearSide(String key_value) {
		StringTokenizer st = new StringTokenizer(key_value, "|");
		if (st.countTokens() != 2) {
			return null;
		}
		return st.nextToken();
	}

	public static User getUserByKey(String key_value) {
		if (key_value == null) {
			throw new NotLoggedException();
		}
		String user_id_step_one = KeyUtil.getClearSide(key_value);
		if (user_id_step_one == null) {
			throw new NotLoggedException();
		}
		UserDAO u_dao = new UserDAO(User.class);
		User u = u_dao.find(Long.parseLong(user_id_step_one));
		if (!KeyUtil.verifyKey(key_value, u.getSalt())) {
			throw new NotLoggedException();
		}
		return u;
	}
}
