package mx.lkmsoft.cis.jpa.entity;

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
 * Persistent class for entity stored in table "master_account"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "master_account", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.master_account_id_seq", allocationSize = 1)
public class MasterAccount extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_id", referencedColumnName = "id")
	private PrivatePractice privatePractice;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterAccount", targetEntity = AssociatedAccount.class)
	private List<AssociatedAccount> associatedAccounts;

	public MasterAccount() {
	}

	public MasterAccount(PrivatePractice privatePractice, ClinicalEntity clinicalEntity, UserLicense userLicense) {
		this.privatePractice = privatePractice;
		this.clinicalEntity = clinicalEntity;
		this.userLicense = userLicense;
		this.active = false;
	}

	/* Getters and Setters */
	public UserLicense getUserLicense() {
		return userLicense;
	}

	public void setUserLicense(UserLicense userLicense) {
		this.userLicense = userLicense;
	}

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public PrivatePractice getPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(PrivatePractice privatePractice) {
		this.privatePractice = privatePractice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<AssociatedAccount> getAssociatedAccounts() {
		if (associatedAccounts == null) {
			associatedAccounts = new ArrayList<>();
		}
		return associatedAccounts;
	}

	public void setAssociatedAccounts(List<AssociatedAccount> associatedAccounts) {
		this.associatedAccounts = associatedAccounts;
	}

	/* toString */
	@Override
	public String toString() {
		return "MasterAccount [id=" + id + ", userLicense=" + userLicense + ", clinicalEntity=" + clinicalEntity
				+ ", privatePractice=" + privatePractice + ", active=" + active + "]";
	}

}