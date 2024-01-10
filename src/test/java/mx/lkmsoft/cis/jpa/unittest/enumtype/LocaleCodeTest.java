package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.LocaleCode;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link LocaleCode} test class
 *
 * @author Maikel Guerra Ferrer
 */
class LocaleCodeTest {

    @Test
    void testGetValue() {
        assertEquals(LocaleCode.ES_MX, LocaleCode.getValue("ES_MX"));
        assertEquals(LocaleCode.EN_US, LocaleCode.getValue("EN_US"));
        assertNull(LocaleCode.getValue(null));
        assertNull(LocaleCode.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "ES_MX, true",
        "EN_US, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = LocaleCode.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
