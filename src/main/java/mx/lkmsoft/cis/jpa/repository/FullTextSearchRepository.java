package mx.lkmsoft.cis.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Maikel Guerra Ferrer
 *
 * @param <T>
 * @param <I>
 */
@NoRepositoryBean
public interface FullTextSearchRepository<T, I> extends JpaRepository<T, I> {
	
	List<T> searchBy(String text, int limit, String... fields);
	
}