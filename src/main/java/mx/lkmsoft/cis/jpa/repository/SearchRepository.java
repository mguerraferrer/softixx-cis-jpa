package mx.lkmsoft.cis.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Maikel Guerra Ferrer
 *
 * @param <T>
 * @param <I>
 */
@NoRepositoryBean
public interface SearchRepository<T, I> extends JpaRepository<T, I> {
	
	public Page<T> findAll(String keyword, Pageable pageable);
	
}