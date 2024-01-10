package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentCancelled;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link AppointmentCancelled} test class
 *
 * @author Maikel Guerra Ferrer
 */
class AppointmentCancelledTest {

    @Test
    void testGetValue() {
        assertEquals(AppointmentCancelled.AGENDA, AppointmentCancelled.getValue("AGENDA"));
        assertEquals(AppointmentCancelled.EXCEPTIONAL_DAY, AppointmentCancelled.getValue("EXCEPTIONAL_DAY"));
        assertNull(AppointmentCancelled.getValue(null));
        assertNull(AppointmentCancelled.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "ONLINE, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = AppointmentCancelled.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
