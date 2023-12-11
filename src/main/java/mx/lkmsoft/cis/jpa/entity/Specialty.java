package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "specialties"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "specialties", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.specialty_seq", allocationSize = 1)
@Getter
@Setter
public class Specialty extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "value")
	private String value;

	@Column(name = "default_procedure")
	private String defaultProcedure;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty", targetEntity = DoctorSpecialty.class)
	@Getter(AccessLevel.NONE)
	private List<DoctorSpecialty> doctorSpecialties;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty", targetEntity = HealthcareCenterSpecialty.class)
	@Getter(AccessLevel.NONE)
	private List<HealthcareCenterSpecialty> healthcareCenterSpecialties;

	public List<DoctorSpecialty> getDoctorSpecialties() {
		if (doctorSpecialties == null) {
			doctorSpecialties = new ArrayList<>();
		}
		return doctorSpecialties;
	}

	public List<HealthcareCenterSpecialty> getHealthcareCenterSpecialties() {
		if (healthcareCenterSpecialties == null) {
			healthcareCenterSpecialties = new ArrayList<>();
		}
		return healthcareCenterSpecialties;
	}

	/* toString */
	@Override
	public String toString() {
		return "Specialty [id=" + id + ", code=" + code + ", value=" + value + ", defaultProcedure=" + defaultProcedure
				+ ", active=" + active + "]";
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
		Specialty specialty = (Specialty) o;
		return getId() != null && Objects.equals(getId(), specialty.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}