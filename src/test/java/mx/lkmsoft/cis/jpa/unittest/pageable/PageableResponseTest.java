package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.jpa.pageable.PageableResponse;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link PageableResponse} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PageableResponseTest {

    @Test
    void testPageableResponse() {
        val result = DataTest.commonPageableResponse();

        assertNotNull(result);
        assertEquals(DataTest.commonPageResponse(), result.pageResponse());
        assertEquals(DataTest.INT_LIST, result.sourceList());
    }

    @Test
    void testPageableResponseWithNullablePageResponse() {
        val result = new PageableResponse<>(null, DataTest.INT_LIST);

        assertNotNull(result);
        assertNull(result.pageResponse());
        assertEquals(DataTest.INT_LIST, result.sourceList());
    }

    @Test
    void testPageableResponseWithNullableSourceList() {
        val result = new PageableResponse<>(DataTest.commonPageResponse(), null);

        assertNotNull(result);
        assertNull(result.sourceList());
        assertEquals(DataTest.commonPageResponse(), result.pageResponse());
    }

}