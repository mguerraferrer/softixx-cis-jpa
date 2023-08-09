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
 * Persistent class for entity stored in table "user_license_payment_history"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license_payment_history", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_payment_history_id_seq", allocationSize = 1)
public class UserLicensePaymentHistory extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	@Column(name = "transaction_id")
	private String transactionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_mode_id", referencedColumnName = "id")
	private PaymentMode paymentMode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_source_id", referencedColumnName = "id")
	private PaymentSource paymentSource;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_promo_id", referencedColumnName = "id")
	private LicensePromo licensePromo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_direct_promo_id", referencedColumnName = "id")
	private LicenseDirectPromo licenseDirectPromo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_comission_id", referencedColumnName = "id")
	private LicenseCommission licenseCommission;

	@Column(name = "payment_day")
	private LocalDateTime paymentDate;

	@Column(name = "reference")
	private String reference;

	@Column(name = "currency")
	private String currency;

	@Column(name = "discount_code")
	private String discountCode;

	@Column(name = "subtotal")
	private Double subtotal;

	@Column(name = "tax")
	private Double tax;

	@Column(name = "discount")
	private Double discount;

	@Column(name = "total_comission")
	private Double totalComission;

	@Column(name = "total_services")
	private Double totalServices;

	@Column(name = "total")
	private Double total;

	/* Getters and Setters */
	public UserLicense getUserLicense() {
		return userLicense;
	}

	public void setUserLicense(UserLicense userLicense) {
		this.userLicense = userLicense;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public PaymentSource getPaymentSource() {
		return paymentSource;
	}

	public void setPaymentSource(PaymentSource paymentSource) {
		this.paymentSource = paymentSource;
	}

	public LicensePromo getLicensePromo() {
		return licensePromo;
	}

	public void setLicensePromo(LicensePromo licensePromo) {
		this.licensePromo = licensePromo;
	}

	public LicenseDirectPromo getLicenseDirectPromo() {
		return licenseDirectPromo;
	}

	public void setLicenseDirectPromo(LicenseDirectPromo licenseDirectPromo) {
		this.licenseDirectPromo = licenseDirectPromo;
	}

	public LicenseCommission getLicenseCommission() {
		return licenseCommission;
	}

	public void setLicenseCommission(LicenseCommission licenseCommission) {
		this.licenseCommission = licenseCommission;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTotalComission() {
		return totalComission;
	}

	public void setTotalComission(Double totalComission) {
		this.totalComission = totalComission;
	}

	public Double getTotalServices() {
		return totalServices;
	}

	public void setTotalServices(Double totalServices) {
		this.totalServices = totalServices;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	/* toString */
	@Override
	public String toString() {
		long paymentModeId = paymentMode != null ? paymentMode.getId() : null;
		long paymentSourceId = paymentSource != null ? paymentSource.getId() : null;
		long licensePromoId = licensePromo != null ? licensePromo.getId() : null;
		long licenseDirectPromoId = licenseDirectPromo != null ? licenseDirectPromo.getId() : null;
		long licenseCommissionId = licenseCommission != null ? licenseCommission.getId() : null;

		return "UserLicensePaymentHistory [id=" + id + ", userLicense=" + userLicense.getId() + ", transactionId="
				+ transactionId + ", paymentMode=" + paymentModeId + ", paymentSource=" + paymentSourceId
				+ ", licensePromo=" + licensePromoId + ", licenseDirectPromo=" + licenseDirectPromoId
				+ ", licenseCommission=" + licenseCommissionId + ", paymentDate=" + paymentDate + ", reference="
				+ reference + ", currency=" + currency + ", discountCode=" + discountCode + ", subtotal=" + subtotal
				+ ", tax=" + tax + ", discount=" + discount + ", totalComission=" + totalComission + ", totalServices="
				+ totalServices + ", total=" + total + "]";
	}

}