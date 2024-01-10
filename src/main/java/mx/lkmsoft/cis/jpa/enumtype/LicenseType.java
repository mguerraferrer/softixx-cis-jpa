package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "LicenseType")
public enum LicenseType {
	DEMO, CLASSIC, MASTER, PREMIUM, GOLD, PLATINUM, BLACK;

	public static LicenseType getValue(String licenseType) {
		try {
			if (StringUtils.hasValue(licenseType)) {
				return LicenseType.valueOf(licenseType);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get LicenseType value from '{}'", licenseType);
		}
		return null;
	}

	public static boolean isValid(String licenseType) {
		return EnumUtils.isValidEnum(LicenseType.class, licenseType);
	}
	
}