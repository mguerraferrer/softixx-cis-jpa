package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.Gender;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link Gender} test class
 *
 * @author Maikel Guerra Ferrer
 */
class GenderTest {

    @Test
    void testGetValue() {
        assertEquals(Gender.MALE, Gender.getValue("MALE"));
        assertEquals(Gender.FEMALE, Gender.getValue("FEMALE"));
        assertNull(Gender.getValue(null));
        assertNull(Gender.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "UNKNOWN, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = Gender.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
