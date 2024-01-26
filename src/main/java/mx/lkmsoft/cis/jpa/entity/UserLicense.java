package mx.lkmsoft.cis.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.datetime.LocalDateUtils;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "user_license"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license", schema = "sales")
@Getter
@Setter
public class UserLicense {

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_id", referencedColumnName = "id")
	private License license;

	@Column(name = "serie")
	private String serie;

	@Column(name = "custom_price")
	private BigDecimal customPrice;

	@Column(name = "activation_date")
	private LocalDateTime activationDate;

	@Column(name = "actualization_date")
	private LocalDateTime actualizationDate;

	@Column(name = "due_date")
	private LocalDate dueDate;

	@org.springframework.data.annotation.Version
	private Long version;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseAvailableItem.class)
	@Getter(AccessLevel.NONE)
	private List<UserLicenseAvailableItem> userLicenseServices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseChangeHistory.class)
	@Getter(AccessLevel.NONE)
	private List<UserLicenseChangeHistory> userLicenseChangeHistories;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseFrequentlyPayment.class)
	@Getter(AccessLevel.NONE)
	private List<UserLicenseFrequentlyPayment> userLicenseFrequentlyPayments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = LicenseDirectPromo.class)
	@Getter(AccessLevel.NONE)
	private List<LicenseDirectPromo> licenseDirectPromos;

	public UserLicense() {
	}

	public UserLicense(User user, License license, String serie, LocalDate dueDate) {
		this.user = user;
		this.license = license;
		this.serie = serie;
		this.dueDate = dueDate;
	}

	public UserLicense(User user, License license, String serie, BigDecimal customPrice, LocalDate dueDate) {
		this.user = user;
		this.license = license;
		this.serie = serie;
		this.customPrice = customPrice;
		this.dueDate = dueDate;
	}

	@Transient
	public boolean isActive() {
		return LocalDateUtils.isFutureOrPresent(dueDate);
	}

	public List<UserLicenseAvailableItem> getUserLicenseServices() {
		if (userLicenseServices == null) {
			userLicenseServices = new ArrayList<>();
		}
		return userLicenseServices;
	}

	public List<UserLicenseChangeHistory> getUserLicenseChangeHistories() {
		if (userLicenseChangeHistories == null) {
			userLicenseChangeHistories = new ArrayList<>();
		}
		return userLicenseChangeHistories;
	}

	public List<UserLicenseFrequentlyPayment> getUserLicenseFrequentlyPayments() {
		if (userLicenseFrequentlyPayments == null) {
			userLicenseFrequentlyPayments = new ArrayList<>();
		}
		return userLicenseFrequentlyPayments;
	}

	public List<LicenseDirectPromo> getLicenseDirectPromos() {
		if (licenseDirectPromos == null) {
			licenseDirectPromos = new ArrayList<>();
		}
		return licenseDirectPromos;
	}

	/* toString */
	@Override
	public String toString() {
		return "UserLicense [id=" + id + ", user=" + user.getId() + ", license=" + license.getId() + ", serie=" + serie
				+ ", customPrice= " + customPrice + ", activationDate=" + activationDate + ", actualizationDate="
				+ actualizationDate + ", dueDate=" + dueDate + ", active=" + isActive() + "]";
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
		UserLicense that = (UserLicense) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}