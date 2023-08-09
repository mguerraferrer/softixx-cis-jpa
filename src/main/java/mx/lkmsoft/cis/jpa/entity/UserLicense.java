package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "user_license"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_id_seq", allocationSize = 1)
public class UserLicense extends BaseEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "license_id", referencedColumnName = "id")
	private License license;

	@Column(name = "serie")
	private String serie;

	@Column(name = "activation_date")
	private LocalDateTime activationDate;

	@Column(name = "actualization_date")
	private LocalDateTime actualizationDate;

	@Column(name = "due_date")
	private LocalDate dueDate;

	@Column(name = "private_practice")
	private boolean privatePractice;

	@Column(name = "clinical_entity")
	private boolean clinicalEntity;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicensePaymentHistory.class)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseAvailableServ.class)
	private List<UserLicenseAvailableServ> userLicenseServices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseChangeHistory.class)
	private List<UserLicenseChangeHistory> userLicenseChangeHistories;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseFrequentlyPayment.class)
	private List<UserLicenseFrequentlyPayment> userLicenseFrequentlyPayments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = UserLicenseEditionHistory.class)
	private List<UserLicenseEditionHistory> userLicenseEditionHistories;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicense", targetEntity = MasterAccount.class)
	private List<MasterAccount> masterAccounts;

	public UserLicense() {
	}

	public UserLicense(License license, User user, String serie, LocalDate dueDate) {
		this.license = license;
		this.user = user;
		this.serie = serie;
		this.dueDate = dueDate;
	}

	/* Getters and Setters */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public LocalDateTime getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(LocalDateTime activationDate) {
		this.activationDate = activationDate;
	}

	public LocalDateTime getActualizationDate() {
		return actualizationDate;
	}

	public void setActualizationDate(LocalDateTime actualizationDate) {
		this.actualizationDate = actualizationDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(boolean privatePractice) {
		this.privatePractice = privatePractice;
	}

	public boolean isClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(boolean clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<UserLicensePaymentHistory> getUserLicensePaymentHistories() {
		if (userLicensePaymentHistories == null) {
			userLicensePaymentHistories = new ArrayList<>();
		}
		return userLicensePaymentHistories;
	}

	public void setUserLicensePaymentHistories(List<UserLicensePaymentHistory> userLicensePaymentHistories) {
		this.userLicensePaymentHistories = userLicensePaymentHistories;
	}

	public List<UserLicenseAvailableServ> getUserLicenseServices() {
		if (userLicenseServices == null) {
			userLicenseServices = new ArrayList<>();
		}
		return userLicenseServices;
	}

	public void setUserLicenseServices(List<UserLicenseAvailableServ> userLicenseServices) {
		this.userLicenseServices = userLicenseServices;
	}

	public List<UserLicenseChangeHistory> getUserLicenseChangeHistories() {
		if (userLicenseChangeHistories == null) {
			userLicenseChangeHistories = new ArrayList<>();
		}
		return userLicenseChangeHistories;
	}

	public void setUserLicenseChangeHistories(List<UserLicenseChangeHistory> userLicenseChangeHistories) {
		this.userLicenseChangeHistories = userLicenseChangeHistories;
	}

	public List<UserLicenseFrequentlyPayment> getUserLicenseFrequentlyPayments() {
		if (userLicenseFrequentlyPayments == null) {
			userLicenseFrequentlyPayments = new ArrayList<>();
		}
		return userLicenseFrequentlyPayments;
	}

	public void setUserLicenseFrequentlyPayments(List<UserLicenseFrequentlyPayment> userLicenseFrequentlyPayments) {
		this.userLicenseFrequentlyPayments = userLicenseFrequentlyPayments;
	}

	public List<UserLicenseEditionHistory> getUserLicenseEditionHistories() {
		if (userLicenseEditionHistories == null) {
			userLicenseEditionHistories = new ArrayList<>();
		}
		return userLicenseEditionHistories;
	}

	public void setUserLicenseEditionHistories(List<UserLicenseEditionHistory> userLicenseEditionHistories) {
		this.userLicenseEditionHistories = userLicenseEditionHistories;
	}

	public List<MasterAccount> getMasterAccounts() {
		if (masterAccounts == null) {
			masterAccounts = new ArrayList<>();
		}
		return masterAccounts;
	}

	public void setMasterAccounts(List<MasterAccount> masterAccounts) {
		this.masterAccounts = masterAccounts;
	}

	/* toString */
	@Override
	public String toString() {
		return "UserLicense [id=" + id + ", user=" + user.getId() + ", license=" + license.getId() + ", serie=" + serie
				+ ", activationDate=" + activationDate + ", actualizationDate=" + actualizationDate + ", dueDate="
				+ dueDate + ", privatePractice=" + privatePractice + ", clinicalEntity=" + clinicalEntity + ", active="
				+ active + "]";
	}

}