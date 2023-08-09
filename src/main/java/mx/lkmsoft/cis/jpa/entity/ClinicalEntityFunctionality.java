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
 * Persistent class for entity stored in table "clinical_entity_functionality"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "clinical_entity_functionality", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_functionality_id_seq", allocationSize = 1)
public class ClinicalEntityFunctionality extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "functionality_id", referencedColumnName = "id")
	private Functionality functionality;

	@Column(name = "hash")
	private String hash;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntityFunctionality", targetEntity = RoleAccess.class)
	private List<RoleAccess> roleAccesses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntityFunctionality", targetEntity = UserAccess.class)
	private List<UserAccess> userAccesses;

	public ClinicalEntityFunctionality() {
	}

	public ClinicalEntityFunctionality(ClinicalEntity clinicalEntity, Functionality functionality) {
		this.clinicalEntity = clinicalEntity;
		this.functionality = functionality;
		this.hash = UUID.randomUUID().toString().replace("-", "");
		this.active = true;
	}

	/* Getters and Setters */
	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public Functionality getFunctionality() {
		return functionality;
	}

	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
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

	public List<RoleAccess> getRoleAccesses() {
		if (roleAccesses == null) {
			roleAccesses = new ArrayList<>();
		}
		return roleAccesses;
	}

	public void setRoleAccesses(List<RoleAccess> roleAccesses) {
		this.roleAccesses = roleAccesses;
	}

	public List<UserAccess> getUserAccesses() {
		if (userAccesses == null) {
			userAccesses = new ArrayList<>();
		}
		return userAccesses;
	}

	public void setUserAccesses(List<UserAccess> userAccesses) {
		this.userAccesses = userAccesses;
	}

	/* toString */
	@Override
	public String toString() {
		return "ClinicalEntityFunctionality [id=" + id + ", clinicalEntity=" + clinicalEntity.getId()
				+ ", functionality=" + functionality.getId() + ", hash=" + hash + ", active=" + active + "]";
	}

}