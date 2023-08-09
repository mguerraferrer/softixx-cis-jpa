package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "license_config"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_config", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_config_id_seq", allocationSize = 1)
public class LicenseConfig extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_id", referencedColumnName = "id")
	private License license;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_mode_id", referencedColumnName = "id")
	private PaymentMode paymentMode;

	@Column(name = "discount")
	private Integer discount;

	@Column(name = "active")
	private boolean active;

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

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
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
		return "LicenseConfig [id=" + id + ", license=" + license.getId() + ", paymentMode=" + paymentMode.getId() + ", discount="
				+ discount + ", active=" + active + "]";
	}

}