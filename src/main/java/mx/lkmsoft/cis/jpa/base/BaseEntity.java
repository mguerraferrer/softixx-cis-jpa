package mx.lkmsoft.cis.jpa.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
	@Column(name = "id")
	protected Long id;

	public boolean isNew() {
		return this.id == null;
	}

}