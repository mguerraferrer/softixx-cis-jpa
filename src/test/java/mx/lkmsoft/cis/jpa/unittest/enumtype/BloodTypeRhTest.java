package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.BloodTypeRh;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link BloodTypeRh} test class
 *
 * @author Maikel Guerra Ferrer
 */
class BloodTypeRhTest {

    @Test
    void testGetValue() {
        assertEquals(BloodTypeRh.A_PLUS, BloodTypeRh.getValue("A_PLUS"));
        assertEquals(BloodTypeRh.O_PLUS, BloodTypeRh.getValue("O_PLUS"));
        assertNull(BloodTypeRh.getValue(null));
        assertNull(BloodTypeRh.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "B_NEGATIVE, true",
        "AB_NEGATIVE, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = BloodTypeRh.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
