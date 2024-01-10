package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.common.pageable.PageableUtils;
import mx.lkmsoft.cis.jpa.pageable.PageData;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link PageData} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PageDataTest {

    private static final Pageable PAGEABLE = Pageable.ofSize(10);
    private static final List<Integer> RECORDS_PER_PAGES = List.of(10, 20, 30);

    @Test
    void testDefaultConstructor() {
        val pageData = new PageData();

        assertNotNull(pageData);
        assertEquals(PageableUtils.RECORDS_PER_PAGE, pageData.recordsPerPage());
        assertEquals(PageableUtils.PAGES_TO_DISPLAY, pageData.pagesToDisplay());
        assertEquals(PageableUtils.RECORDS_PER_PAGE_LIST, pageData.recordsPerPages());
    }

    @Test
    void testOfPageable() {
        val pageData = PageData.of(PAGEABLE);

        assertNotNull(pageData);
    }

    @Test
    void testOfPageableWithPagesToDisplay() {
        val pagesToDisplay = 5;
        val pageData = PageData.of(PAGEABLE, pagesToDisplay);
        val pageData1 = PageData.of(PAGEABLE, null);

        assertNotNull(pageData);
        assertEquals(pagesToDisplay, pageData.pagesToDisplay());
        assertEquals(10, pageData.recordsPerPage());
        assertEquals(pagesToDisplay, pageData1.pagesToDisplay());
    }

    @Test
    void testOfRecordsPerPageAndPagesToDisplay() {
        val recordsPerPage = 10;
        val pagesToDisplay = 5;

        val pageData = PageData.of(recordsPerPage, pagesToDisplay);
        val pageData1 = PageData.of(DataTest.NULLABLE_INT, pagesToDisplay);
        val pageData2 = PageData.of(recordsPerPage, DataTest.NULLABLE_INT);

        assertNotNull(pageData);
        assertEquals(recordsPerPage, pageData.recordsPerPage());
        assertEquals(pagesToDisplay, pageData.pagesToDisplay());
        assertEquals(recordsPerPage, pageData1.recordsPerPage());
        assertEquals(pagesToDisplay, pageData2.pagesToDisplay());
        assertThrows(
            IllegalArgumentException.class,
            () -> PageData.of((Integer) null, null),
            "pageable.records.per.page.pages.to.display.invalid");
    }

    @Test
    void testOfRecordsPerPagePagesToDisplayAndRecordsPerPages() {
        val recordsPerPage = 10;
        val pagesToDisplay = 5;

        val pageData = PageData.of(recordsPerPage, pagesToDisplay, RECORDS_PER_PAGES);
        val pageData1 = PageData.of(DataTest.NULLABLE_INT, pagesToDisplay, RECORDS_PER_PAGES);
        val pageData2 = PageData.of(recordsPerPage, DataTest.NULLABLE_INT, List.of(10, 20, 0, -1, 20));

        assertNotNull(pageData);
        assertEquals(recordsPerPage, pageData.recordsPerPage());
        assertEquals(pagesToDisplay, pageData.pagesToDisplay());
        assertEquals(RECORDS_PER_PAGES, pageData.recordsPerPages());
        assertEquals(recordsPerPage, pageData1.recordsPerPage());
        assertEquals(pagesToDisplay, pageData2.pagesToDisplay());
        assertEquals(List.of(10, 20), pageData2.recordsPerPages());
        assertThrows(
            IllegalArgumentException.class,
            () -> PageData.of(null, null, null),
            "pageable.parameter.empty.value"
        );
    }

    @Test
    void testOfRecordsPerPages() {
        val pageData = PageData.of(RECORDS_PER_PAGES);
        
        assertNotNull(pageData);
        assertEquals(RECORDS_PER_PAGES, pageData.recordsPerPages());
    }

    @Test
    void testWithRecordPerPage() {
        val pageData = PageData.withRecordPerPage(10);
        
        assertNotNull(pageData);
        assertEquals(10, pageData.recordsPerPage());
    }

    @Test
    void testWithRecordPerPageAndRecordsPerPages() {
        val recordsPerPage = 10;

        val pageData = PageData.withRecordPerPage(recordsPerPage, RECORDS_PER_PAGES);
        
        assertNotNull(pageData);
        assertEquals(recordsPerPage, pageData.recordsPerPage());
        assertEquals(RECORDS_PER_PAGES, pageData.recordsPerPages());
    }

    @Test
    void testWithPagesToDisplay() {
        val pageData = PageData.withPagesToDisplay(5);
        
        assertNotNull(pageData);
        assertEquals(5, pageData.pagesToDisplay());
    }

    @Test
    void testWithPagesToDisplayAndRecordsPerPages() {
        val pagesToDisplay = 5;

        val pageData = PageData.withPagesToDisplay(pagesToDisplay, RECORDS_PER_PAGES);
        
        assertNotNull(pageData);
        assertEquals(pagesToDisplay, pageData.pagesToDisplay());
        assertEquals(RECORDS_PER_PAGES, pageData.recordsPerPages());
    }

}