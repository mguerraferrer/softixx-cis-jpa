package mx.lkmsoft.cis.jpa.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@MappedSuperclass
@Getter
@Setter
public class SingleAuditableEntity {

	@Column(name = "create_on", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false, updatable = false)
	@CreationTimestamp
	@ColumnDefault("CURRENT_TIMESTAMP")
	protected LocalDateTime createOn;

	@Column(name = "update_on", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false)
	@UpdateTimestamp
	@ColumnDefault("CURRENT_TIMESTAMP")
	protected LocalDateTime updateOn;

}