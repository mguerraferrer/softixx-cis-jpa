package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "AcademicStatus")
public enum AcademicStatus {
	DAYCARE, NURSERY, KINDER_I, KINDER_II, PRE_FIRST, PRE_PRIMARY, PRIMARY, SECONDARY, COMMERCIAL,
	HIGH_SCHOOL, HIGHER_TECHNICAL, BACHELOR_DEGREE, ENGINEERING, POSTGRADUATE, STUDYING, NO_EDUCATION;

	public static AcademicStatus getValue(String academicStatus) {
		try {
			if (StringUtils.hasValue(academicStatus)) {
				return AcademicStatus.valueOf(academicStatus);
			}
		} catch (IllegalArgumentException e) {
			log.error("Get enum value error: {}", e.getMessage());
		}
		return null;
	}

	public static boolean isValid(String academicStatus) {
		return EnumUtils.isValidEnum(AcademicStatus.class, academicStatus);
	}
}