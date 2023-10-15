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
 * Persistent class for entity stored in table "user_license_available_service_history"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license_available_service_history", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_available_service_history_seq", allocationSize = 1)
public class UserLicenseAvailableServHistory extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_service_id", referencedColumnName = "id")
	private UserLicenseAvailableServ userLicenseAvailableServ;

	@Column(name = "entry_date")
	private LocalDateTime entryDate;

	@Column(name = "end_date")
	private LocalDateTime endDate;

	/* Getters and Setters */
	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public UserLicenseAvailableServ getUserLicenseAvailableServ() {
		return userLicenseAvailableServ;
	}

	public void setUserLicenseAvailableServ(UserLicenseAvailableServ userLicenseAvailableServ) {
		this.userLicenseAvailableServ = userLicenseAvailableServ;
	}

	/* toString */
	@Override
	public String toString() {
		return "UserLicenseAvailableServHistory [id=" + id + ", userLicenseAvailableServ="
				+ userLicenseAvailableServ.getId() + ", entryDate=" + entryDate + ", endDate=" + endDate + "]";
	}

}