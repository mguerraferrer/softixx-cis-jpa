package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "InternalNotificationType")
public enum InternalNotificationType {
	PLANNING, APPOINTMENT_NEW, APPOINTMENT_CANCELLATION, APPOINTMENT_CONFIRMATION, APPOINTMENT_EDIT,
	APPOINTMENT_RESCHEDULE;

	public static InternalNotificationType getValue(String notificationType) {
		try {
			if (StringUtils.hasValue(notificationType)) {
				return InternalNotificationType.valueOf(notificationType);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get InternalNotificationType value from '{}'", notificationType);
		}
		return null;
	}

	public static boolean isValid(String notificationType) {
		return EnumUtils.isValidEnum(InternalNotificationType.class, notificationType);
	}

}