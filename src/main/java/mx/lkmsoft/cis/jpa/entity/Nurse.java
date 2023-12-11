package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "nurse"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "nurse", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.nurse_seq", allocationSize = 1)
@Getter
@Setter
public class Nurse extends BaseEntity {

	@Column(name = "active")
	private boolean active;

	@OneToOne(mappedBy = "nurse", cascade = CascadeType.ALL)
	private UserProfile userProfile;

	@ManyToMany(mappedBy = "nurses")
	@Getter(AccessLevel.NONE)
    private List<Doctor> doctors;

	public List<Doctor> getDoctors() {
		if (doctors == null) {
			doctors = new ArrayList<>();
		}
		return doctors;
	}

	/* toString */
	@Override
	public String toString() {
		return "Nurse [id=" + id + ", active=" + active + "]";
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
		Nurse nurse = (Nurse) o;
		return getId() != null && Objects.equals(getId(), nurse.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}
}