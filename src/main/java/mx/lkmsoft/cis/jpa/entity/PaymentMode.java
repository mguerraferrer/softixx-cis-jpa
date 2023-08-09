package mx.lkmsoft.cis.jpa.entity;

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
 * Persistent class for entity stored in table "payment_mode"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "payment_mode", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.payment_mode_id_seq", allocationSize = 1)
public class PaymentMode extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;

	@Column(name = "value")
	private Integer value;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMode", targetEntity = LicenseConfig.class)
	private List<LicenseConfig> licenseConfigs;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMode", targetEntity = LicensePromo.class)
	private List<LicensePromo> licensePromos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMode", targetEntity = UserLicenseFrequentlyPayment.class)
	private List<UserLicenseFrequentlyPayment> userLicenseFrequentlyPayments;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMode", targetEntity = UserLicensePaymentHistory.class)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<LicenseConfig> getLicenseConfigs() {
		if (licenseConfigs == null) {
			licenseConfigs = new ArrayList<>();
		}
		return licenseConfigs;
	}

	public void setLicenseConfigs(List<LicenseConfig> licenseConfigs) {
		this.licenseConfigs = licenseConfigs;
	}

	public List<LicensePromo> getLicensePromos() {
		if (licensePromos == null) {
			licensePromos = new ArrayList<>();
		}
		return licensePromos;
	}

	public void setLicensePromos(List<LicensePromo> licensePromos) {
		this.licensePromos = licensePromos;
	}

	public List<UserLicenseFrequentlyPayment> getUserLicenseFrequentlyPayments() {
		if (userLicenseFrequentlyPayments == null) {
			userLicenseFrequentlyPayments = new ArrayList<>();
		}
		return userLicenseFrequentlyPayments;
	}

	public void setUserLicenseFrequentlyPayments(List<UserLicenseFrequentlyPayment> userLicenseFrequentlyPayments) {
		this.userLicenseFrequentlyPayments = userLicenseFrequentlyPayments;
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
		return "PaymentMode [id=" + id + ", code=" + code + ", description=" + description + ", value=" + value
				+ ", active=" + active + "]";
	}

}