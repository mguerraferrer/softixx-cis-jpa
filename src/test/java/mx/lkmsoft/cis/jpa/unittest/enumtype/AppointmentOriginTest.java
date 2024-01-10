package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentOrigin;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link AppointmentOrigin} test class
 *
 * @author Maikel Guerra Ferrer
 */
class AppointmentOriginTest {

    @Test
    void testGetValue() {
        assertEquals(AppointmentOrigin.ONLINE, AppointmentOrigin.getValue("ONLINE"));
        assertEquals(AppointmentOrigin.PHONE, AppointmentOrigin.getValue("PHONE"));
        assertNull(AppointmentOrigin.getValue(null));
        assertNull(AppointmentOrigin.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "PERSON, true",
        "CLONED, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = AppointmentOrigin.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
