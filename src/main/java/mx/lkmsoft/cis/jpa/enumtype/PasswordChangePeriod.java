package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import mx.lkmsoft.cis.common.assertion.AssertUtils;
import org.apache.commons.lang3.EnumUtils;

import mx.lkmsoft.cis.common.data.IntegerUtils;
import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "PasswordChangePeriod")
public enum PasswordChangePeriod {
	P1, P3, P6;
	
	public static Integer getValue(PasswordChangePeriod period) {
		if (AssertUtils.nonNull(period)) {
			return IntegerUtils.valueOf(period.name().substring(1));
		}
		return null;
	}
	
	public static Integer getValue(String period) {
		try {
			if (StringUtils.hasValue(period)) {
				val enumValue = PasswordChangePeriod.valueOf(period);
				return IntegerUtils.valueOf(getValue(enumValue));
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get PasswordChangePeriod value from '{}'", period);
		}
		return null;
	}
	
	public static boolean isValid(String period) {
		return EnumUtils.isValidEnum(PasswordChangePeriod.class, period);
	}
}