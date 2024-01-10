package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "AccessLevel")
public enum AccessLevel {
	RESTRICTED, CONFIG, FULL;

	public static AccessLevel getValue(String accessLevel) {
		try {
			if (StringUtils.hasValue(accessLevel)) {
				return AccessLevel.valueOf(accessLevel);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get AccessLevel value from '{}'", accessLevel);
		}
		return null;
	}

	public static boolean isValid(String accessLevel) {
		return EnumUtils.isValidEnum(AccessLevel.class, accessLevel);
	}
}