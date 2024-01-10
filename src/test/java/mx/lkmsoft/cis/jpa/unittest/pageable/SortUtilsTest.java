package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.jpa.pageable.SortRequest;
import mx.lkmsoft.cis.jpa.pageable.SortUtils;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Maikel Guerra Ferrer
 */
class SortUtilsTest {

    private static final String SORT_ASC = "asc";
    private static final String SORT_DESC = "desc";

    @Test
    void testSortWithSortRequest() {
        val sortRequest = new SortRequest("name", SORT_ASC);
        val sort = SortUtils.sort(sortRequest);

        assertNotNull(sort);
        assertTrue(sort.isSorted());
        assertEquals(Sort.Direction.ASC, Objects.requireNonNull(sort.getOrderFor("name")).getDirection());
    }

    @Test
    void testSortWithSortByAndSortDir() {
        val sort = SortUtils.sort("lastname", SORT_DESC);

        assertNotNull(sort);
        assertTrue(sort.isSorted());
        assertEquals(Sort.Direction.DESC, Objects.requireNonNull(sort.getOrderFor("lastname")).getDirection());
    }

    @Test
    void testSortWithSortByAndNullableSortDir() {
        val sort = SortUtils.sort("lastname", null);

        assertNotNull(sort);
        assertTrue(sort.isSorted());
        assertEquals(Sort.Direction.ASC, Objects.requireNonNull(sort.getOrderFor("lastname")).getDirection());
    }

    @Test
    void testSortWithListOfSortRequest() {
        val sortRequests = List.of(
            new SortRequest("age", SORT_ASC),
            new SortRequest("title", SORT_DESC)
        );
        val sort = SortUtils.sort(sortRequests);

        assertNotNull(sort);
        assertTrue(sort.isSorted());
        assertEquals(Sort.Direction.ASC, Objects.requireNonNull(sort.getOrderFor("age")).getDirection());
        assertEquals(Sort.Direction.DESC, Objects.requireNonNull(sort.getOrderFor("title")).getDirection());
    }

    @Test
    void testSortWithListOfSortRequestWithEmptySortBy() {
        val sortRequests = List.of(new SortRequest("", SORT_ASC));
        val sort = SortUtils.sort(sortRequests);

        assertNotNull(sort);
        assertTrue(sort.isUnsorted());
    }

    @Test
    void testSortOrder() {
        val sort = Sort.by(Sort.Order.asc("gender"));
        val response = SortUtils.sortOrder(sort);

        assertNotNull(response);
        assertEquals("gender", response.sortBy());
        assertEquals(SORT_ASC, response.sortDir());
        assertEquals(SORT_DESC, response.reverseSort());
        assertEquals(SortUtils.SORT_ORDER_UP_CSS, response.data().sortUp());
        assertEquals(SortUtils.SORT_ORDER_DOWN_CSS, response.data().sortDown());
        assertEquals(SortUtils.SORT_ORDER_UP_CSS, response.data().sortCss());
    }

    @Test
    void testSortOrderWithNullSort() {
        assertNull(SortUtils.sortOrder(null));
    }

}