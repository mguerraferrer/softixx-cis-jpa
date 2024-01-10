package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.jpa.pageable.PageData;
import mx.lkmsoft.cis.jpa.pageable.PageDataRequest;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link PageDataRequest} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PageDataRequestTest {

    @Test
    void testPageDataRequest() {
        val page = new PageImpl<>(DataTest.STR_LIST);
        val pageData = new PageData();

        val result = new PageDataRequest<>(page, pageData);

        assertNotNull(result);
        assertEquals(page, result.page());
        assertEquals(pageData, result.pageData());
    }

    @Test
    void testPageDataRequestWithNullablePage() {
        val pageData = new PageData();

        val result = new PageDataRequest<String>(null, pageData);

        assertNotNull(result);
        assertNull(result.page());
        assertEquals(pageData, result.pageData());
    }

    @Test
    void testPageDataRequestWithNullablePageData() {
        val page = new PageImpl<>(DataTest.STR_LIST);

        val result = new PageDataRequest<>(page, null);

        assertNotNull(result);
        assertNull(result.pageData());
        assertEquals(page, result.page());
    }

}