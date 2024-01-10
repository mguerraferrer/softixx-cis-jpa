package mx.lkmsoft.cis.jpa.pageable;

/**
 * Record that encapsulates information about sorting order in the context of
 * pageable data
 *
 * @author Maikel Guerra Ferrer
 *
 */
public record SortOrderResponse (
	/**
     * The field by which the data set is currently sorted
     */
	String sortBy, 

	/**
     * The direction of sorting - 'asc' for ascending, 'desc' for descending
     */
	String sortDir, 

	/**
     * The reverse of the current sort direction
     */
	String reverseSort, 

	/**
     * Additional sort data encapsulated in a record
     */
	SortData data) {
	
	/**
     * A record that encapsulates additional sort data such as the sort up 
     * and sort down indicators, and the CSS class for the sort indicator
     */
	public record SortData (
		/**
     	 * The sort-up indicator
     	 */
		String sortUp, 

		/**
     	 * The sort down indicator
     	 */
		String sortDown, 

		/**
     	 * The CSS class for the sort indicator
     	 */
		String sortCss	
	) {}

}