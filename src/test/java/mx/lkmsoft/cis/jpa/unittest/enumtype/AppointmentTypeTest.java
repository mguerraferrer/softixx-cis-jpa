package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentType;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link AppointmentType} test class
 *
 * @author Maikel Guerra Ferrer
 */
class AppointmentTypeTest {

    @Test
    void testGetValue() {
        assertEquals(AppointmentType.FIRST, AppointmentType.getValue("FIRST"));
        assertEquals(AppointmentType.SUBSEQUENT, AppointmentType.getValue("SUBSEQUENT"));
        assertNull(AppointmentType.getValue(null));
        assertNull(AppointmentType.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "CONTROL, true",
        "EPISODIC, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = AppointmentType.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
