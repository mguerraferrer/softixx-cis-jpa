package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentReschedule;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link AppointmentReschedule} test class
 *
 * @author Maikel Guerra Ferrer
 */
class AppointmentRescheduleTest {

    @Test
    void testGetValue() {
        assertEquals(AppointmentReschedule.AGENDA, AppointmentReschedule.getValue("AGENDA"));
        assertEquals(AppointmentReschedule.OTHER_DOCTOR, AppointmentReschedule.getValue("OTHER_DOCTOR"));
        assertNull(AppointmentReschedule.getValue(null));
        assertNull(AppointmentReschedule.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "AGENDA, true",
        "OTHER_DOCTOR, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = AppointmentReschedule.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
