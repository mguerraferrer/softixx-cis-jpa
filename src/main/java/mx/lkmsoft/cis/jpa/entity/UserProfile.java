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
 * Persistent class for entity stored in table "profile"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_profile", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.user_profile_id_seq", allocationSize = 1)
public class UserProfile extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "assistant_id", referencedColumnName = "id")
	private Assistant assistant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "nurse_id", referencedColumnName = "id")
	private Nurse nurse;

	@ManyToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile", targetEntity = UserPreferences.class)
	private List<UserPreferences> preferenceses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile", targetEntity = ClinicalEntityAccessInfo.class)
	private List<ClinicalEntityAccessInfo> clinicalEntityAccessInfos;

	public UserProfile() {
	}

	public UserProfile(Person person, User user, Doctor doctor, Nurse nurse, Assistant assistant) {
		this.person = person;
		this.user = user;
		this.doctor = doctor;
		this.nurse = nurse;
		this.assistant = assistant;
		this.active = true;
	}

	/* Getters and Setters */
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Assistant getAssistant() {
		return assistant;
	}

	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<UserPreferences> getPreferenceses() {
		if (preferenceses == null) {
			preferenceses = new ArrayList<>();
		}
		return preferenceses;
	}

	public void setPreferenceses(List<UserPreferences> preferenceses) {
		this.preferenceses = preferenceses;
	}

	public List<ClinicalEntityAccessInfo> getClinicalEntityAccessInfos() {
		if (clinicalEntityAccessInfos == null) {
			clinicalEntityAccessInfos = new ArrayList<>();
		}
		return clinicalEntityAccessInfos;
	}

	public void setClinicalEntityAccessInfos(List<ClinicalEntityAccessInfo> clinicalEntityAccessInfos) {
		this.clinicalEntityAccessInfos = clinicalEntityAccessInfos;
	}

	/* toString */
	@Override
	public String toString() {
		long doctorId = doctor != null ? doctor.getId() : null;
		long assistantId = assistant != null ? assistant.getId() : null;
		long userId = user != null ? user.getId() : null;
		long nurseId = nurse != null ? nurse.getId() : null;
		long personId = person != null ? person.getId() : null;

		return "UserProfile [id=" + id + ", doctor=" + doctorId + ", assistant=" + assistantId + ", user=" + userId
				+ ", nurse=" + nurseId + ", person=" + personId + ", active=" + active + "]";
	}

}