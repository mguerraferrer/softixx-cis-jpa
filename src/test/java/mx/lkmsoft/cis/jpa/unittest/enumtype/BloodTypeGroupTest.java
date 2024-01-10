package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.BloodTypeGroup;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link BloodTypeGroup} test class
 *
 * @author Maikel Guerra Ferrer
 */
class BloodTypeGroupTest {

    @Test
    void testGetValue() {
        assertEquals(BloodTypeGroup.A, BloodTypeGroup.getValue("A"));
        assertEquals(BloodTypeGroup.AB, BloodTypeGroup.getValue("AB"));
        assertNull(BloodTypeGroup.getValue(null));
        assertNull(BloodTypeGroup.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "B, true",
        "O, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = BloodTypeGroup.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
