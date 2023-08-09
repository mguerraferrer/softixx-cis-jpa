package mx.lkmsoft.cis.jpa.entity;

import java.math.BigDecimal;
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
 * Persistent class for entity stored in table "license_commission"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_commission", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_commission_id_seq", allocationSize = 1)
public class LicenseCommission extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "online_payment_id", referencedColumnName = "id")
	private OnlinePayment onlinePayment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_source_id", referencedColumnName = "id")
	private PaymentSource paymentSource;

	@Column(name = "comission_percentage")
	private BigDecimal comissionPercentage;

	@Column(name = "comission")
	private BigDecimal comission;

	@Column(name = "tax")
	private boolean tax;

	@Column(name = "tax_percentage")
	private BigDecimal taxPercentage;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licenseCommission", targetEntity = UserLicensePaymentHistory.class)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	/* Getters and Setters */
	public OnlinePayment getOnlinePayment() {
		return onlinePayment;
	}

	public void setOnlinePayment(OnlinePayment onlinePayment) {
		this.onlinePayment = onlinePayment;
	}

	public PaymentSource getPaymentSource() {
		return paymentSource;
	}

	public void setPaymentSource(PaymentSource paymentSource) {
		this.paymentSource = paymentSource;
	}

	public BigDecimal getComissionPercentage() {
		return comissionPercentage;
	}

	public void setComissionPercentage(BigDecimal comissionPercentage) {
		this.comissionPercentage = comissionPercentage;
	}

	public BigDecimal getComission() {
		return comission;
	}

	public void setComission(BigDecimal comission) {
		this.comission = comission;
	}

	public boolean isTax() {
		return tax;
	}

	public void setTax(boolean tax) {
		this.tax = tax;
	}

	public BigDecimal getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(BigDecimal taxPercentage) {
		this.taxPercentage = taxPercentage;
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
		return "LicenseCommission [id=" + id + ", onlinePayment=" + onlinePayment.getId() + ", paymentSource="
				+ paymentSource.getId() + ", comissionPercentage=" + comissionPercentage + ", comission=" + comission
				+ ", tax=" + tax + ", taxPercentage=" + taxPercentage + ", active=" + active + "]";
	}

}