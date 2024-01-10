package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "AppointmentOrigin")
public enum AppointmentOrigin {
	ONLINE, PHONE, PERSON, CLONED;

	public static AppointmentOrigin getValue(String appointmentOrigin) {
		try {
			if (StringUtils.hasValue(appointmentOrigin)) {
				return AppointmentOrigin.valueOf(appointmentOrigin);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get AppointmentOrigin value from '{}'", appointmentOrigin);
		}
		return null;
	}

	public static boolean isValid(String appointmentOrigin) {
		return EnumUtils.isValidEnum(AppointmentOrigin.class, appointmentOrigin);
	}
	
}