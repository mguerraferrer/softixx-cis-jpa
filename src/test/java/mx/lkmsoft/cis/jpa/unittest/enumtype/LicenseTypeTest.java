package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.LicenseType;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link LicenseType} test class
 *
 * @author Maikel Guerra Ferrer
 */
class LicenseTypeTest {

    @Test
    void testGetValue() {
        assertEquals(LicenseType.CLASSIC, LicenseType.getValue("CLASSIC"));
        assertEquals(LicenseType.MASTER, LicenseType.getValue("MASTER"));
        assertNull(LicenseType.getValue(null));
        assertNull(LicenseType.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "PREMIUM, true",
        "GOLD, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = LicenseType.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
