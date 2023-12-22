package mx.lkmsoft.cis.jpa.enumtype;

import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum InternalNotificationType {
	PLANNING, APPOINTMENT_NEW, APPOINTMENT_CANCELLATION, APPOINTMENT_CONFIRMATION, APPOINTMENT_EDIT,
	APPOINTMENT_RESCHEDULE;

	public static boolean isValid(String notificationType) {
		return EnumUtils.isValidEnum(InternalNotificationType.class, notificationType);
	}

}