package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "NotificationMethod")
public enum NotificationMethod {
	EMAIL, SMS, WHATSAPP;

	public static NotificationMethod getValue(String notificationMethod) {
		try {
			if (StringUtils.hasValue(notificationMethod)) {
				return NotificationMethod.valueOf(notificationMethod);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get NotificationMethod value from '{}'", notificationMethod);
		}
		return null;
	}
	
	public static boolean isValid(String notificationMethod) {
		return EnumUtils.isValidEnum(NotificationMethod.class, notificationMethod);
	}

}