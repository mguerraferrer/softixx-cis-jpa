package mx.lkmsoft.cis.jpa.enumtype;

import org.apache.commons.lang3.EnumUtils;

import mx.lkmsoft.cis.common.data.IntegerUtils;
import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum Pagination {
	P10, P20, P30, P40, P50;
	
	public static String getValue(Pagination pagination) {
		return pagination.name().substring(1);
	}
	
	public static Integer getValue(String pagination) {
		if (StringUtils.hasValue(pagination)) {
			return IntegerUtils.valueOf(pagination.substring(1));
		}
		return null;
	}
	
	public static boolean isValid(String pagination) {
		return EnumUtils.isValidEnum(Pagination.class, pagination);
	}
	
}