package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * Persistent class for entity stored in table "profile"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_profile", schema = "security")
@Getter
@Setter
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

	/* toString */
	@Override
	public String toString() {
		long doctorId = doctor != null ? doctor.getId() : null;
		long assistantId = assistant != null ? assistant.getId() : null;
		long nurseId = nurse != null ? nurse.getId() : null;

		return "UserProfile [user=" + user.getId() + ", doctor=" + doctorId + ", assistant=" + assistantId + ", nurse=" + nurseId + ", person=" + person.getId() + "]";
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		UserProfile that = (UserProfile) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}