package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import mx.lkmsoft.cis.common.datetime.LocalDateUtils;

/**
 * Persistent class for entity stored in table "user_license"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license", schema = "sales")
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

	@Column(name = "activation_date")
	private LocalDateTime activationDate;

	@Column(name = "actualization_date")
	private LocalDateTime actualizationDate;

	@Column(name = "due_date")
	private LocalDate dueDate;

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

	public UserLicense() {
	}

	public UserLicense(User user, License license, String serie, LocalDate dueDate) {
		this.user = user;
		this.license = license;
		this.serie = serie;
		this.dueDate = dueDate;
	}

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Transient
	public boolean isActive() {
		return LocalDateUtils.isFutureOrPresent(dueDate);
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

	/* toString */
	@Override
	public String toString() {
		return "UserLicense [id=" + id + ", user=" + user.getId() + ", license=" + license.getId() + ", serie=" + serie
				+ ", activationDate=" + activationDate + ", actualizationDate=" + actualizationDate + ", dueDate="
				+ dueDate + ", active=" + isActive() + "]";
	}

}