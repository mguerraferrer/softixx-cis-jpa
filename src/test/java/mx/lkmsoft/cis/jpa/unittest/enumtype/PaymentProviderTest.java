package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.PaymentProvider;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link PaymentProvider} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PaymentProviderTest {

    @Test
    void testGetValue() {
        assertEquals(PaymentProvider.STRIPE, PaymentProvider.getValue("STRIPE"));
        assertEquals(PaymentProvider.PAYPAL, PaymentProvider.getValue("PAYPAL"));
        assertNull(PaymentProvider.getValue(null));
        assertNull(PaymentProvider.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "STRIPE, true",
        "PAYPAL, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = PaymentProvider.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
