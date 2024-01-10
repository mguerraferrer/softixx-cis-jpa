package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "AppointmentReschedule")
public enum AppointmentReschedule {
	AGENDA, OTHER_DOCTOR;

	public static AppointmentReschedule getValue(String appointmentReschedule) {
		try {
			if (StringUtils.hasValue(appointmentReschedule)) {
				return AppointmentReschedule.valueOf(appointmentReschedule);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get AppointmentReschedule value from '{}'", appointmentReschedule);
		}
		return null;
	}

	public static boolean isValid(String appointmentReschedule) {
		return EnumUtils.isValidEnum(AppointmentReschedule.class, appointmentReschedule);
	}
	
}