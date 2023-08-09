package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "license_direct_promo"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_direct_promo", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_direct_promo_id_seq", allocationSize = 1)
public class LicenseDirectPromo extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "discount")
	private Integer discount;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "due_date")
	private LocalDateTime dueDate;

	@Column(name = "used_in")
	private LocalDateTime usedIn;

	@Column(name = "available")
	private boolean available;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licenseDirectPromo", targetEntity = UserLicensePaymentHistory.class)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDateTime getUsedIn() {
		return usedIn;
	}

	public void setUsedIn(LocalDateTime usedIn) {
		this.usedIn = usedIn;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<UserLicensePaymentHistory> getUserLicensePaymentHistories() {
		if (userLicensePaymentHistories == null) {
			userLicensePaymentHistories = new ArrayList<>();
		}
		return userLicensePaymentHistories;
	}

	public void setUserLicensePaymentHistories(List<UserLicensePaymentHistory> userLicensePaymentHistories) {
		this.userLicensePaymentHistories = userLicensePaymentHistories;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(code);
		sb.append("|");
		sb.append(discount);
		sb.append("|");
		sb.append(startDate);
		sb.append("|");
		sb.append(dueDate);
		sb.append("|");
		sb.append(usedIn);
		sb.append("|");
		sb.append(available);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}