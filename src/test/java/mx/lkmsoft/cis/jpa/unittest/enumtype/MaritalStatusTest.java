package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.MaritalStatus;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link MaritalStatus} test class
 *
 * @author Maikel Guerra Ferrer
 */
class MaritalStatusTest {

    @Test
    void testGetValue() {
        assertEquals(MaritalStatus.SINGLE, MaritalStatus.getValue("SINGLE"));
        assertEquals(MaritalStatus.DIVORCED, MaritalStatus.getValue("DIVORCED"));
        assertNull(MaritalStatus.getValue(null));
        assertNull(MaritalStatus.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "MARRIED, true",
        "WIDOWED, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = MaritalStatus.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
