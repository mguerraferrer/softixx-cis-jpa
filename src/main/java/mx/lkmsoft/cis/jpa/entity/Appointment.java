package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.datetime.LocalTimeUtils;
import org.hibernate.proxy.HibernateProxy;

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
import jakarta.persistence.Version;
import lombok.val;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentCancelled;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentConfirmation;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentOrigin;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentReschedule;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentStatus;
import mx.lkmsoft.cis.jpa.enumtype.AppointmentType;
import mx.lkmsoft.cis.jpa.enumtype.Relationship;

/**
 * Persistent class for entity stored in table "appointment"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "appointment", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.appointment_seq", allocationSize = 1)
@Getter
@Setter
public class Appointment extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "planning_id", referencedColumnName = "id")
	private Planning planning;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private Patient patient;

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

	@Column(name = "relationship")
	@Enumerated(EnumType.STRING)
	private Relationship relationship;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appointment_id", referencedColumnName = "id")
	private Appointment originalAppointment;

	@Column(name = "appointment_date")
	private LocalDate date;

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

	@Version
	private Long version;

	@OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
	private AppointmentReminder reminder;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "appointment", targetEntity = AppointmentNotification.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@Getter(AccessLevel.NONE)
	private List<AppointmentNotification> appointmentNotifications;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "originalAppointment", targetEntity = Appointment.class)
	@Getter(AccessLevel.NONE)
	private List<Appointment> appointments;

	public Appointment() {
		this.folio = CodeGeneratorUtils.alphanumeric().toUpperCase();
	}

	public Appointment(Planning planning, Patient patient, LocalDate date, LocalTime startTime,
			LocalTime endTime) {
		this.planning = planning;
		this.patient = patient;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.folio = CodeGeneratorUtils.alphanumeric().toUpperCase();
		this.month = date.getMonthValue();
	}

	public static Appointment clone(Appointment appointment, LocalDate date, LocalTime startTime,
			LocalTime endTime) {
		if (appointment != null) {
			val clone = new Appointment(appointment.getPlanning(), appointment.getPatient(), date, startTime, endTime);
			clone.setOriginalAppointment(appointment);
			clone.setType(appointment.getType());
			clone.setOrigin(AppointmentOrigin.CLONED);
			clone.setStatus(AppointmentStatus.CREATED);
			clone.setConfirmation(AppointmentConfirmation.UNCONFIRMED);
			return clone;
		}
		return null;
	}

	public Appointment reschedule(Appointment appointment, LocalDate date, LocalTime startTime,
			LocalTime endTime) {
		val reschedule = clone(appointment, date, startTime, endTime);
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

	public List<AppointmentNotification> getAppointmentNotifications() {
		if (appointmentNotifications == null) {
			appointmentNotifications = new ArrayList<>();
		}
		return appointmentNotifications;
	}

	public void addNotifications(AppointmentNotification appointmentNotification) {
		if (appointmentNotifications == null) {
			appointmentNotifications = new ArrayList<>();
		}
		this.appointmentNotifications.add(new AppointmentNotification(this, appointmentNotification.getNotificationType(),
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

	@Transient
	public Long getOriginalAppointmentId() {
		if (this.originalAppointment != null) {
			return originalAppointment.getId();
		}
		return null;
	}
	
	public boolean hasValidStatus() {
		return !AppointmentStatus.CANCELLED.equals(this.status)
				&& !AppointmentStatus.RESCHEDULED.equals(this.status);
	}

	public String getTypeAsString() {
		return type != null ? type.name() : null;
	}

	public String getOriginAsString() {
		return origin != null ? origin.name() : null;
	}

	public String getStatusAsString() {
		return status != null ? status.name() : null;
	}

	public String getRelationshipAsString() {
		return relationship != null ? relationship.name() : null;
	}

	public String getTimeAsString() {
		return LocalTimeUtils.asT12H(startTime) + " - " + LocalTimeUtils.asT12H(endTime);
	}

	/* toString */
	@Override
	public String toString() {
		val rel = relationship != null ? relationship.name() : null;
		val originalAppointmentId = originalAppointment != null ? originalAppointment.getId() : null;

		return "Appointment [id=" + id + ", patient=" + patient.getId() + ", planning=" + planning.getId()
				+ ", type=" + type + ", origin=" + origin
				+ ", status=" + status + ", confirmation=" + confirmation + ", cancelledBy=" + cancelledBy
				+ ", rescheduledBy=" + rescheduledBy + ", anotherPersonName=" + anotherPersonName + ", relationship="
				+ rel + ", originalAppointmentId=" + originalAppointmentId + ", date=" + date
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", folio=" + folio + ", month=" + month
				+ ", additionalInfo=" + additionalInfo + ", version= " + version + "]";
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
		Appointment that = (Appointment) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}