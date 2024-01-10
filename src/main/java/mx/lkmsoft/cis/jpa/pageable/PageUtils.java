package mx.lkmsoft.cis.jpa.pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import lombok.val;
import mx.lkmsoft.cis.common.assertion.AssertUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public final class PageUtils {

	private PageUtils() {
	}

	public static <T> Page<T> toPage(List<T> list, Pageable pageable) {
		if (AssertUtils.isEmpty(list) || AssertUtils.isEmpty(pageable) || (pageable.getOffset() >= list.size())) {
			return Page.empty();
		}

		int startIndex = (int) pageable.getOffset();
		int endIndex = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() 
				? list.size()
				: pageable.getOffset() + pageable.getPageSize());

		val subList = list.subList(startIndex, endIndex);
		return new PageImpl<>(subList, pageable, list.size());
	}

}