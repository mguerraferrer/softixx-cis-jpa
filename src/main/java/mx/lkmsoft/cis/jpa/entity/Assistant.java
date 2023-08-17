package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

	@OneToOne(mappedBy = "assistant", cascade = CascadeType.ALL)
	private UserProfile userProfile;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assistant", targetEntity = AssistantDoctor.class)
	private List<AssistantDoctor> assistantDoctors;

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
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

	/* toString */
	@Override
	public String toString() {
		return "Assistant [id=" + id + ", active=" + active + "]";
	}

}