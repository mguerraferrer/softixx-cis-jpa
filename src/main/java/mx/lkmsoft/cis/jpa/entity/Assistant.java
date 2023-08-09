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
 * Persistent class for entity stored in table "assistant"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "assistant", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.assistant_id_seq", allocationSize = 1)
public class Assistant extends BaseEntity {

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assistant", targetEntity = AssistantDoctor.class)
	private List<AssistantDoctor> assistantDoctors;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assistant", targetEntity = AssistantClinicalEntity.class)
	private List<AssistantClinicalEntity> assistantClinicalEntities;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assistant", targetEntity = UserProfile.class)
	private List<UserProfile> userProfiles;

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<AssistantDoctor> getAssistantDoctors() {
		if (assistantDoctors == null) {
			assistantDoctors = new ArrayList<>();
		}
		return assistantDoctors;
	}

	public void setAssistantDoctors(List<AssistantDoctor> assistantDoctors) {
		this.assistantDoctors = assistantDoctors;
	}

	public List<AssistantClinicalEntity> getAssistantClinicalEntities() {
		if (assistantClinicalEntities == null) {
			assistantClinicalEntities = new ArrayList<>();
		}
		return assistantClinicalEntities;
	}

	public void setAssistantClinicalEntities(List<AssistantClinicalEntity> assistantClinicalEntities) {
		this.assistantClinicalEntities = assistantClinicalEntities;
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

	/* toString */
	@Override
	public String toString() {
		return "Assistant [id=" + id + ", active=" + active + "]";
	}

}