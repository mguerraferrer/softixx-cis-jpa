package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
import lombok.val;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.AuditableEntity;
import mx.lkmsoft.cis.jpa.enumtype.AgendaVisualization;

/**
 * Persistent class for entity stored in table "planning"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "planning", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.planning_seq", allocationSize = 1)
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
	private PlanningFixed planningFixed;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planning", targetEntity = PlanningDaily.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PlanningDaily> planningDailies;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planning", targetEntity = Appointment.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Appointment> appointments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planning", targetEntity = ConsultationProcedure.class, cascade = CascadeType.ALL, orphanRemoval = true)
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
		this.createOn = LocalDateTime.now(); // For cache purposes
		this.updateOn = LocalDateTime.now(); // For cache purposes
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

	/* Getters and Setters */
	public MedicalSchedule getMedicalSchedule() {
		return medicalSchedule;
	}

	public void setMedicalSchedule(MedicalSchedule medicalSchedule) {
		this.medicalSchedule = medicalSchedule;
	}

	public DoctorSpecialty getDoctorSpecialty() {
		return doctorSpecialty;
	}

	public void setDoctorSpecialty(DoctorSpecialty doctorSpecialty) {
		this.doctorSpecialty = doctorSpecialty;
	}

	public AgendaVisualization getAgendaVisualization() {
		return agendaVisualization;
	}

	public void setAgendaVisualization(AgendaVisualization agendaVisualization) {
		this.agendaVisualization = agendaVisualization;
	}

	public boolean isFixedSchedule() {
		return fixedSchedule;
	}

	public void setFixedSchedule(boolean fixedSchedule) {
		this.fixedSchedule = fixedSchedule;
	}

	public Integer getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(Integer appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public PlanningFixed getPlanningFixed() {
		return planningFixed;
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

	public void setPlanningDailies(List<PlanningDaily> planningDailies) {
		this.planningDailies = planningDailies;
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

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<ConsultationProcedure> getConsultationProcedures() {
		if (consultationProcedures == null) {
			consultationProcedures = new ArrayList<>();
		}
		return consultationProcedures;
	}

	public void setConsultationProcedures(List<ConsultationProcedure> consultationProcedures) {
		this.consultationProcedures = consultationProcedures;
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
				+ ", updateOn=" + updateOn + ", active= " + active + "]";
	}

}