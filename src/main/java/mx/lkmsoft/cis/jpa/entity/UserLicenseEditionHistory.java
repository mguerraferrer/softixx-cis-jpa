package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "user_license_edition_history"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license_edition_history", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_edition_history_seq", allocationSize = 1)
public class UserLicenseEditionHistory extends BaseEntity {

	@Column(name = "date_time")
	private LocalDateTime dateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	public UserLicenseEditionHistory() {
		super();
	}

	public UserLicenseEditionHistory(UserLicense userLicense) {
		this.userLicense = userLicense;
		this.dateTime = LocalDateTime.now();
	}

	/* Getters and Setters */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public UserLicense getUserLicense() {
		return userLicense;
	}

	public void setUserLicense(UserLicense userLicense) {
		this.userLicense = userLicense;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(dateTime);
		return sb.toString();
	}

}