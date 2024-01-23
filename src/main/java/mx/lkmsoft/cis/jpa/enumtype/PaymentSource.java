package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "PaymentSource")
public enum PaymentSource {
	CASH, CARD, SPEI, PAYPAL;

	public static PaymentSource getValue(String paymentSource) {
		try {
			if (StringUtils.hasValue(paymentSource)) {
				return PaymentSource.valueOf(paymentSource);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get PaymentSource value from '{}'", paymentSource);
		}
		return null;
	}

	public static boolean isValid(String paymentSource) {
		return EnumUtils.isValidEnum(PaymentSource.class, paymentSource);
	}
	
}