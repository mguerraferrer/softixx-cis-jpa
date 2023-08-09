package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.common.collection.ListUtils;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.NotificationType;

/**
 * Persistent class for entity stored in table "appointment_notification"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "appointment_notification", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.appointment_notification_id_seq", allocationSize = 1)
public class AppointmentNotification extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appointment_id", referencedColumnName = "id")
	private Appointment appointment;

	@Column(name = "notification_type")
	private String notificationType;

	@Column(name = "notified_emails", length = 500)
	private String notifiedEmails;

	@Column(name = "notified_mobiles")
	private String notifiedMobiles;

	@Column(name = "notification_date")
	private LocalDateTime notificationDate;

	public AppointmentNotification() {
	}

	public AppointmentNotification(Appointment appointment, String notificationType, String notifiedEmails,
			String notifiedMobiles) {
		this.appointment = appointment;
		this.notificationType = notificationType;
		this.notifiedEmails = notifiedEmails;
		this.notifiedMobiles = notifiedMobiles;
		this.notificationDate = LocalDateTime.now();
	}
	
	public AppointmentNotification(Appointment appointment, List<NotificationType> notificationTypes,
			List<String> notifiedEmails, List<String> notifiedMobiles) {
		this.appointment = appointment;
		this.notificationType = ListUtils.toString(notificationTypes.stream().map(NotificationType::name).toList());
		this.notifiedEmails = ListUtils.toString(notifiedEmails);
		this.notifiedMobiles = ListUtils.toString(notifiedMobiles);
		this.notificationDate = LocalDateTime.now();
	}

	/* Getters and Setters */
	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public List<NotificationType> getNotificationTypes() {
		if (this.notificationType != null) {
			return ListUtils.toList(this.notificationType).stream().map(NotificationType::valueOf).toList();
		}
		return Collections.emptyList();
	}
	
	public void setNotificationType(List<NotificationType> notificationTypes) {
		if (notificationTypes != null) {
			this.notificationType = ListUtils.toString(notificationTypes.stream().map(NotificationType::name).toList());
		}
	}

	public String getNotifiedEmails() {
		return notifiedEmails;
	}

	public void setNotifiedEmails(String notifiedEmails) {
		this.notifiedEmails = notifiedEmails;
	}

	public String getNotifiedMobiles() {
		return notifiedMobiles;
	}

	public void setNotifiedMobiles(String notifiedMobiles) {
		this.notifiedMobiles = notifiedMobiles;
	}

	public LocalDateTime getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(LocalDateTime notificationDate) {
		this.notificationDate = notificationDate;
	}

	/* toString */
	@Override
	public String toString() {
		return "AppointmentNotification [id=" + id + ", appointment=" + appointment.getId() + ", notificationType="
				+ notificationType + ", notifiedEmails=" + notifiedEmails + ", notifiedMobiles=" + notifiedMobiles
				+ ", notificationDate=" + notificationDate + "]";
	}

}