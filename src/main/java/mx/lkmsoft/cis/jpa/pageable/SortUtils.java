package mx.lkmsoft.cis.jpa.pageable;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.Assert;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.pageable.SortOrderResponse.SortData;

/**
 * This is a utility class that provides a set of functions for sorting
 * operations. It contains methods to create Sort objects and SortOrderResponse
 * from various inputs
 *
 * @author Maikel Guerra Ferrer
 *
 */
public final class SortUtils {

	private SortUtils() {
	}

	public static final String SORT_ORDER_UP_CSS = "fa-solid fa-arrow-up-short-wide";
	public static final String SORT_ORDER_DOWN_CSS = "fa-solid fa-arrow-down-short-wide";

	/**
	 * Returns a Sort object using a SortRequest
	 *
	 * @param sortRequest the request containing the sort field and direction
	 * @return the generated Sort object
	 */
	public static Sort sort(SortRequest sortRequest) {
		Assert.notNull(sortRequest, "pageable.sort.request.required");
		return sort(sortRequest.sortBy(), sortRequest.sortDir());
	}

	/**
	 * Returns a Sort object using given sort field and direction
	 *
	 * @param sortBy  the field to sort by
	 * @param sortDir the direction to sort in
	 * @return the generated Sort object
	 */
	public static Sort sort(String sortBy, String sortDir) {
		Assert.notNull(sortBy, "pageable.sort.by.required");

		val direction = determineDirection(sortDir);
		return Sort.by(direction, sortBy);
	}

	/**
	 * Returns a Sort object using a list of SortRequest objects
	 *
	 * @param sortRequests the list of requests containing sort fields and
	 *                     directions
	 * @return the generated Sort object
	 */
	public static Sort sort(List<SortRequest> sortRequests) {
		Assert.notNull(sortRequests, "pageable.sort.request.required");
		Assert.noNullElements(sortRequests, "pageable.sort.request.list.required");

		val orders = sortRequests.stream().map(SortUtils::mapToOrder).filter(Objects::nonNull).toList();
		if (!orders.isEmpty()) {
			return Sort.by(orders);
		}

		return Sort.unsorted();
	}

	/**
	 * Returns a SortOrderResponse using a Sort object
	 *
	 * @param sort the Sort object to generate the response from
	 * @return the generated SortOrderResponse object
	 */
	public static SortOrderResponse sortOrder(Sort sort) {
		if (sort != null) {
			val order = sort.stream().findFirst().orElse(null);
			if (order != null) {
				var sortBy = order.getProperty();
				val sortDir = order.getDirection().name().toLowerCase();
				val reverseSort = reverseSort(order);
				val sortData = sortData(order);

				return new SortOrderResponse(sortBy, sortDir, reverseSort, sortData);
			}
		}
		return null;
	}

	/**
     * Determines the reverse direction for a given order
     *
     * @param order the order whose reverse direction is to be determined
     * @return the reverse sort direction as a string
     */
	private static String reverseSort(Order order) {
		val reverseSort = order.getDirection().equals(Direction.ASC) ? Direction.DESC : Direction.ASC;
		return reverseSort.name().toLowerCase();
	}

	/**
     * Generates a SortData instance for a given order
     *
     * @param order the order from which the SortData is to be generated
     * @return the corresponding SortData object
     */
	private static SortData sortData(Order order) {
		val sortCss = order.getDirection().equals(Direction.ASC) ? SORT_ORDER_UP_CSS : SORT_ORDER_DOWN_CSS;
		return new SortData(SORT_ORDER_UP_CSS, SORT_ORDER_UP_CSS, sortCss);
	}

	/**
     * Maps a SortRequest to an Order
     *
     * @param sortRequest the sort request to be mapped
     * @return the corresponding Order object
     */
	private static Order mapToOrder(SortRequest sortRequest) {
		val direction = determineDirection(sortRequest);
		if (StringUtils.hasValue(sortRequest.sortBy())) {
			return new Order(direction, sortRequest.sortBy());
		}
		return null;
	}

	/**
     * Determines the direction of sorting from a SortRequest
     *
     * @param sortRequest the sort request
     * @return the sort direction
     */
	private static Direction determineDirection(SortRequest sortRequest) {
		return determineDirection(sortRequest.sortDir());
	}

	/**
     * Determines the sort direction from a given string representation
     *
     * @param sortDir the string representation of the sort direction
     * @return the corresponding Direction object
     */
	private static Direction determineDirection(String sortDir) {
		if (StringUtils.hasValue(sortDir)) {
			return Sort.DEFAULT_DIRECTION;
		}
		return Direction.fromOptionalString(sortDir).orElse(Sort.DEFAULT_DIRECTION);
	}

}