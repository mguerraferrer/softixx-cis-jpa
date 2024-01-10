package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.NotificationMethod;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link NotificationMethod} test class
 *
 * @author Maikel Guerra Ferrer
 */
class NotificationMethodTest {

    @Test
    void testGetValue() {
        assertEquals(NotificationMethod.EMAIL, NotificationMethod.getValue("EMAIL"));
        assertEquals(NotificationMethod.SMS, NotificationMethod.getValue("SMS"));
        assertNull(NotificationMethod.getValue(null));
        assertNull(NotificationMethod.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "WHATSAPP, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = NotificationMethod.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
