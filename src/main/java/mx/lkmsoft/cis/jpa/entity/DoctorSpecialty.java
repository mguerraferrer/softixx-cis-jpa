package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "doctor_specialties"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "doctor_specialties", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_specialty_seq", allocationSize = 1)
@Getter
@Setter
public class DoctorSpecialty extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "specialty_id", referencedColumnName = "id")
	private Specialty specialty;

	@Column(name = "professional_license")
	@Convert(converter = AttributeEncryptor.class)
	private String professionalLicense;

	@Column(name = "code")
	private String code;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorSpecialty", targetEntity = Planning.class)
	@Getter(AccessLevel.NONE)
	private List<Planning> plannings;

	public DoctorSpecialty() {
	}

	public DoctorSpecialty(Doctor doctor, Specialty specialty, String professionalLicense) {
		this.doctor = doctor;
		this.specialty = specialty;
		this.professionalLicense = professionalLicense;
		this.code = CodeGeneratorUtils.asString();
		this.active = true;
	}

	public List<Planning> getPlannings() {
		if (plannings == null) {
			plannings = new ArrayList<>();
		}
		return plannings;
	}

	/* toString */
	@Override
	public String toString() {
		return "DoctorSpecialty [id=" + id + ", doctor=" + doctor.getId() + ", specialty=" + specialty.getId()
				+ ", professionalLicense=" + professionalLicense + ", code=" + code + ", active=" + active + "]";
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
		DoctorSpecialty that = (DoctorSpecialty) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}
}