package mx.lkmsoft.cis.jpa.enumtype;

import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum NotificationMethod {
	EMAIL, SMS, WHATSAPP;
	
	public static boolean isValid(String notificationMethod) {
		return EnumUtils.isValidEnum(NotificationMethod.class, notificationMethod);
	}

}