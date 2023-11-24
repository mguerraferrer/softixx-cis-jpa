package mx.lkmsoft.cis.jpa.enumtype;

import org.apache.commons.lang3.EnumUtils;

import mx.lkmsoft.cis.common.data.IntegerUtils;
import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum PasswordChangePeriod {
	P1, P3, P6;
	
	public static Integer getValue(PasswordChangePeriod period) {
		return IntegerUtils.valueOf(period.name().substring(1));
	}
	
	public static Integer getValue(String period) {
		if (StringUtils.hasValue(period)) {
			return IntegerUtils.valueOf(period.substring(1));
		}
		return null;
	}
	
	public static boolean isValid(String period) {
		return EnumUtils.isValidEnum(PasswordChangePeriod.class, period);
	}
}