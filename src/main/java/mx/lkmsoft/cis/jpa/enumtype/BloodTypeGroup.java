package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "BloodTypeGroup")
public enum BloodTypeGroup {
	A, B, AB, O;

	public static BloodTypeGroup getValue(String bloodTypeGroup) {
		try {
			if (StringUtils.hasValue(bloodTypeGroup)) {
				return BloodTypeGroup.valueOf(bloodTypeGroup);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get BloodTypeGroup value from '{}'", bloodTypeGroup);
		}
		return null;
	}

	public static boolean isValid(String bloodTypeGroup) {
		return EnumUtils.isValidEnum(BloodTypeGroup.class, bloodTypeGroup);
	}
	
}