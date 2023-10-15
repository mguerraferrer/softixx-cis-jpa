package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.LicenseType;

/**
 * Persistent class for entity stored in table "license"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_seq", allocationSize = 1)
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
	private List<LicenseConfig> licenseConfigs;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "license", targetEntity = UserLicense.class)
	private List<UserLicense> userLicenses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "license", targetEntity = LicenseAvailableService.class)
	private List<LicenseAvailableService> licenseAvailableServices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "license", targetEntity = LicensePrice.class)
	private List<LicensePrice> licensePrices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "license", targetEntity = LicensePromo.class)
	private List<LicensePromo> licensePromos;

	/* Getters and Setters */
	public LicenseType getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(LicenseType licenseType) {
		this.licenseType = licenseType;
	}

	public Integer getTotalSpecialties() {
		return totalSpecialties;
	}

	public void setTotalSpecialties(Integer totalSpecialties) {
		this.totalSpecialties = totalSpecialties;
	}

	public Integer getTotalDoctors() {
		return totalDoctors;
	}

	public void setTotalDoctors(Integer totalDoctors) {
		this.totalDoctors = totalDoctors;
	}

	public Integer getTotalAssistants() {
		return totalAssistants;
	}

	public void setTotalAssistants(Integer totalAssistants) {
		this.totalAssistants = totalAssistants;
	}

	public Integer getTotalNurses() {
		return totalNurses;
	}

	public void setTotalNurses(Integer totalNurses) {
		this.totalNurses = totalNurses;
	}

	public Integer getDailyConsultations() {
		return dailyConsultations;
	}

	public void setDailyConsultations(Integer dailyConsultations) {
		this.dailyConsultations = dailyConsultations;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setHash(String code) {
		this.code = code;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<LicenseConfig> getLicenseConfigs() {
		if (licenseConfigs == null) {
			licenseConfigs = new ArrayList<>();
		}
		return licenseConfigs;
	}

	public void setLicenseConfigs(List<LicenseConfig> licenseConfigs) {
		this.licenseConfigs = licenseConfigs;
	}

	public List<UserLicense> getUserLicenses() {
		if (userLicenses == null) {
			userLicenses = new ArrayList<>();
		}
		return userLicenses;
	}

	public void setUserLicenses(List<UserLicense> userLicenses) {
		this.userLicenses = userLicenses;
	}

	public List<LicenseAvailableService> getLicenseAvailableServices() {
		if (licenseAvailableServices == null) {
			licenseAvailableServices = new ArrayList<>();
		}
		return licenseAvailableServices;
	}

	public void setLicenseAvailableServices(List<LicenseAvailableService> licenseAvailableServices) {
		this.licenseAvailableServices = licenseAvailableServices;
	}

	public List<LicensePrice> getLicensePrices() {
		if (licensePrices == null) {
			licensePrices = new ArrayList<>();
		}
		return licensePrices;
	}

	public void setLicensePrices(List<LicensePrice> licensePrices) {
		this.licensePrices = licensePrices;
	}

	public List<LicensePromo> getLicensePromos() {
		if (licensePromos == null) {
			licensePromos = new ArrayList<>();
		}
		return licensePromos;
	}

	public void setLicensePromos(List<LicensePromo> licensePromos) {
		this.licensePromos = licensePromos;
	}

	/* toString */
	@Override
	public String toString() {
		return "License [id=" + id + ", licenseType=" + licenseType + ", totalSpecialties=" + totalSpecialties
				+ ", totalDoctors=" + totalDoctors + ", totalAssistants=" + totalAssistants + ", totalNurses="
				+ totalNurses + ", dailyConsultations=" + dailyConsultations + ", duration=" + duration
				+ ", description=" + description + ", level=" + level + ", code=" + code + ", active=" + active + "]";
	}

}