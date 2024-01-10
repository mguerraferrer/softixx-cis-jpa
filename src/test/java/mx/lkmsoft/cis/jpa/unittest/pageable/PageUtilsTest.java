package mx.lkmsoft.cis.jpa.unittest.pageable;

import lombok.val;
import mx.lkmsoft.cis.jpa.pageable.PageUtils;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link PageUtils} test class
 *
 * @author Maikel Guerra Ferrer
 */
class PageUtilsTest {

    @Test
    void testToPage() {
        val pageable = Pageable.ofSize(10);

        val result = PageUtils.toPage(DataTest.STR_LIST, pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalPages());
        assertEquals(3, result.getTotalElements());
        assertEquals(10, result.getPageable().getPageSize());
    }

    @Test
    void testToPageUsingOffset() {
        val pageable = Pageable.ofSize(1);

        val result = PageUtils.toPage(DataTest.STR_LIST, pageable);

        assertNotNull(result);
        assertEquals(3, result.getTotalPages());
        assertEquals(3, result.getTotalElements());
        assertEquals(1, result.getPageable().getPageSize());
    }

    @Test
    void testToPageWithEmptyList() {
        val pageable = Pageable.ofSize(10);

        val result = PageUtils.toPage(List.of(), pageable);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

}