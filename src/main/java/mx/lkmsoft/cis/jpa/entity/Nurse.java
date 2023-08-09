package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "nurse"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "nurse", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.nurse_id_seq", allocationSize = 1)
public class Nurse extends BaseEntity {

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nurse", targetEntity = NurseDoctor.class)
	private List<NurseDoctor> nurseDoctors;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nurse", targetEntity = UserProfile.class)
	private List<UserProfile> userProfiles;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nurse", targetEntity = NurseClinicalEntity.class)
	private List<NurseClinicalEntity> nurseClinicalEntities;

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<NurseDoctor> getNurseDoctors() {
		if (nurseDoctors == null) {
			nurseDoctors = new ArrayList<>();
		}
		return nurseDoctors;
	}

	public void setNurseDoctors(List<NurseDoctor> nurseDoctors) {
		this.nurseDoctors = nurseDoctors;
	}

	public List<UserProfile> getUserProfiles() {
		if (userProfiles == null) {
			userProfiles = new ArrayList<>();
		}
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public List<NurseClinicalEntity> getNurseClinicalEntities() {
		if (nurseClinicalEntities == null) {
			nurseClinicalEntities = new ArrayList<>();
		}
		return nurseClinicalEntities;
	}

	public void setNurseClinicalEntities(List<NurseClinicalEntity> nurseClinicalEntities) {
		this.nurseClinicalEntities = nurseClinicalEntities;
	}

	/* toString */
	@Override
	public String toString() {
		return "Nurse [id=" + id + ", active=" + active + "]";
	}

}