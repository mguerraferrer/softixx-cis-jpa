package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.PasswordChangePeriod;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link PasswordChangePeriod} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PasswordChangePeriodTest {

    @Test
    void testGetValue() {
        assertEquals(1, PasswordChangePeriod.getValue(PasswordChangePeriod.P1));
        assertEquals(3, PasswordChangePeriod.getValue(PasswordChangePeriod.P3));
        assertEquals(6, PasswordChangePeriod.getValue("P6"));
        assertNull(PasswordChangePeriod.getValue(DataTest.NULLABLE_ST));
        assertNull(PasswordChangePeriod.getValue((PasswordChangePeriod) null));
        assertNull(PasswordChangePeriod.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "P6, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = PasswordChangePeriod.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
