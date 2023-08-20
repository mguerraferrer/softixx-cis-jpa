package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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

	@ManyToMany(mappedBy = "assistants")
	private List<Doctor> doctors;

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

	public List<Doctor> getDoctors() {
		if (doctors == null) {
			doctors = new ArrayList<>();
		}
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	/* toString */
	@Override
	public String toString() {
		return "Assistant [id=" + id + ", active=" + active + "]";
	}

}