package mx.lkmsoft.cis.jpa.pageable;

/**
 * Represents a record for page information response.
 *
 * @author Maikel Guerra Ferrer
 *
 */
public record PageInfoResponse (
	/**
     * Represents the text message of the page information.
     */
	String text, 
	
	/**
     * Represents the starting index of the page.
     */
	Integer start, 
	
	/**
     * Represents the ending index of the page.
     */
	Integer end, 
	
	/**
     * Represents the total number of elements in the page.
     */
	Long totalElements
) {
	/**
     * Static factory method to create an empty PageInfoResponse.
     *
     * @return An empty PageInfoResponse object.
     */
	public static PageInfoResponse empty() {
		return new PageInfoResponse(PageableConstants.PAGEABLE_NO_RECORDS, null, null, null);
	}
	
}