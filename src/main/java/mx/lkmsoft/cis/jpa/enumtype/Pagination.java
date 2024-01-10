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
@Slf4j(topic = "Pagination")
public enum Pagination {
	P10, P20, P30, P40, P50;
	
	public static String getValue(Pagination pagination) {
		if (AssertUtils.nonNull(pagination)) {
			return pagination.name().substring(1);
		}
		return null;
	}
	
	public static Integer getValue(String pagination) {
		try {
			if (StringUtils.hasValue(pagination)) {
				val enumValue = Pagination.valueOf(pagination);
				return IntegerUtils.valueOf(getValue(enumValue));
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get Pagination value from '{}'", pagination);
		}
		return null;
	}
	
	public static boolean isValid(String pagination) {
		return EnumUtils.isValidEnum(Pagination.class, pagination);
	}
	
}