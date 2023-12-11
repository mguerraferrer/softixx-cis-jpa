package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.AuditableEntity;
import mx.lkmsoft.cis.jpa.enumtype.AgendaVisualization;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "planning"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "planning", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.planning_seq", allocationSize = 1)
@Getter
@Setter
public class Planning extends AuditableEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medical_schedule_id", referencedColumnName = "id")
	private MedicalSchedule medicalSchedule;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_specialty_id", referencedColumnName = "id")
	private DoctorSpecialty doctorSpecialty;

	@Column(name = "agenda_visualization")
	@Enumerated(EnumType.STRING)
	private AgendaVisualization agendaVisualization;

	@Column(name = "fixed_schedule")
	private boolean fixedSchedule;

	@Column(name = "appointment_duration")
	private Integer appointmentDuration;

	@Column(name = "code")
	private String code;

	@Version
	private Long version;

	@Column(name = "active")
	private boolean active;

	@OneToOne(mappedBy = "planning", cascade = CascadeType.ALL, orphanRemoval = true)
	@Setter(AccessLevel.NONE)
	private PlanningFixed planningFixed;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planning", targetEntity = PlanningDaily.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@Getter(AccessLevel.NONE)
	private List<PlanningDaily> planningDailies;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planning", targetEntity = Appointment.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@Getter(AccessLevel.NONE)
	private List<Appointment> appointments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planning", targetEntity = ConsultationProcedure.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@Getter(AccessLevel.NONE)
	private List<ConsultationProcedure> consultationProcedures;

	public Planning() {
	}

	public Planning(MedicalSchedule medicalSchedule, DoctorSpecialty doctorSpecialty, boolean fixedSchedule,
			Integer appointmentDuration) {
		this.medicalSchedule = medicalSchedule;
		this.doctorSpecialty = doctorSpecialty;
		this.agendaVisualization = AgendaVisualization.AGENDA;
		this.fixedSchedule = fixedSchedule;
		this.appointmentDuration = appointmentDuration;
		this.code = CodeGeneratorUtils.asString();
		this.active = true;
	}

	public Planning(MedicalSchedule medicalSchedule, DoctorSpecialty doctorSpecialty, boolean fixedSchedule,
			Integer appointmentDuration, String code, boolean active) {
		this.medicalSchedule = medicalSchedule;
		this.doctorSpecialty = doctorSpecialty;
		this.agendaVisualization = AgendaVisualization.AGENDA;
		this.fixedSchedule = fixedSchedule;
		this.appointmentDuration = appointmentDuration;
		this.code = code;
		this.active = active;
	}

	public static Planning clone(Planning planning) {
		return new Planning(planning.getMedicalSchedule(), planning.getDoctorSpecialty(), planning.isFixedSchedule(),
				planning.getAppointmentDuration(), planning.getCode(), planning.isActive());
	}

	public void setPlanningFixed(PlanningFixed planningFixed) {
		if (this.planningFixed != null) {
			this.planningFixed.setPlanning(null);
		}

		if (planningFixed != null) {
			planningFixed.setPlanning(this);
		}

		this.planningFixed = planningFixed;

		// Delete PlanningDaily list
		clearPlanningDailies();
	}

	public void removePlanningFixed() {
		if (this.planningFixed != null) {
			this.planningFixed.setPlanning(null);
			this.planningFixed = null;
		}
	}

	public List<PlanningDaily> getPlanningDailies() {
		if (planningDailies == null) {
			planningDailies = new ArrayList<>();
		}
		return planningDailies;
	}

	public void addPlanningDaily(PlanningDaily planningDaily) {
		if (this.planningDailies == null) {
			this.planningDailies = new ArrayList<>();
		}
		this.planningDailies.add(planningDaily);
		planningDaily.setPlanning(this);

		// Delete PlanningFixed
		removePlanningFixed();
	}

	public void addPlanningDailies(List<PlanningDaily> planningDailies) {
		if (this.planningDailies == null) {
			this.planningDailies = new ArrayList<>();
		} else {
			this.planningDailies.clear();
		}
		this.planningDailies.addAll(planningDailies);

		// Delete PlanningFixed
		removePlanningFixed();
	}

	public void clearPlanningDailies() {
		if (this.planningDailies != null) {
			this.planningDailies.clear();
		}
	}

	public List<Appointment> getAppointments() {
		if (appointments == null) {
			appointments = new ArrayList<>();
		}
		return appointments;
	}

	public void addAppointments(List<Appointment> appointments) {
		if (this.appointments == null) {
			this.appointments = new ArrayList<>();
		} else {
			this.appointments.clear();
		}
		this.appointments.addAll(appointments);
	}

	public List<ConsultationProcedure> getConsultationProcedures() {
		if (consultationProcedures == null) {
			consultationProcedures = new ArrayList<>();
		}
		return consultationProcedures;
	}

	public void addConsultationProcedure(ConsultationProcedure consultationProcedure) {
		if (consultationProcedures == null) {
			consultationProcedures = new ArrayList<>();
		}
		this.consultationProcedures.add(consultationProcedure);
	}

	public void addConsultationProcedures(List<ConsultationProcedure> consultationProcedures) {
		if (this.consultationProcedures == null) {
			this.consultationProcedures = new ArrayList<>();
		} else {
			this.consultationProcedures.clear();
		}
		this.consultationProcedures.addAll(consultationProcedures);
	}

	public void addConsultationProcedure(List<ConsultationProcedure> consultationProcedures) {
		if (this.consultationProcedures != null) {
			this.consultationProcedures.clear();
			this.consultationProcedures.addAll(consultationProcedures);
		}
	}

	public void updateConsultationProcedure(ConsultationProcedure consultationProcedure) {
		val procedureList = getConsultationProcedures().stream()
				                                       .filter(cp -> !cp.getCode().equals(consultationProcedure.getCode())).collect(Collectors.toList());
		procedureList.add(consultationProcedure);
		addConsultationProcedure(procedureList);
	}

	/* toString */
	@Override
	public String toString() {
		return "Planning [id=" + id + ", medicalSchedule=" + medicalSchedule.getId() + ", agendaVisualization="
				+ agendaVisualization + ", fixedSchedule=" + fixedSchedule + ", appointmentDuration="
				+ appointmentDuration + ", code=" + code + ", version=" + version + ", createOn=" + createOn
				+ ", updateOn=" + updateOn + ", version=" + version + ", active= " + active + "]";
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
		Planning planning = (Planning) o;
		return getId() != null && Objects.equals(getId(), planning.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}