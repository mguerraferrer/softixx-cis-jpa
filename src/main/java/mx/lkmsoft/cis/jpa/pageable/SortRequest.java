package mx.lkmsoft.cis.jpa.pageable;

/**
 * Record that encapsulates the information required for sorting a set of data
 *
 * @author Maikel Guerra Ferrer
 *
 */
public record SortRequest (
	/**
     * The field by which the data set should be sorted.
     */
    String sortBy, 

    /**
     * The direction in which the data set should be sorted - 'asc' for ascending, 'desc' for descending.
     */
    String sortDir
) {}