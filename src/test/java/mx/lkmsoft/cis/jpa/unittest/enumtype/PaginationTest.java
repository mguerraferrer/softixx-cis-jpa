package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.Pagination;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link Pagination} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PaginationTest {

    @Test
    void testGetValue() {
        assertEquals("10", Pagination.getValue(Pagination.P10));
        assertEquals("50", Pagination.getValue(Pagination.P50));
        assertEquals(20, Pagination.getValue("P20"));
        assertNull(Pagination.getValue(DataTest.NULLABLE_ST));
        assertNull(Pagination.getValue((Pagination) null));
        assertNull(Pagination.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "P30, true",
        "P40, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = Pagination.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
