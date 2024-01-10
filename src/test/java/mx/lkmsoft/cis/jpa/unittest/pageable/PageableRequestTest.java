package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.common.pageable.PageableUtils;
import mx.lkmsoft.cis.jpa.pageable.PageableRequest;
import mx.lkmsoft.cis.jpa.pageable.SortRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * {@link PageableRequest} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PageableRequestTest {

    @Mock
    Pageable pageable;

    @Mock
    Sort sort;

    AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    private static final String KEY = "key";

    @Test
    void testOfWithPageable() {
        commonWhen();

        val result = PageableRequest.of(pageable);

        assertNotNull(result);
        assertThat(result.key()).isEmpty();
    }

    @Test
    void testOfWithPageableAndKey() {
        commonWhen();

        val result = PageableRequest.of(KEY, pageable);

        assertNotNull(result);
        assertEquals(KEY, result.key());
    }

    @Test
    void testOfWithPageNumberAndSort() {
        val result = PageableRequest.of(1, sort);

        assertNotNull(result);
        assertThat(result.key()).isEmpty();
        assertEquals(0, result.pageRequest().getPageNumber());
        assertEquals(PageableUtils.RECORDS_PER_PAGE, result.pageRequest().getPageSize());
        assertEquals(sort, result.pageRequest().getSort());
    }

    @Test
    void testOfWithPageNumberAndPageSizeAndSort() {
        val result = PageableRequest.of(2, 10, sort);

        assertNotNull(result);
        assertThat(result.key()).isEmpty();
        assertEquals(1, result.pageRequest().getPageNumber());
        assertEquals(10, result.pageRequest().getPageSize());
        assertEquals(sort, result.pageRequest().getSort());
    }

    @Test
    void testOfWithKeyAndPageNumberAndSort() {
        val result = PageableRequest.of(KEY, 10, sort);

        assertNotNull(result);
        assertEquals(KEY, result.key());
        assertEquals(9, result.pageRequest().getPageNumber());
        assertEquals(PageableUtils.RECORDS_PER_PAGE, result.pageRequest().getPageSize());
        assertEquals(sort, result.pageRequest().getSort());
    }

    @Test
    void testOfWithKeyAndPageNumberAndPageSizeAndSort() {
        val result = PageableRequest.of(KEY, 5, 20, sort);

        assertNotNull(result);
        assertEquals(KEY, result.key());
        assertEquals(4, result.pageRequest().getPageNumber());
        assertEquals(20, result.pageRequest().getPageSize());
        assertEquals(sort, result.pageRequest().getSort());
    }

    @Test
    void testOfWithSortRequest() {
        val sortRequest = new SortRequest("sortBy", "sortDir");
        val result = PageableRequest.of(sortRequest);

        assertNotNull(result);
        assertThat(result.key()).isEmpty();
        assertEquals(0, result.pageRequest().getPageNumber());
        assertEquals(10, result.pageRequest().getPageSize());
    }

    @Test
    void testOfWithKeyAndSortRequest() {
        val sortRequest = new SortRequest("sortBy", "sortDir");
        val result = PageableRequest.of(KEY, sortRequest);

        assertNotNull(result);
        assertEquals(KEY, result.key());
        assertEquals(0, result.pageRequest().getPageNumber());
        assertEquals(10, result.pageRequest().getPageSize());
    }

    @Test
    void testOfWithListOfSortRequest() {
        val sortRequests = List.of(
            new SortRequest("sortBy", "sortDir"),
            new SortRequest("sortBy1", "sortDir1")
        );
        val result = PageableRequest.of(sortRequests);

        assertNotNull(result);
        assertThat(result.key()).isEmpty();
        assertEquals(0, result.pageRequest().getPageNumber());
        assertEquals(10, result.pageRequest().getPageSize());
        assertNotNull(result.pageRequest().getSort());
    }

    @Test
    void testOfWithKeyAndListOfSortRequest() {
        val sortRequests = List.of(
            new SortRequest("sortBy", "sortDir"),
            new SortRequest("sortBy1", "sortDir1")
        );
        val result = PageableRequest.of(KEY, sortRequests);

        assertNotNull(result);
        assertEquals(KEY, result.key());
        assertEquals(0, result.pageRequest().getPageNumber());
        assertEquals(10, result.pageRequest().getPageSize());
        assertNotNull(result.pageRequest().getSort());
    }

    @Test
    void testPageRequestWithPageable() {
        commonWhen();

        val result = PageableRequest.pageRequest(pageable);

        assertNotNull(result);
        assertEquals(0, result.getPageNumber());
        assertEquals(10, result.getPageSize());
        assertEquals(sort, result.getSort());
    }

    @Test
    void testPageRequestWithPageNumberAndPageSizeAndSort() {
        val result = PageableRequest.pageRequest(1, 5, sort);
        val result1 = PageableRequest.pageRequest(1, 5, null);

        assertNotNull(result);
        assertEquals(0, result.getPageNumber());
        assertEquals(5, result.getPageSize());
        assertEquals(sort, result.getSort());
        assertNotNull(result1.getSort());
    }

    @Test
    void testPageRequestWithSort() {
        val result = PageableRequest.pageRequest(sort);
        val result1 = PageableRequest.pageRequest((Sort) null);

        assertNotNull(result);
        assertEquals(0, result.getPageNumber());
        assertEquals(10, result.getPageSize());
        assertEquals(sort, result.getSort());
        assertNotNull(result1.getSort());
    }

    private void commonWhen() {
        when(pageable.getPageNumber()).thenReturn(1);
        when(pageable.getPageSize()).thenReturn(10);
        when(pageable.getSort()).thenReturn(sort);
    }

}