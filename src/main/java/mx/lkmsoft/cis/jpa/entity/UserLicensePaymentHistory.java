package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.PaymentMode;
import mx.lkmsoft.cis.jpa.enumtype.PaymentSource;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "user_license_payment_history"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license_payment_history", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_payment_history_seq", allocationSize = 1)
@Getter
@Setter
public class UserLicensePaymentHistory extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "payment_mode")
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;

	@Column(name = "payment_source")
	@Enumerated(EnumType.STRING)
	private PaymentSource paymentSource;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_promo_id", referencedColumnName = "id")
	private LicensePromo licensePromo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_direct_promo_id", referencedColumnName = "id")
	private LicenseDirectPromo licenseDirectPromo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_commission_id", referencedColumnName = "id")
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

	@Column(name = "total_commission")
	private Double totalCommission;

	@Column(name = "total_services")
	private Double totalServices;

	@Column(name = "total")
	private Double total;

	/* toString */
	@Override
	public String toString() {
		long licensePromoId = licensePromo != null ? licensePromo.getId() : null;
		long licenseDirectPromoId = licenseDirectPromo != null ? licenseDirectPromo.getId() : null;
		long licenseCommissionId = licenseCommission != null ? licenseCommission.getId() : null;

		return "UserLicensePaymentHistory [id=" + id + ", userLicense=" + userLicense.getId() + ", transactionId="
				+ transactionId + ", paymentMode=" + paymentMode + ", paymentSource=" + paymentSource
				+ ", licensePromo=" + licensePromoId + ", licenseDirectPromo=" + licenseDirectPromoId
				+ ", licenseCommission=" + licenseCommissionId + ", paymentDate=" + paymentDate + ", reference="
				+ reference + ", currency=" + currency + ", discountCode=" + discountCode + ", subtotal=" + subtotal
				+ ", tax=" + tax + ", discount=" + discount + ", totalCommission=" + totalCommission + ", totalServices="
				+ totalServices + ", total=" + total + "]";
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		UserLicensePaymentHistory that = (UserLicensePaymentHistory) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}