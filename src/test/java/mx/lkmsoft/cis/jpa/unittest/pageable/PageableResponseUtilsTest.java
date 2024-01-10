package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.pageable.PageableResponseUtils;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link PageableResponseUtils} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PageableResponseUtilsTest {

    private static final String SOURCE_KEY = "sourceKey";
    @Test
    void testPageableResultWithSourceKeyAndPageableResponse() {
        val result = PageableResponseUtils.pageableResult(SOURCE_KEY, DataTest.commonPageableResponse());

        commonAssert(result);
        assertEquals(StringUtils.EMPTY, result.get("key"));
    }

    @Test
    void testPageableResultWithSourceKeyAndSearchValueAndPageableResponse() {
        val searchValue = "searchValue";
        val result = PageableResponseUtils.pageableResult(SOURCE_KEY, searchValue, DataTest.commonPageableResponse());

        commonAssert(result);
        assertEquals(searchValue, result.get("key"));
    }

    @Test
    void testPageableResultWithNullableSourceKey() {
        val result = PageableResponseUtils.pageableResult(null, DataTest.commonPageableResponse());

        assertTrue(result.isEmpty());
    }

    private void commonAssert(Map<String, Object> result) {
        assertNotNull(result);
        assertEquals(DataTest.commonPageableResponse().sourceList(), result.get(SOURCE_KEY));
        assertEquals(DataTest.commonPageableResponse().pageResponse(), result.get("pageable"));
    }

}