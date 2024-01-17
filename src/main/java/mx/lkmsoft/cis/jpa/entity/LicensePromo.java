package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.PaymentMode;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "license_promo"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_promo", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_promo_seq", allocationSize = 1)
@Getter
@Setter
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
	@Getter(AccessLevel.NONE)
	private Integer discount;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "due_date")
	private LocalDateTime dueDate;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licensePromo", targetEntity = UserLicensePaymentHistory.class)
	@Getter(AccessLevel.NONE)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	public Integer getDiscount() {
		return discount != null ? discount : 0;
	}

	public List<UserLicensePaymentHistory> getUserLicensePaymentHistories() {
		if (userLicensePaymentHistories == null) {
			userLicensePaymentHistories = new ArrayList<>();
		}
		return userLicensePaymentHistories;
	}

	/* toString */
	@Override
	public String toString() {
		return "LicensePromo [id=" + id + ", license=" + license.getId() + ", paymentMode=" + paymentMode + ", code="
				+ code + ", discount=" + discount + ", startDate=" + startDate + ", dueDate=" + dueDate + ", active="
				+ active + "]";
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
		LicensePromo that = (LicensePromo) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}