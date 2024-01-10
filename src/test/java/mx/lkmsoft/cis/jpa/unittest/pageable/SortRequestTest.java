package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.jpa.pageable.SortRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link SortRequest} test class
 *
 * @author Maikel Guerra Ferrer
 */
class SortRequestTest {

    @Test
    void testSortRequest() {
        val sortRequest = new SortRequest("name", "asc");

        assertNotNull(sortRequest);
        assertEquals("name", sortRequest.sortBy());
        assertEquals("asc", sortRequest.sortDir());
    }

}
