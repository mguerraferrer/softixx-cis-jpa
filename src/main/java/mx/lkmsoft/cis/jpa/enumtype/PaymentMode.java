package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

import java.util.List;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "PaymentMode")
public enum PaymentMode {
	MONTHLY, QUARTERLY, BIYEARLY, YEARLY;

	public static PaymentMode getValue(String paymentMode) {
		try {
			if (StringUtils.hasValue(paymentMode)) {
				return PaymentMode.valueOf(paymentMode);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get PaymentMode value from '{}'", paymentMode);
		}
		return null;
	}

	public static PaymentMode getSafeValue(String paymentMode) {
		val enumValue = getValue(paymentMode);
		if (enumValue == null) {
			return PaymentMode.MONTHLY;
		}
		return enumValue;
	}

	public static Integer getNumericValue(String paymentMode) {
		val paymentModeEnum = getValue(paymentMode);
		return getNumericValue(paymentModeEnum);
	}

	public static Integer getNumericValue(PaymentMode paymentMode) {
		return switch (paymentMode) {
			case MONTHLY -> 1;
			case QUARTERLY -> 3;
			case BIYEARLY -> 6;
			case YEARLY -> 12;
			case null -> 1;
		};
	}

	public static String getI18nValue(PaymentMode paymentMode) {
		return switch (paymentMode) {
			case MONTHLY -> "payment.mode.monthly";
			case QUARTERLY -> "payment.mode.quarterly";
			case BIYEARLY -> "payment.mode.biyearly";
			case YEARLY -> "payment.mode.yearly";
		};
	}

	public static boolean isValid(String paymentMode) {
		return EnumUtils.isValidEnum(PaymentMode.class, paymentMode);
	}

}