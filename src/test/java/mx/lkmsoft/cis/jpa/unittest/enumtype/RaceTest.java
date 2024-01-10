package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.Race;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link Race} test class
 *
 * @author Maikel Guerra Ferrer
 */
class RaceTest {

    @Test
    void testGetValue() {
        assertEquals(Race.WHITE, Race.getValue("WHITE"));
        assertEquals(Race.BLACK, Race.getValue("BLACK"));
        assertNull(Race.getValue(null));
        assertNull(Race.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "MIXED, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = Race.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
