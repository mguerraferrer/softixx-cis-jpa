package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.OnlinePayment;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link OnlinePayment} test class
 *
 * @author Maikel Guerra Ferrer
 */
class OnlinePaymentTest {

    @Test
    void testGetValue() {
        assertEquals(OnlinePayment.STRIPE, OnlinePayment.getValue("STRIPE"));
        assertEquals(OnlinePayment.OPENPAY, OnlinePayment.getValue("OPENPAY"));
        assertNull(OnlinePayment.getValue(null));
        assertNull(OnlinePayment.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "STRIPE, true",
        "OPENPAY, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = OnlinePayment.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
