package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentStatus;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link AppointmentStatus} test class
 *
 * @author Maikel Guerra Ferrer
 */
class AppointmentStatusTest {

    @Test
    void testGetValue() {
        assertEquals(AppointmentStatus.CREATED, AppointmentStatus.getValue("CREATED"));
        assertEquals(AppointmentStatus.RESCHEDULED, AppointmentStatus.getValue("RESCHEDULED"));
        assertNull(AppointmentStatus.getValue(null));
        assertNull(AppointmentStatus.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "CONFIRMED, true",
        "COMPLETED, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = AppointmentStatus.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
