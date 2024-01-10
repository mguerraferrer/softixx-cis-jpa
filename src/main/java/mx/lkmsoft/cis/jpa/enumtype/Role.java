package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "Role")
public enum Role {
	ROOT, ADMIN, DOCTOR, NURSE, ASSISTANT, SALES;

	public static Role getValue(String role) {
		try {
			if (StringUtils.hasValue(role)) {
				return Role.valueOf(role);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get Role value from '{}'", role);
		}
		return null;
	}

	public static boolean isValid(String role) {
		return EnumUtils.isValidEnum(Role.class, role);
	}
	
}