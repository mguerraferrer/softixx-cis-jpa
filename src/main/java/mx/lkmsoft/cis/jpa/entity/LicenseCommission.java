package mx.lkmsoft.cis.jpa.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.OnlinePayment;
import mx.lkmsoft.cis.jpa.enumtype.PaymentSource;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "license_commission"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_commission", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_commission_seq", allocationSize = 1)
@Getter
@Setter
public class LicenseCommission extends BaseEntity {

	@Column(name = "online_payment")
	@Enumerated(EnumType.STRING)
	private OnlinePayment onlinePayment;

	@Column(name = "payment_source")
	@Enumerated(EnumType.STRING)
	private PaymentSource paymentSource;

	@Column(name = "commission_percentage")
	private BigDecimal commissionPercentage;

	@Column(name = "commission")
	private BigDecimal commission;

	@Column(name = "tax")
	private boolean tax;

	@Column(name = "tax_percentage")
	private BigDecimal taxPercentage;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licenseCommission", targetEntity = UserLicensePaymentHistory.class)
	@Getter(AccessLevel.NONE)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	public List<UserLicensePaymentHistory> getUserLicensePaymentHistories() {
		if (userLicensePaymentHistories == null) {
			userLicensePaymentHistories = new ArrayList<>();
		}
		return userLicensePaymentHistories;
	}

	/* toString */
	@Override
	public String toString() {
		return "LicenseCommission [id=" + id + ", onlinePayment=" + onlinePayment + ", paymentSource="
				+ paymentSource + ", commissionPercentage=" + commissionPercentage + ", commission=" + commission
				+ ", tax=" + tax + ", taxPercentage=" + taxPercentage + ", active=" + active + "]";
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
		LicenseCommission that = (LicenseCommission) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}