package mx.lkmsoft.cis.jpa.entity;

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
import mx.lkmsoft.cis.jpa.enumtype.LicenseType;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "license"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_seq", allocationSize = 1)
@Getter
@Setter
public class License extends BaseEntity {

	@Column(name = "license_type")
	@Enumerated(EnumType.STRING)
	private LicenseType licenseType;

	@Column(name = "total_specialties")
	private Integer totalSpecialties;

	@Column(name = "total_doctors")
	private Integer totalDoctors;

	@Column(name = "total_assistants")
	private Integer totalAssistants;

	@Column(name = "total_nurses")
	private Integer totalNurses;

	@Column(name = "daily_consultations")
	private Integer dailyConsultations;

	@Column(name = "duration")
	private Integer duration;

	@Column(name = "description")
	private String description;

	@Column(name = "level")
	private Integer level;

	@Column(name = "code")
	private String code;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "license", targetEntity = LicenseConfig.class)
	@Getter(AccessLevel.NONE)
	private List<LicenseConfig> licenseConfigs;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "license", targetEntity = UserLicense.class)
	@Getter(AccessLevel.NONE)
	private List<UserLicense> userLicenses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "license", targetEntity = LicenseAvailableItem.class)
	@Getter(AccessLevel.NONE)
	private List<LicenseAvailableItem> licenseAvailableItems;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "license", targetEntity = LicensePrice.class)
	@Getter(AccessLevel.NONE)
	private List<LicensePrice> licensePrices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "license", targetEntity = LicensePromo.class)
	@Getter(AccessLevel.NONE)
	private List<LicensePromo> licensePromos;

	public List<LicenseConfig> getLicenseConfigs() {
		if (licenseConfigs == null) {
			licenseConfigs = new ArrayList<>();
		}
		return licenseConfigs;
	}

	public List<UserLicense> getUserLicenses() {
		if (userLicenses == null) {
			userLicenses = new ArrayList<>();
		}
		return userLicenses;
	}

	public List<LicenseAvailableItem> getLicenseAvailableItems() {
		if (licenseAvailableItems == null) {
			licenseAvailableItems = new ArrayList<>();
		}
		return licenseAvailableItems;
	}

	public List<LicensePrice> getLicensePrices() {
		if (licensePrices == null) {
			licensePrices = new ArrayList<>();
		}
		return licensePrices;
	}

	public List<LicensePromo> getLicensePromos() {
		if (licensePromos == null) {
			licensePromos = new ArrayList<>();
		}
		return licensePromos;
	}

	/* toString */
	@Override
	public String toString() {
		return "License [id=" + id + ", licenseType=" + licenseType + ", totalSpecialties=" + totalSpecialties
				+ ", totalDoctors=" + totalDoctors + ", totalAssistants=" + totalAssistants + ", totalNurses="
				+ totalNurses + ", dailyConsultations=" + dailyConsultations + ", duration=" + duration
				+ ", description=" + description + ", level=" + level + ", code=" + code + ", active=" + active + "]";
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
		License license = (License) o;
		return getId() != null && Objects.equals(getId(), license.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}