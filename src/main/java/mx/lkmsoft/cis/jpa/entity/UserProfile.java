package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Persistent class for entity stored in table "profile"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_profile", schema = "security")
public class UserProfile {

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private User user;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assistant_id", referencedColumnName = "id")
	private Assistant assistant;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nurse_id", referencedColumnName = "id")
	private Nurse nurse;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	public UserProfile() {
	}

	public UserProfile(User user, Person person, Doctor doctor) {
		this.user = user;
		this.person = person;
		this.doctor = doctor;
	}

	public UserProfile(User user, Person person, Nurse nurse) {
		this.user = user;
		this.person = person;
		this.nurse = nurse;
	}

	public UserProfile(User user, Person person, Assistant assistant) {
		this.user = user;
		this.person = person;
		this.assistant = assistant;
	}

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	/* toString */
	@Override
	public String toString() {
		long doctorId = doctor != null ? doctor.getId() : null;
		long assistantId = assistant != null ? assistant.getId() : null;
		long nurseId = nurse != null ? nurse.getId() : null;

		return "UserProfile [user=" + user.getId() + ", doctor=" + doctorId + ", assistant=" + assistantId + ", nurse=" + nurseId + ", person=" + person.getId() + "]";
	}

}