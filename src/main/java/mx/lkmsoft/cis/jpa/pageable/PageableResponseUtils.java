package mx.lkmsoft.cis.jpa.pageable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.val;
import mx.lkmsoft.cis.common.assertion.AssertUtils;
import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * This utility class provides helper methods to process and transform
 * PageableResponse objects
 *
 * @author Maikel Guerra Ferrer
 *
 */
public final class PageableResponseUtils {

	private PageableResponseUtils() {
	}

	/**
	 * Returns a map containing pageable data with empty search key
	 * 
	 * @param <T>              Type of the page response
	 * @param <U>              Type of the source list
	 * @param sourceKey        A key representing the source list in the map
	 * @param pageableResponse A PageableResponse object containing page response
	 *                         and source list
	 * @return A map containing pageable data and search key. Returns an empty map
	 *         if sourceKey is null or pageableResponse is null.
	 */
	public static <T, U> Map<String, Object> pageableResult(String sourceKey, PageableResponse<T, U> pageableResponse) {
		return pageableResult(sourceKey, StringUtils.EMPTY, pageableResponse);
	}

	/**
	 * Returns a map containing pageable data and search key.
	 * 
	 * @param <T>              Type of the page response
	 * @param <U>              Type of the source list
	 * @param sourceKey        A key representing the source list in the map
	 * @param pageableResponse A PageableResponse object containing page response
	 *                         and source list
	 * @return A map containing pageable data and search key. Returns an empty map
	 *         if sourceKey is null or pageableResponse is null.
	 */
	public static <T, U> Map<String, Object> pageableResult(String sourceKey,
															String searchValue,
															PageableResponse<T, U> pageableResponse) {
		if (StringUtils.hasValue(sourceKey) && AssertUtils.nonNull(pageableResponse)) {
			val pageableData = new HashMap<String, Object>();
			pageableData.put(sourceKey, pageableResponse.sourceList());
			pageableData.put("pageable", pageableResponse.pageResponse());
			pageableData.put("key", searchValue);
			return pageableData;
		}
		return Collections.emptyMap();
	}

}