package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "AppointmentType")
public enum AppointmentType {
	FIRST, SUBSEQUENT, CONTROL, EPISODIC;

	public static AppointmentType getValue(String appointmentType) {
		try {
			if (StringUtils.hasValue(appointmentType)) {
				return AppointmentType.valueOf(appointmentType);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get AppointmentType value from '{}'", appointmentType);
		}
		return null;
	}

	public static boolean isValid(String appointmentType) {
		return EnumUtils.isValidEnum(AppointmentType.class, appointmentType);
	}

}