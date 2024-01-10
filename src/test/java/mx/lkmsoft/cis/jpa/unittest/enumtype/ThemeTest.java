package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.Theme;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link Theme} test class
 *
 * @author Maikel Guerra Ferrer
 */
class ThemeTest {

    @Test
    void testGetValue() {
        assertEquals(Theme.PRIMARY, Theme.getValue("PRIMARY"));
        assertEquals(Theme.YELLOW, Theme.getValue("YELLOW"));
        assertNull(Theme.getValue(null));
        assertNull(Theme.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "GREEN, true",
        "RED, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = Theme.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
