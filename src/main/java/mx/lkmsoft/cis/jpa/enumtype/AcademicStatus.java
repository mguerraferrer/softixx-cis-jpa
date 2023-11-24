package mx.lkmsoft.cis.jpa.enumtype;

import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum AcademicStatus {
	DAYCARE, NURSERY, KINDER_I, KINDER_II, PRE_FIRST, PRE_PRIMARY, PRIMARY, SECONDARY, COMMERCIAL,
	HIGH_SCHOOL, HIGHER_TECHNICAL, BACHELOR_DEGREE, ENGINEERING, POSTGRADUATE, STUDYING, NO_EDUCATION;

	public static AcademicStatus getValue(String academicStatus) {
		if (StringUtils.hasValue(academicStatus)) {
			return AcademicStatus.valueOf(academicStatus);
		}
		return null;
	}

}