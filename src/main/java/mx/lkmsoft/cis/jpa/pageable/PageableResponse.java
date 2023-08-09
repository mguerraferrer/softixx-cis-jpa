package mx.lkmsoft.cis.jpa.pageable;

import java.util.List;

/**
 * Represents a record for pageable response.
 *
 * @param <T> The type of the page response.
 * @param <U> The type of the source list.
 *
 * @author Maikel Guerra Ferrer
 *
 */
public record PageableResponse<T, U> (
	/**
     * Represents a pageable response.
     */
	PageResponse<T> pageResponse, 
	
	/**
     * Represents a list of source elements.
     */
	List<U> sourceList
) {}