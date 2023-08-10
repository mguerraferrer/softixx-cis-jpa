package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.PaymentMode;

/**
 * Persistent class for entity stored in table "user_license_payment_frequently"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license_payment_frequently", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_payment_frequently_id_seq", allocationSize = 1)
public class UserLicenseFrequentlyPayment extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	@Column(name = "payment_mode")
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;

	@Column(name = "next_payment")
	private LocalDateTime nextPayment;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
	public UserLicense getUserLicense() {
		return userLicense;
	}

	public void setUserLicense(UserLicense userLicense) {
		this.userLicense = userLicense;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public LocalDateTime getNextPayment() {
		return nextPayment;
	}

	public void setNextPayment(LocalDateTime nextPayment) {
		this.nextPayment = nextPayment;
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
		return "UserLicenseFrequentlyPayment [id=" + id + ", userLicense=" + userLicense.getId() + ", paymentMode="
				+ paymentMode + ", nextPayment=" + nextPayment + ", active=" + active + "]";
	}

}