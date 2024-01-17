package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "license_direct_promo"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_direct_promo", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_direct_promo_seq", allocationSize = 1)
@Getter
@Setter
public class LicenseDirectPromo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	@Column(name = "code")
	private String code;

	@Column(name = "discount")
	private Integer discount;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "due_date")
	private LocalDateTime dueDate;

	@Column(name = "used_in")
	private LocalDateTime usedIn;

	@Column(name = "available")
	private boolean available;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licenseDirectPromo", targetEntity = UserLicensePaymentHistory.class)
	@Getter(AccessLevel.NONE)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	public List<UserLicensePaymentHistory> getUserLicensePaymentHistories() {
		if (userLicensePaymentHistories == null) {
			userLicensePaymentHistories = new ArrayList<>();
		}
		return userLicensePaymentHistories;
	}

	/* toString */
	public String toString() {
		return "LicenseDirectPromo [id=" + id + ", userLicense=" + userLicense.getId() + ", code=" + code
				+ ", discount=" + discount + ", startDate=" + startDate + ", dueDate=" + dueDate + ", usedIn=" + usedIn
				+ ", available=" + available + ",  active=" + active + "]";
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
		LicenseDirectPromo that = (LicenseDirectPromo) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}