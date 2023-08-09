package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "user_license_available_service"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license_available_service", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_available_service_id_seq", allocationSize = 1)
public class UserLicenseAvailableServ extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "available_service_id", referencedColumnName = "id")
	private AvailableService availableService;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicenseAvailableServ", targetEntity = UserLicenseAvailableServHistory.class)
	private List<UserLicenseAvailableServHistory> userLicenseServiceHistories;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
	public AvailableService getAvailableService() {
		return availableService;
	}

	public void setAvailableService(AvailableService availableService) {
		this.availableService = availableService;
	}

	public UserLicense getUserLicense() {
		return userLicense;
	}

	public void setUserLicense(UserLicense userLicense) {
		this.userLicense = userLicense;
	}

	public List<UserLicenseAvailableServHistory> getUserLicenseServiceHistories() {
		if (userLicenseServiceHistories == null) {
			userLicenseServiceHistories = new ArrayList<>();
		}
		return userLicenseServiceHistories;
	}

	public void setUserLicenseServiceHistories(List<UserLicenseAvailableServHistory> userLicenseServiceHistories) {
		this.userLicenseServiceHistories = userLicenseServiceHistories;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* toString */
	@Override
	public String toString() {
		return "UserLicenseAvailableServ [id=" + id + ", availableService=" + availableService.getId()
				+ ", userLicense=" + userLicense.getId() + ", active=" + active + "]";
	}

}