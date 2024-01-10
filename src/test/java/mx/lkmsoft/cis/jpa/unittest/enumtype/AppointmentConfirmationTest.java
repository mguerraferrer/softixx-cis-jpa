package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentConfirmation;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link AppointmentConfirmation} test class
 *
 * @author Maikel Guerra Ferrer
 */
class AppointmentConfirmationTest {

    @Test
    void testGetValue() {
        assertEquals(AppointmentConfirmation.UNCONFIRMED, AppointmentConfirmation.getValue("UNCONFIRMED"));
        assertEquals(AppointmentConfirmation.PERSON, AppointmentConfirmation.getValue("PERSON"));
        assertNull(AppointmentConfirmation.getValue(null));
        assertNull(AppointmentConfirmation.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "ONLINE, true",
        "PHONE, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = AppointmentConfirmation.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
