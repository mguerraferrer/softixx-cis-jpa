package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.AgendaVisualization;

/**
 * Persistent class for entity stored in table "medical_schedule_planning"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "medical_schedule_planning", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.medical_schedule_planning_id_seq", allocationSize = 1)
public class Planning extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medical_schedule_id", referencedColumnName = "id")
	private MedicalSchedule medicalSchedule;

	@Column(name = "doctor_healthcare_center_specialty_id")
	private Long doctorHealthcareCenterSpecialtyId;

	@Column(name = "doctor_specialty_id")
	private Long doctorSpecialtyId;

	@Column(name = "agenda_visualization")
	@Enumerated(EnumType.STRING)
	private AgendaVisualization agendaVisualization;

	@Column(name = "fixed_schedule")
	private boolean fixedSchedule;

	@Column(name = "appointment_duration")
	private Integer appointmentDuration;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "planning", targetEntity = PlanningDay.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PlanningDay> planningDays;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planning", targetEntity = Appointment.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Appointment> appointments;

	public Planning() {
	}
	
	public Planning(MedicalSchedule medicalSchedule) {
		this.medicalSchedule = medicalSchedule;
	}
	
	/* Getters and Setters */
	public MedicalSchedule getMedicalSchedule() {
		return medicalSchedule;
	}

	public void setMedicalSchedule(MedicalSchedule medicalSchedule) {
		this.medicalSchedule = medicalSchedule;
	}

	public Long getDoctorHealthcareCenterSpecialtyId() {
		return doctorHealthcareCenterSpecialtyId;
	}

	public void setDoctorHealthcareCenterSpecialtyId(Long doctorHealthcareCenterSpecialtyId) {
		this.doctorHealthcareCenterSpecialtyId = doctorHealthcareCenterSpecialtyId;
	}

	public Long getDoctorSpecialtyId() {
		return doctorSpecialtyId;
	}

	public void setDoctorSpecialtyId(Long doctorSpecialtyId) {
		this.doctorSpecialtyId = doctorSpecialtyId;
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

	public List<PlanningDay> getPlanningDays() {
		if (planningDays == null) {
			planningDays = new ArrayList<>();
		}
		return planningDays;
	}

	public void setPlanningDays(List<PlanningDay> planningDays) {
		this.planningDays = planningDays;
	}
	
	public void addPlanningDays(PlanningDay planningDay) {
		if (planningDays == null) {
			planningDays = new ArrayList<>();
		}
		this.planningDays.add(new PlanningDay(this, planningDay.getDay(), planningDay.getStartTime(),
				planningDay.getEndTime(), planningDay.getTotalPatients(), planningDay.getTotalExtraSlot()));
	}
	
	public void addPlanningDays(List<PlanningDay> planningDays) {
		if (this.planningDays != null) {
			this.planningDays.clear();
			this.planningDays.addAll(planningDays);
		}
	}
	
	public void clearPlanningDays() {
		if (this.planningDays != null) {
			this.planningDays.clear();
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

	/* toString */
	@Override
	public String toString() {
		return "Planning [id=" + id + ", medicalSchedule=" + medicalSchedule.getId() + ", doctorHealthcareCenterSpecialtyId="
				+ doctorHealthcareCenterSpecialtyId + ", doctorSpecialtyId=" + doctorSpecialtyId
				+ ", agendaVisualization=" + agendaVisualization + ", fixedSchedule=" + fixedSchedule
				+ ", appointmentDuration=" + appointmentDuration + "]";
	}

}