package mx.lkmsoft.cis.jpa.pageable;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

import lombok.val;
import mx.lkmsoft.cis.common.pageable.PageableUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public record PageableRequest(String key, PageRequest pageRequest) {
	
	private static final String EMPTY_KEY = "";
	private static final String KEY_REQUIRED = "pageable.page.key.required";
	
	public static PageableRequest of(Pageable pageable) {
		val pageRequest = pageRequest(pageable);
		return new PageableRequest(EMPTY_KEY, pageRequest);
	}
	
	public static PageableRequest of(String key, Pageable pageable) {
		Assert.notNull(key, KEY_REQUIRED);
		
		val pageRequest = pageRequest(pageable);
		return new PageableRequest(key.toLowerCase(), pageRequest);
	}
	
	public static PageableRequest of(int pageNumber, Sort sort) {
		val pageRequest = pageRequest(pageNumber, PageableUtils.RECORDS_PER_PAGE, sort);
		return new PageableRequest(EMPTY_KEY, pageRequest);
	}
	
	public static PageableRequest of(int pageNumber, int pageSize, Sort sort) {
		val pageRequest = pageRequest(pageNumber, pageSize, sort);
		return new PageableRequest(EMPTY_KEY, pageRequest);
	}
	
	public static PageableRequest of(String key, int pageNumber, Sort sort) {
		Assert.notNull(key, KEY_REQUIRED);
		
		val pageRequest = pageRequest(pageNumber, PageableUtils.RECORDS_PER_PAGE, sort);
		return new PageableRequest(key.toLowerCase(), pageRequest);
	}
	
	public static PageableRequest of(String key, int pageNumber, int pageSize, Sort sort) {
		Assert.notNull(key, KEY_REQUIRED);
		
		val pageRequest = pageRequest(pageNumber, pageSize, sort);
		return new PageableRequest(key.toLowerCase(), pageRequest);
	}
	
	public static PageableRequest of(SortRequest sortRequest) {
		val sort = SortUtils.sort(sortRequest);
		val pageRequest = pageRequest(PageableUtils.DEFAULT_PAGE, PageableUtils.RECORDS_PER_PAGE, sort);
		
		return new PageableRequest(EMPTY_KEY, pageRequest);
	}
	
	public static PageableRequest of(String key, SortRequest sortRequest) {
		Assert.notNull(key, KEY_REQUIRED);

		val sort = SortUtils.sort(sortRequest);
		val pageRequest = pageRequest(PageableUtils.DEFAULT_PAGE, PageableUtils.RECORDS_PER_PAGE, sort);
		
		return new PageableRequest(key.toLowerCase(), pageRequest);
	}
	
	public static PageableRequest of(List<SortRequest> sortRequests) {
		val sort = SortUtils.sort(sortRequests);
		val pageRequest = pageRequest(PageableUtils.DEFAULT_PAGE, PageableUtils.RECORDS_PER_PAGE, sort);
		return new PageableRequest(EMPTY_KEY, pageRequest);
	}
	
	public static PageableRequest of(String key, List<SortRequest> sortRequests) {
		Assert.notNull(key, KEY_REQUIRED);
		
		val sort = SortUtils.sort(sortRequests);
		val pageRequest = pageRequest(PageableUtils.DEFAULT_PAGE, PageableUtils.RECORDS_PER_PAGE, sort);
		return new PageableRequest(key.toLowerCase(), pageRequest);
	}
	
	public static PageRequest pageRequest(Pageable pageable) {
		Assert.notNull(pageable, "pageable.pageable.required");
		
		val pageNumber = PageableUtils.pageNumber(pageable.getPageNumber());
		val recordsPerPage = PageableUtils.recordsPerPage(pageable.getPageSize());
		val sort = pageable.getSort();
		
		return PageRequest.of(pageNumber - 1, recordsPerPage, sort);
	}
	
	public static PageRequest pageRequest(int pageNumber, int pageSize, Sort sort) {
		Assert.state(pageNumber > 0, "pageable.page.number.invalid");
		Assert.state(pageSize > 0, "pageable.page.size.invalid");
		
		pageNumber = PageableUtils.pageNumber(pageNumber);
		pageSize = PageableUtils.recordsPerPage(pageSize);
		
		if (sort == null) {
			sort = Sort.unsorted();
		}
		
		return PageRequest.of(pageNumber - 1, pageSize, sort);
	}

	public static PageRequest pageRequest(Sort sort) {
		if (sort == null) {
			sort = Sort.unsorted();
		}
		return PageRequest.of(0, PageableUtils.RECORDS_PER_PAGE, sort);
	}

}