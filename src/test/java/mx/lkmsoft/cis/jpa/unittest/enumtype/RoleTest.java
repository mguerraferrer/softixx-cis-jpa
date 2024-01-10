package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.Role;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link Role} test class
 *
 * @author Maikel Guerra Ferrer
 */
class RoleTest {

    @Test
    void testGetValue() {
        assertEquals(Role.DOCTOR, Role.getValue("DOCTOR"));
        assertEquals(Role.NURSE, Role.getValue("NURSE"));
        assertNull(Role.getValue(null));
        assertNull(Role.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "ADMIN, true",
        "SALES, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = Role.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
