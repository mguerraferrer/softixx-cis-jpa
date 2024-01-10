package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.DeviceType;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link DeviceType} test class
 *
 * @author Maikel Guerra Ferrer
 */
class DeviceTypeTest {

    @Test
    void testGetValue() {
        assertEquals(DeviceType.MOBILE, DeviceType.getValue("MOBILE"));
        assertEquals(DeviceType.TABLET, DeviceType.getValue("TABLET"));
        assertNull(DeviceType.getValue(null));
        assertNull(DeviceType.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "NORMAL, true",
        "UNKNOWN, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = DeviceType.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
