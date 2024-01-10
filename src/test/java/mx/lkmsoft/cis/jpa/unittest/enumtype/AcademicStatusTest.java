package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.AcademicStatus;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link AcademicStatus} test class
 *
 * @author Maikel Guerra Ferrer
 */
class AcademicStatusTest {

    @Test
    void testGetValue() {
        assertEquals(AcademicStatus.DAYCARE, AcademicStatus.getValue("DAYCARE"));
        assertEquals(AcademicStatus.ENGINEERING, AcademicStatus.getValue("ENGINEERING"));
        assertNull(AcademicStatus.getValue(null));
        assertNull(AcademicStatus.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "NO_EDUCATION, true",
        "HIGHER_TECHNICAL, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = AcademicStatus.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
