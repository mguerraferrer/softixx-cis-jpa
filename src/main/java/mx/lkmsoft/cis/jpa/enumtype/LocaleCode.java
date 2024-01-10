package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "LocaleCode")
public enum LocaleCode {
	ES_MX, EN_US;

	public static LocaleCode getValue(String localeCode) {
		try {
			if (StringUtils.hasValue(localeCode)) {
				return LocaleCode.valueOf(localeCode);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get LocaleCode value from '{}'", localeCode);
		}
		return null;
	}

	public static boolean isValid(String localeCode) {
		return EnumUtils.isValidEnum(LocaleCode.class, localeCode);
	}
	
}