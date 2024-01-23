package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.PaymentMode;
import mx.lkmsoft.cis.jpa.enumtype.PaymentSource;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

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

	@Column(name = "license_serie")
	private String licenseSerie;

	@Column(name = "promo_code")
	private String promoCode;

	@Column(name = "direct_promo_code")
	private String directPromoCode;

	@Column(name = "payment_description")
	private String paymentDescription;

	@Column(name = "payment_mode")
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;

	@Column(name = "payment_source")
	@Enumerated(EnumType.STRING)
	private PaymentSource paymentSource;

	@Column(name = "payment_date")
	private LocalDateTime paymentDate;

	@Column(name = "payment_subtotal")
	private BigDecimal paymentSubtotal;

	@Column(name = "payment_tax")
	private BigDecimal paymentTax;

	@Column(name = "payment_discount")
	private Integer paymentDiscount;

	@Column(name = "payment_applied_discount")
	private BigDecimal paymentAppliedDiscount;

	@Column(name = "payment_grand_subtotal")
	private BigDecimal paymentGrandSubtotal;

	@Column(name = "payment_total")
	private BigDecimal paymentTotal;

	@Column(name = "payment_total_in_cents")
	private BigDecimal paymentTotalInCents;

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "transaction_ip")
	private String transactionIp;

	@Column(name = "transaction_currency")
	private String transactionCurrency;

	@Column(name = "transaction_card_id")
	private String transactionCardId;

	@Column(name = "transaction_card_zip_code")
	private String transactionCardZipCode;

	@Column(name = "transaction_card_brand")
	private String transactionCardBrand;

	@Column(name = "transaction_card_last4")
	private String transactionCardLast4;

	@Column(name = "transaction_receipt_url")
	private String transactionReceiptUrl;

	/* toString */
	@Override
	public String toString() {
		return "UserLicensePaymentHistory{" +
				"id=" + id +
				", licenseSerie=" + licenseSerie +
				", promoCode=" + promoCode +
				", directPromoCode=" + directPromoCode +
				", paymentDescription='" + paymentDescription +
				", paymentMode=" + paymentMode +
				", paymentSource=" + paymentSource +
				", paymentDate=" + paymentDate +
				", paymentSubtotal=" + paymentSubtotal +
				", paymentTax=" + paymentTax +
				", paymentDiscount=" + paymentDiscount +
				", paymentAppliedDiscount=" + paymentAppliedDiscount +
				", paymentGrandSubtotal=" + paymentGrandSubtotal +
				", paymentTotal=" + paymentTotal +
				", paymentTotalInCents=" + paymentTotalInCents +
				", transactionId='" + transactionId +
				", transactionIp='" + transactionIp +
				", transactionCurrency='" + transactionCurrency +
				", transactionCardId='" + transactionCardId +
				", transactionCardZipCode='" + transactionCardZipCode +
				", transactionCardBrand='" + transactionCardBrand +
				", transactionCardLast4='" + transactionCardLast4 +
				", transactionReceiptUrl='" + transactionReceiptUrl +
				'}';
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