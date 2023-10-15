package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.PaymentMode;

/**
 * Persistent class for entity stored in table "license_promo"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_promo", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_promo_seq", allocationSize = 1)
public class LicensePromo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_id", referencedColumnName = "id")
	private License license;

	@Column(name = "payment_mode")
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;

	@Column(name = "code")
	private String code;

	@Column(name = "discount")
	private Integer discount;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "due_date")
	private LocalDateTime dueDate;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licensePromo", targetEntity = UserLicensePaymentHistory.class)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	/* Getters and Setters */
	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

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
	@Override
	public String toString() {
		return "LicensePromo [id=" + id + ", license=" + license.getId() + ", paymentMode=" + paymentMode + ", code="
				+ code + ", discount=" + discount + ", startDate=" + startDate + ", dueDate=" + dueDate + ", active="
				+ active + "]";
	}

}