package mx.lkmsoft.cis.jpa.enumtype;

import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum InternalNotificationType {
	APPOINTMENT;

	public static boolean isValid(String notificationType) {
		return EnumUtils.isValidEnum(InternalNotificationType.class, notificationType);
	}

}