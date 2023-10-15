package mx.lkmsoft.cis.jpa.base;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@MappedSuperclass
public class AuditableEntity extends BaseEntity {

	@Column(name = "create_on", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false, updatable = false)
	@CreationTimestamp
	@ColumnDefault("CURRENT_TIMESTAMP")
	protected LocalDateTime createOn;

	@Column(name = "update_on", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", nullable = false)
	@UpdateTimestamp
	@ColumnDefault("CURRENT_TIMESTAMP")
	protected LocalDateTime updateOn;

	/* Getters and Setters */
	public LocalDateTime getCreateOn() {
		return createOn;
	}

	public void setCreateOn(LocalDateTime createOn) {
		this.createOn = createOn;
	}

	public LocalDateTime getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(LocalDateTime updateOn) {
		this.updateOn = updateOn;
	}

}