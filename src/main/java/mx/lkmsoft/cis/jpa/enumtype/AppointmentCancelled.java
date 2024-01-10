package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "AppointmentCancelled")
public enum AppointmentCancelled {
	AGENDA, EXCEPTIONAL_DAY, ONLINE;

	public static AppointmentCancelled getValue(String appointmentCancelled) {
		try {
			if (StringUtils.hasValue(appointmentCancelled)) {
				return AppointmentCancelled.valueOf(appointmentCancelled);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get AppointmentCancelled value from '{}'", appointmentCancelled);
		}
		return null;
	}

	public static boolean isValid(String appointmentCancelled) {
		return EnumUtils.isValidEnum(AppointmentCancelled.class, appointmentCancelled);
	}
	
}