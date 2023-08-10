package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

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
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.AccessLevel;

/**
 * Persistent class for entity stored in table "clinical_entity_access_info"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "clinical_entity_access_info", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_access_info_id_seq", allocationSize = 1)
public class ClinicalEntityAccessInfo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_profile_id", referencedColumnName = "id")
	private UserProfile userProfile;

	@Column(name = "access_level")
	@Enumerated(EnumType.STRING)
	private AccessLevel accessLevel;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clinicalEntityAccessInfo", targetEntity = ClinicalEntityEmploymentInfo.class)
	private List<ClinicalEntityEmploymentInfo> clinicalEntityEmploymentInfos;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clinicalEntityAccessInfo", targetEntity = ClinicalEntityConnectionInfo.class)
	private List<ClinicalEntityConnectionInfo> clinicalEntityConnectionInfos;

	/* Getters and Setters */
	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<ClinicalEntityEmploymentInfo> getClinicalEntityEmploymentInfos() {
		if (clinicalEntityEmploymentInfos == null) {
			clinicalEntityEmploymentInfos = new ArrayList<>();
		}
		return clinicalEntityEmploymentInfos;
	}

	public void setClinicalEntityEmploymentInfos(List<ClinicalEntityEmploymentInfo> clinicalEntityEmploymentInfos) {
		this.clinicalEntityEmploymentInfos = clinicalEntityEmploymentInfos;
	}

	public List<ClinicalEntityConnectionInfo> getClinicalEntityConnectionInfos() {
		if (clinicalEntityConnectionInfos == null) {
			clinicalEntityConnectionInfos = new ArrayList<>();
		}
		return clinicalEntityConnectionInfos;
	}

	public void setClinicalEntityConnectionInfos(List<ClinicalEntityConnectionInfo> clinicalEntityConnectionInfos) {
		this.clinicalEntityConnectionInfos = clinicalEntityConnectionInfos;
	}

	/* toString */
	@Override
	public String toString() {
		return "ClinicalEntityAccessInfo [id=" + id + ", clinicalEntity=" + clinicalEntity.getId() + ", userProfile="
				+ userProfile.getId() + ", accessLevel=" + accessLevel + ", active=" + active + "]";
	}

}