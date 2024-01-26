package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "PaymentProvider")
public enum PaymentProvider {
	STRIPE, PAYPAL;

	public static PaymentProvider getValue(String onlinePayment) {
		try {
			if (StringUtils.hasValue(onlinePayment)) {
				return PaymentProvider.valueOf(onlinePayment);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get PaymentProvider value from '{}'", onlinePayment);
		}
		return null;
	}

	public static boolean isValid(String onlinePayment) {
		return EnumUtils.isValidEnum(PaymentProvider.class, onlinePayment);
	}
	
}