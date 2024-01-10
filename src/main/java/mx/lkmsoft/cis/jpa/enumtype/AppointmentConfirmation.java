package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "AppointmentConfirmation")
public enum AppointmentConfirmation {
	UNCONFIRMED, ONLINE, PHONE, PERSON;

	public static AppointmentConfirmation getValue(String confirmation) {
		try {
			if (StringUtils.hasValue(confirmation)) {
				return AppointmentConfirmation.valueOf(confirmation);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get AppointmentConfirmation value from '{}'", confirmation);
		}
		return null;
	}

	public static boolean isValid(String confirmation) {
		return EnumUtils.isValidEnum(AppointmentConfirmation.class, confirmation);
	}
}