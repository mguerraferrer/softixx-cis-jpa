package mx.lkmsoft.cis.jpa.unittest.commondatatest;

import lombok.val;
import mx.lkmsoft.cis.jpa.pageable.PageData;
import mx.lkmsoft.cis.jpa.pageable.PageDataRequest;
import mx.lkmsoft.cis.jpa.pageable.PageResponse;
import mx.lkmsoft.cis.jpa.pageable.PageableResponse;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Maikel Guerra Ferrer
 */
public final class DataTest {

    private DataTest() {
    }

    public static final String NULLABLE_ST = null;
    public static final Integer NULLABLE_INT = null;
    public static final List<String> STR_LIST = List.of("item1", "item2", "item3");
    public static final List<Integer> INT_LIST = List.of(1, 2, 3);

    public static void commonAssert(boolean isAssert, boolean result) {
        if (isAssert) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }

    public static PageDataRequest<String> commonPageDataRequest() {
        val page = new PageImpl<>(STR_LIST);
        val pageData = new PageData();
        return new PageDataRequest<>(page, pageData);
    }

    public static PageResponse<String> commonPageResponse() {
        return new PageResponse<>(commonPageDataRequest());
    }

    public static PageableResponse<String, Integer> commonPageableResponse() {
        return new PageableResponse<>(commonPageResponse(), INT_LIST);
    }

}
