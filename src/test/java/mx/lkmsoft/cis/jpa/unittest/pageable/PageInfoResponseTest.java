package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.jpa.pageable.PageInfoResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link PageInfoResponse} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PageInfoResponseTest {

    @Test
    void testPageInfoResponse() {
        val result = new PageInfoResponse("text", 1, 10, 25L);

        assertEquals("text", result.text());
        assertEquals(1, result.start());
        assertEquals(10, result.end());
        assertEquals(25L, result.totalElements());
    }

    @Test
    void testEmpty() {
        val result = PageInfoResponse.empty();

        assertEquals("pageable.info.no.records", result.text());
        assertNull(result.start());
        assertNull(result.end());
        assertEquals(0L, result.totalElements());
    }

}