package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.jpa.pageable.SortOrderResponse;
import mx.lkmsoft.cis.jpa.pageable.SortOrderResponse.SortData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link SortOrderResponse} test class
 *
 * @author Maikel Guerra Ferrer
 */
class SortOrderResponseTest {

    @Test
    void testSortOrderResponse() {
        val sortData = new SortData("up", "down", "css");

        val response =  new SortOrderResponse("name", "asc", "desc", sortData);

        assertNotNull(response);
        assertEquals("name", response.sortBy());
        assertEquals("asc", response.sortDir());
        assertEquals("up", response.data().sortUp());
        assertEquals("css", response.data().sortCss());
    }

}