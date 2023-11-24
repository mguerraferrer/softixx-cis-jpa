package mx.lkmsoft.cis.jpa.enumtype;

import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum BloodTypeRh {
	A_PLUS, A_NEGATIVE, B_PLUS, B_NEGATIVE, AB_PLUS, AB_NEGATIVE, O_PLUS, O_NEGATIVE;

	public static BloodTypeRh getValue(String bloodTypeRh) {
		if (StringUtils.hasValue(bloodTypeRh)) {
			return BloodTypeRh.valueOf(bloodTypeRh);
		}
		return null;
	}

}