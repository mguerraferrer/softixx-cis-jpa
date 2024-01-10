package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.jpa.pageable.PageData;
import mx.lkmsoft.cis.jpa.pageable.PageDataRequest;
import mx.lkmsoft.cis.jpa.pageable.PageInfoResponse;
import mx.lkmsoft.cis.jpa.pageable.PageResponse;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Maikel Guerra Ferrer
 */
class PageResponseTest {

    @Test
    void testPageResponse() {
        val pageDataRequest = DataTest.commonPageDataRequest();
        val pageResponse = new PageResponse<>(pageDataRequest);

        assertTrue(pageResponse.getHasContent());
        assertEquals(3, pageResponse.getTotalElements());
        assertEquals(1, pageResponse.getTotalPages());
    }

    @Test
    void testPageResponseWithEmptyPage() {
        val pageDataRequest = new PageDataRequest<>(Page.empty(), new PageData());
        val pageResponse = new PageResponse<>(pageDataRequest);

        assertFalse(pageResponse.getHasContent());
        assertEquals(PageInfoResponse.empty(), pageResponse.getPageInfo());
    }

    @ParameterizedTest
    @CsvSource({
        "5, 10",
        "1, 10",
        "11, 10",
        "5, 4"
    })
    void testPageResponseWithCustomPageNumAndTotalPages(int pageNum, int totalPages) {
        val mockPage = mock(Page.class);
        val mockPageDataRequest = mock(PageDataRequest.class);
        val mockPageData = mock(PageData.class);

        when(mockPageDataRequest.page()).thenReturn(mockPage);
        when(mockPageDataRequest.pageData()).thenReturn(mockPageData);
        when(mockPage.hasContent()).thenReturn(true);
        when(mockPage.getTotalElements()).thenReturn(100L);
        when(mockPage.getNumber()).thenReturn(pageNum);
        when(mockPage.getTotalPages()).thenReturn(totalPages);
        when(mockPage.getSize()).thenReturn(10);
        when(mockPage.getNumberOfElements()).thenReturn(10);
        when(mockPageData.recordsPerPages()).thenReturn(List.of(10, 20, 30));
        when(mockPageData.pagesToDisplay()).thenReturn(5);

        val pageResponse = new PageResponse<>(mockPageDataRequest);

        assertTrue(pageResponse.getHasContent());
        assertEquals(pageNum + 1, pageResponse.getPageNum());
        assertEquals(totalPages, pageResponse.getTotalPages());
    }

}