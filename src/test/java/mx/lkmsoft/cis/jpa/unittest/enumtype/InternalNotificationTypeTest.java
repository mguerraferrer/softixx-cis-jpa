package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.InternalNotificationType;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link InternalNotificationType} test class
 *
 * @author Maikel Guerra Ferrer
 */
class InternalNotificationTypeTest {

    @Test
    void testGetValue() {
        assertEquals(InternalNotificationType.PLANNING, InternalNotificationType.getValue("PLANNING"));
        assertEquals(InternalNotificationType.APPOINTMENT_RESCHEDULE, InternalNotificationType.getValue("APPOINTMENT_RESCHEDULE"));
        assertNull(InternalNotificationType.getValue(null));
        assertNull(InternalNotificationType.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "APPOINTMENT_NEW, true",
        "APPOINTMENT_CONFIRMATION, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = InternalNotificationType.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
