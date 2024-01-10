package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.PaymentMode;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link PaymentMode} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PaymentModeTest {

    @Test
    void testGetValue() {
        assertEquals(PaymentMode.MONTHLY, PaymentMode.getValue("MONTHLY"));
        assertEquals(PaymentMode.QUARTERLY, PaymentMode.getValue("QUARTERLY"));
        assertNull(PaymentMode.getValue(null));
        assertNull(PaymentMode.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "BIYEARLY, true",
        "YEARLY, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = PaymentMode.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
