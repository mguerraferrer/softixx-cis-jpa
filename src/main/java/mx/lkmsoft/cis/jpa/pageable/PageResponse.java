package mx.lkmsoft.cis.jpa.pageable;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.util.Assert;

import lombok.Data;
import lombok.val;

/**
 * Represents a generic page response with pagination details.
 * 
 * @param <T> The type of elements in the page.
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Data
public class PageResponse<T> {
	/**
	 * Represents the total number of elements in the page
	 */
	private Long totalElements;

	/**
	 * Represents the total number of pages
	 */
	private int totalPages;

	/**
	 * Represents the current page number
	 */
	private int currentPage;

	/**
	 * Represents the page number
	 */
	private int pageNum;

	/**
	 * Represents the page size
	 */
	private int pageSize;

	/**
	 * Represents the number of elements in the current page
	 */
	private int numberOfElements;

	/**
	 * Represents if the page has any content
	 */
	private Boolean hasContent;

	/**
	 * Represents if the page has any previous pages
	 */
	private Boolean hasPrevious;

	/**
	 * Represents if the page has any next pages
	 */
	private Boolean hasNext;

	/**
	 * Represents if the current page is the first page
	 */
	private boolean first;

	/**
	 * Represents if the current page is the last page
	 */
	private boolean last;

	/**
	 * Represents the sort order of the page
	 */
	private SortOrderResponse sort;

	/**
	 * Represents the page information
	 */
	private PageInfoResponse pageInfo;

	/**
	 * Represents the list of page numbers to be displayed
	 */
	private List<Integer> pages;

	/**
	 * Represents the list of records per page
	 */
	private List<Integer> recordsPerPages;

	/**
	 * Constructs a page response instance based on the provided page data request
	 * and the request mapping
	 *
	 * @param pageDataRequest the page data request
	 */
	public PageResponse(PageDataRequest<T> pageDataRequest) {
		val page = pageDataRequest.page();
		Assert.notNull(page, "pageable.page.required");

		val pageData = pageDataRequest.pageData();
		Assert.notNull(pageData, "pageable.page.data.required");

		this.totalElements = page.getTotalElements();
		this.totalPages = page.getTotalPages();
		this.currentPage = page.getNumber();
		this.pageNum = page.getNumber() == 0 ? 1 : page.getNumber() + 1;
		this.pageSize = page.getSize();
		this.numberOfElements = page.getNumberOfElements();
		this.hasContent = page.hasContent();
		this.hasPrevious = page.hasPrevious();
		this.hasNext = page.hasNext();
		this.first = page.isFirst();
		this.last = page.isLast();
		this.sort = SortUtils.sortOrder(page.getSort());
		this.pageInfo = pageInfo();
		this.pages = pagesToDisplay(pageData);
		this.recordsPerPages = pageData.recordsPerPages();
	}

	/**
	 * Constructs the page information for this page
	 *
	 * @return the page information
	 */
	private PageInfoResponse pageInfo() {
		if (Boolean.TRUE.equals(this.hasContent)) {
			val start = (this.pageNum - 1) * this.pageSize + 1;
			var end = start + this.pageSize - 1;

			if (end > this.totalElements) {
				end = this.totalElements.intValue();
			}

			if (this.totalElements <= this.pageSize) {
				return new PageInfoResponse("pageable.info.paginate.result", null, null, this.totalElements);
			}

			return new PageInfoResponse("pageable.info.showing.records", start, end, this.totalElements);
		} else {
			return PageInfoResponse.empty();
		}
	}

	/**
	 * Calculates the pages to display based on the provided page data
	 *
	 * @param pageData the page data
	 * @return a list of page numbers to be displayed
	 */
	private List<Integer> pagesToDisplay(PageData pageData) {
		if (Boolean.TRUE.equals(this.hasContent)) {
			if (this.totalElements <= this.pageSize) {
				return List.of(1);
			}

			val pagesToDisplay = pageData.pagesToDisplay();
			if (this.totalPages <= pagesToDisplay) {
				return IntStream.rangeClosed(1, this.totalPages).boxed().toList();
			} else {
				return calculatePages(pagesToDisplay);
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Calculates the pages to be displayed based on the number of pages to display
	 *
	 * @param pagesToDisplay the number of pages to display
	 * @return a list of page numbers to be displayed
	 */
	private List<Integer> calculatePages(int pagesToDisplay) {
		if (this.pageNum >= pagesToDisplay) {
			var rangeStart = this.pageNum - 1;
			var totalNextPages = this.pageNum + pagesToDisplay - 1;
			if (totalNextPages > this.totalPages) {
				totalNextPages = this.totalPages;
				while (totalNextPages - rangeStart < pagesToDisplay - 1) {
					rangeStart--;
				}
			}
			return IntStream.rangeClosed(rangeStart, totalNextPages).limit(pagesToDisplay).boxed().toList();
		} else {
			return IntStream.rangeClosed(1, pagesToDisplay).boxed().toList();
		}
	}

}