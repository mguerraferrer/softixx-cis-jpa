package mx.lkmsoft.cis.jpa.pageable;

import org.springframework.data.domain.Page;

/**
 * Represents a record for page data request
 *
 * @param <T> The type of the page.
 * 
 * @author Maikel Guerra Ferrer
 *
 */
public record PageDataRequest<T> (
	/**
	 * Represents a page of elements
	 */
	Page<T> page,

	/**
	 * Represents the metadata of the page
	 */
	PageData pageData
) {}