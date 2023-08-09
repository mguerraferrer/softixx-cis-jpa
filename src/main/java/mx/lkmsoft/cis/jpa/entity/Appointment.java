package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
import java.time.LocalTime;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import mx.lkmsoft.cis.common.crypto.CryptoUtils;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentCancelled;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentConfirmation;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentOrigin;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentReschedule;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentStatus;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentType;

/**
 * Persistent class for entity stored in table "appointment"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "appointment", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.appointment_id_seq", allocationSize = 1)
public class Appointment extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medical_schedule_planning_id", referencedColumnName = "id")
	private Planning planning;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_consultation_procedure_id", referencedColumnName = "id")
	private PrivatePracticeConsultationProcedure privatePracticeProcedure;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_consultation_procedure_id", referencedColumnName = "id")
	private ClinicalEntityConsultationProcedure clinicalEntityProcedure;

	@Column(name = "appointment_type")
	@Enumerated(EnumType.STRING)
	private AppointmentType type;

	@Column(name = "origin")
	@Enumerated(EnumType.STRING)
	private AppointmentOrigin origin;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;

	@Column(name = "confirmation")
	@Enumerated(EnumType.STRING)
	private AppointmentConfirmation confirmation;

	@Column(name = "cancelled_by")
	@Enumerated(EnumType.STRING)
	private AppointmentCancelled cancelledBy;

	@Column(name = "rescheduled_by")
	@Enumerated(EnumType.STRING)
	private AppointmentReschedule rescheduledBy;

	@Column(name = "another_person_name")
	private String anotherPersonName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "relationship_type_id", referencedColumnName = "id")
	private RelationshipType relationshipType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appointment_id", referencedColumnName = "id")
	private Appointment originalAppointment;

	@Column(name = "appointment_date")
	private LocalDate appointmentDate;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "folio")
	private String folio;

	@Column(name = "month")
	private Integer month;

	@Column(name = "additional_info")
	private String additionalInfo;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private AppointmentReminder reminder;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appointment", targetEntity = AppointmentNotification.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AppointmentNotification> appointmentNotifications;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "originalAppointment", targetEntity = Appointment.class)
	private List<Appointment> appointments;

	public Appointment() {
		this.folio = CryptoUtils.generateHash().toUpperCase();
	}

	public Appointment(Planning planning, 
					   PrivatePracticeConsultationProcedure privatePracticeProcedure,
					   ClinicalEntityConsultationProcedure clinicalEntityProcedure, 
					   Person person, 
					   LocalDate appointmentDate,
					   LocalTime startTime,
					   LocalTime endTime) {
		this.planning = planning;
		this.privatePracticeProcedure = privatePracticeProcedure;
		this.clinicalEntityProcedure = clinicalEntityProcedure;
		this.person = person;
		this.appointmentDate = appointmentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.folio = CryptoUtils.generateHash().toUpperCase();
		this.month = appointmentDate.getMonthValue();
	}

	public static Appointment clone(Appointment appointment, LocalDate appointmentDate, LocalTime startTime,
			LocalTime endTime) {
		if (appointment != null) {
			Appointment clone = new Appointment(appointment.getPlanning(), appointment.getPrivatePracticeProcedure(),
					appointment.getClinicalEntityProcedure(), appointment.getPerson(), appointmentDate, startTime,
					endTime);
			clone.setOriginalAppointment(appointment);
			clone.setType(appointment.getType());
			clone.setOrigin(AppointmentOrigin.CLONED);
			clone.setStatus(AppointmentStatus.CREATED);
			clone.setConfirmation(AppointmentConfirmation.UNCONFIRMED);
			return clone;
		}
		return null;
	}

	public Appointment reschedule(Appointment appointment, LocalDate appointmentDate, LocalTime startTime,
			LocalTime endTime) {
		Appointment reschedule = clone(appointment, appointmentDate, startTime, endTime);
		if (reschedule != null) {
			reschedule.setOriginalAppointment(appointment);
			reschedule.setType(appointment.getType());
			reschedule.setOrigin(appointment.getOrigin());
			reschedule.setStatus(AppointmentStatus.CREATED);
			reschedule.setConfirmation(AppointmentConfirmation.UNCONFIRMED);
			return reschedule;
		}
		return null;
	}

	/* Getters and Setters */
	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PrivatePracticeConsultationProcedure getPrivatePracticeProcedure() {
		return privatePracticeProcedure;
	}

	public void setPrivatePracticeProcedure(PrivatePracticeConsultationProcedure privatePracticeProcedure) {
		this.privatePracticeProcedure = privatePracticeProcedure;
	}

	public ClinicalEntityConsultationProcedure getClinicalEntityProcedure() {
		return clinicalEntityProcedure;
	}

	public void setClinicalEntityProcedure(ClinicalEntityConsultationProcedure clinicalEntityProcedure) {
		this.clinicalEntityProcedure = clinicalEntityProcedure;
	}

	public AppointmentType getType() {
		return type;
	}

	public void setType(AppointmentType type) {
		this.type = type;
	}

	public AppointmentOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(AppointmentOrigin origin) {
		this.origin = origin;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	public AppointmentConfirmation getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(AppointmentConfirmation confirmation) {
		this.confirmation = confirmation;
	}

	public AppointmentCancelled getCancelledBy() {
		return cancelledBy;
	}

	public void setCancelledBy(AppointmentCancelled cancelledBy) {
		this.cancelledBy = cancelledBy;
	}

	public AppointmentReschedule getRescheduledBy() {
		return rescheduledBy;
	}

	public void setRescheduledBy(AppointmentReschedule rescheduledBy) {
		this.rescheduledBy = rescheduledBy;
	}

	public String getAnotherPersonName() {
		return anotherPersonName;
	}

	public void setAnotherPersonName(String anotherPersonName) {
		this.anotherPersonName = anotherPersonName;
	}

	public RelationshipType getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(RelationshipType relationshipType) {
		this.relationshipType = relationshipType;
	}

	public Appointment getOriginalAppointment() {
		return originalAppointment;
	}

	public void setOriginalAppointment(Appointment originalAppointment) {
		this.originalAppointment = originalAppointment;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public AppointmentReminder getReminder() {
		return reminder;
	}

	public void setReminder(AppointmentReminder reminder) {
		this.reminder = reminder;
	}

	public List<AppointmentNotification> getAppointmentNotifications() {
		if (appointmentNotifications == null) {
			appointmentNotifications = new ArrayList<>();
		}
		return appointmentNotifications;
	}

	public void setAppointmentNotifications(List<AppointmentNotification> appointmentNotifications) {
		this.appointmentNotifications = appointmentNotifications;
	}

	public void addNotifications(AppointmentNotification appointmentNotification) {
		if (appointmentNotifications == null) {
			appointmentNotifications = new ArrayList<>();
		}
		this.appointmentNotifications
				.add(new AppointmentNotification(this, appointmentNotification.getNotificationType(),
						appointmentNotification.getNotifiedEmails(), appointmentNotification.getNotifiedMobiles()));
	}

	public void addNotifications(List<AppointmentNotification> appointmentNotifications) {
		if (this.appointmentNotifications != null) {
			this.appointmentNotifications.clear();
			this.appointmentNotifications.addAll(appointmentNotifications);
		}
	}
	
	public void clearNotifications() {
		if (this.appointmentNotifications != null) {
			this.appointmentNotifications.clear();
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

	@Transient
	public Long getOriginalAppointmentId() {
		if (this.originalAppointment != null) {
			return originalAppointment.getId();
		}
		return null;
	}

	/* toString */
	@Override
	public String toString() {
		long ppProcedureId = privatePracticeProcedure != null ? privatePracticeProcedure.getId() : null;
		long ceProcedureId = clinicalEntityProcedure != null ? clinicalEntityProcedure.getId() : null;
		long relTypeId = relationshipType != null ? relationshipType.getId() : null;
		long originalAppointmentId = originalAppointment != null ? originalAppointment.getId() : null;

		return "Appointment [id=" + id + ", personId=" + person.getId() + ", planning=" + planning.getId()
				+ ", privatePracticeProcedure=" + ppProcedureId + ", clinicalEntityProcedure=" + ceProcedureId
				+ ", type=" + type + ", origin=" + origin + ", status=" + status + ", confirmation=" + confirmation
				+ ", cancelledBy=" + cancelledBy + ", rescheduledBy=" + rescheduledBy + ", anotherPersonName="
				+ anotherPersonName + ", relationshipType=" + relTypeId + ", originalAppointmentId="
				+ originalAppointmentId + ", appointmentDate=" + appointmentDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", folio=" + folio + ", month=" + month + ", additionalInfo="
				+ additionalInfo + "]";
	}

}