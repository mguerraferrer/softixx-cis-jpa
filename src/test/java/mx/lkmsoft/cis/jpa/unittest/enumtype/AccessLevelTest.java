package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.AccessLevel;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link AccessLevel} test class
 *
 * @author Maikel Guerra Ferrer
 */
class AccessLevelTest {

    @Test
    void testGetValue() {
        assertEquals(AccessLevel.RESTRICTED, AccessLevel.getValue("RESTRICTED"));
        assertEquals(AccessLevel.CONFIG, AccessLevel.getValue("CONFIG"));
        assertNull(AccessLevel.getValue(null));
        assertNull(AccessLevel.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "FULL, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = AccessLevel.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
