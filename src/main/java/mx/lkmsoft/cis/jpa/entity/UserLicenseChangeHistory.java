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
 * Persistent class for entity stored in table "user_license_change_history"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license_change_history", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_change_history_id_seq", allocationSize = 1)
public class UserLicenseChangeHistory extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	@Column(name = "old_license_hash")
	private String oldLicenseHash;

	@Column(name = "current_license_hash")
	private String currentLicenseHash;

	@Column(name = "date_time")
	private LocalDateTime dateTime;

	public UserLicenseChangeHistory() {
	}

	public UserLicenseChangeHistory(UserLicense userLicense, String oldLicenseHash, String currentLicenseHash) {
		this.userLicense = userLicense;
		this.oldLicenseHash = oldLicenseHash;
		this.currentLicenseHash = currentLicenseHash;
		this.dateTime = LocalDateTime.now();
	}

	/* Getters and Setters */
	public UserLicense getUserLicense() {
		return userLicense;
	}

	public void setUserLicense(UserLicense userLicense) {
		this.userLicense = userLicense;
	}

	public String getOldLicenseHash() {
		return oldLicenseHash;
	}

	public void setOldLicenseHash(String oldLicenseHash) {
		this.oldLicenseHash = oldLicenseHash;
	}

	public String getCurrentLicenseHash() {
		return currentLicenseHash;
	}

	public void setCurrentLicenseHash(String currentLicenseHash) {
		this.currentLicenseHash = currentLicenseHash;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	/* toString */
	@Override
	public String toString() {
		return "UserLicenseChangeHistory [id=" + id + ", userLicense=" + userLicense.getId() + ", oldLicenseHash="
				+ oldLicenseHash + ", currentLicenseHash=" + currentLicenseHash + ", dateTime=" + dateTime + "]";
	}

}