package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.PaymentSource;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link PaymentSource} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PaymentSourceTest {

    @Test
    void testGetValue() {
        assertEquals(PaymentSource.CASH, PaymentSource.getValue("CASH"));
        assertEquals(PaymentSource.CARD, PaymentSource.getValue("CARD"));
        assertNull(PaymentSource.getValue(null));
        assertNull(PaymentSource.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "CARD, true",
        "PAYPAL, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = PaymentSource.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
