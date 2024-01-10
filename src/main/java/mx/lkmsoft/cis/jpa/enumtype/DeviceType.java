package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * Enum representing different types of devices
 * 
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "DeviceType")
public enum DeviceType {
	/**
	 * Represents a mobile device
	 */
	MOBILE,

	/**
	 * Represents a normal (or standard) device, usually a desktop or a laptop
	 */
	NORMAL,

	/**
	 * Represents a tablet device
	 */
	TABLET,

	/**
	 * Represents an unknown type of device
	 */
	UNKNOWN;

	public static DeviceType getValue(String deviceType) {
		try {
			if (StringUtils.hasValue(deviceType)) {
				return DeviceType.valueOf(deviceType);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get DeviceType value from '{}'", deviceType);
		}
		return null;
	}

	public static boolean isValid(String deviceType) {
		return EnumUtils.isValidEnum(DeviceType.class, deviceType);
	}
	
}