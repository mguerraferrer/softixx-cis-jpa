package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "AppointmentStatus")
public enum AppointmentStatus {
	CREATED, CONFIRMED, COMPLETED, CANCELLED, RESCHEDULED;

	public static AppointmentStatus getValue(String status) {
		try {
			if (StringUtils.hasValue(status)) {
				return AppointmentStatus.valueOf(status);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get AppointmentStatus value from '{}'", status);
		}
		return null;
	}

	public static boolean isValid(String status) {
		return EnumUtils.isValidEnum(AppointmentStatus.class, status);
	}

}