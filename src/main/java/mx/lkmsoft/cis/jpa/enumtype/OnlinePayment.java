package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "OnlinePayment")
public enum OnlinePayment {
	STRIPE, OPENPAY;

	public static OnlinePayment getValue(String onlinePayment) {
		try {
			if (StringUtils.hasValue(onlinePayment)) {
				return OnlinePayment.valueOf(onlinePayment);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get OnlinePayment value from '{}'", onlinePayment);
		}
		return null;
	}

	public static boolean isValid(String onlinePayment) {
		return EnumUtils.isValidEnum(OnlinePayment.class, onlinePayment);
	}
	
}