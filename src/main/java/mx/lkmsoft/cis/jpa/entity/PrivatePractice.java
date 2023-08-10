package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
 * Persistent class for entity stored in table "private_practice"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "private_practice", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.private_practice_id_seq", allocationSize = 1)
public class PrivatePractice extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@Column(name = "hash")
	private String hash;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privatePractice", targetEntity = PrivatePracticeConsultationProcedure.class)
	private List<PrivatePracticeConsultationProcedure> privatePracticeConsultationProcedures;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privatePractice", targetEntity = PrivatePracticeAddress.class)
	private List<PrivatePracticeAddress> privatePracticeAddresses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privatePractice", targetEntity = PrivatePracticeFunctionality.class)
	private List<PrivatePracticeFunctionality> privatePracticeFunctionalities;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privatePractice", targetEntity = MasterAccount.class)
	private List<MasterAccount> masterAccounts;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privatePractice", targetEntity = PersonAccess.class)
	private List<PersonAccess> personAccesses;

	public PrivatePractice() {
	}

	public PrivatePractice(Doctor doctor, boolean active) {
		this.doctor = doctor;
		this.hash = UUID.randomUUID().toString().replace("-", "");
		this.active = active;
	}

	/* Getters and Setters */
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<PrivatePracticeConsultationProcedure> getPrivatePracticeServices() {
		if (privatePracticeConsultationProcedures == null) {
			privatePracticeConsultationProcedures = new ArrayList<>();
		}
		return privatePracticeConsultationProcedures;
	}

	public void setPrivatePracticeServices(List<PrivatePracticeConsultationProcedure> privatePracticeConsultationProcedures) {
		this.privatePracticeConsultationProcedures = privatePracticeConsultationProcedures;
	}

	public List<PrivatePracticeAddress> getPrivatePracticeAddresses() {
		if (privatePracticeAddresses == null) {
			privatePracticeAddresses = new ArrayList<>();
		}
		return privatePracticeAddresses;
	}

	public void setPrivatePracticeAddresses(List<PrivatePracticeAddress> privatePracticeAddresses) {
		this.privatePracticeAddresses = privatePracticeAddresses;
	}

	public List<PrivatePracticeFunctionality> getPrivatePracticeFunctionalities() {
		if (privatePracticeFunctionalities == null) {
			privatePracticeFunctionalities = new ArrayList<>();
		}
		return privatePracticeFunctionalities;
	}

	public void setPrivatePracticeFunctionalities(List<PrivatePracticeFunctionality> privatePracticeFunctionalities) {
		this.privatePracticeFunctionalities = privatePracticeFunctionalities;
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
	
	public List<PersonAccess> getPersonAccesses() {
		if (personAccesses == null) {
			personAccesses = new ArrayList<>();
		}
		return personAccesses;
	}

	public void setPersonAccesses(List<PersonAccess> personAccesses) {
		this.personAccesses = personAccesses;
	}

	/* toString */
	@Override
	public String toString() {
		return "PrivatePractice [id=" + id + ", doctor=" + doctor + ", hash=" + hash + ", active=" + active + "]";
	}
	
}