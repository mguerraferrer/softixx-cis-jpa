package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "BloodTypeRh")
public enum BloodTypeRh {
	A_PLUS, A_NEGATIVE, B_PLUS, B_NEGATIVE, AB_PLUS, AB_NEGATIVE, O_PLUS, O_NEGATIVE;

	public static BloodTypeRh getValue(String bloodTypeRh) {
		try {
			if (StringUtils.hasValue(bloodTypeRh)) {
				return BloodTypeRh.valueOf(bloodTypeRh);
			}
		} catch (IllegalArgumentException e) {
			log.error("Get enum value error: {}", e.getMessage());
		}
		return null;
	}

	public static boolean isValid(String bloodTypeRh) {
		return EnumUtils.isValidEnum(BloodTypeRh.class, bloodTypeRh);
	}
}