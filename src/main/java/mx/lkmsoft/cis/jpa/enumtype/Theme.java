package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "Theme")
public enum Theme {
	PRIMARY, GREEN, YELLOW, RED, GRAY;

	public static Theme getValue(String theme) {
		try {
			if (StringUtils.hasValue(theme)) {
				return Theme.valueOf(theme);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get Theme value from '{}'", theme);
		}
		return null;
	}

	public static boolean isValid(String theme) {
		return EnumUtils.isValidEnum(Theme.class, theme);
	}
}