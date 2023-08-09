package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.common.collection.ListUtils;
import mx.lkmsoft.cis.jpa.enumtype.NotificationType;

/**
 * Persistent class for entity stored in table "appointment_reminder"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "appointment_reminder", schema = "agenda")
public class AppointmentReminder {

	@Id
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private Appointment appointment;

	@Column(name = "notification_type")
	private String notificationType;

	@Column(name = "mails_to_notify", length = 500)
	private String mailsToNotify;

	@Column(name = "mobiles_to_notify")
	private String mobilesToNotify;

	@Column(name = "reminder_date")
	private LocalDateTime reminderDate;

	public AppointmentReminder() {
	}

	public AppointmentReminder(Appointment appointment, String notificationType, String mailsToNotify,
			String mobilesToNotify, LocalDateTime reminderDate) {
		this.appointment = appointment;
		this.notificationType = notificationType;
		this.mailsToNotify = mailsToNotify;
		this.mobilesToNotify = mobilesToNotify;
		this.reminderDate = reminderDate;
	}
	
	public AppointmentReminder(Appointment appointment, List<NotificationType> notificationTypes,
			List<String> notifiedEmails, List<String> notifiedMobiles, LocalDateTime reminderDate) {
		this.appointment = appointment;
		this.notificationType = ListUtils.toString(notificationTypes.stream().map(NotificationType::name).toList());
		this.mailsToNotify = ListUtils.toString(notifiedEmails);
		this.mobilesToNotify = ListUtils.toString(notifiedMobiles);
		this.reminderDate = reminderDate;
	}

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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

	public String getMailsToNotify() {
		return mailsToNotify;
	}

	public void setMailsToNotify(String mailsToNotify) {
		this.mailsToNotify = mailsToNotify;
	}

	public String getMobilesToNotify() {
		return mobilesToNotify;
	}

	public void setMobilesToNotify(String mobilesToNotify) {
		this.mobilesToNotify = mobilesToNotify;
	}

	public LocalDateTime getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(LocalDateTime reminderDate) {
		this.reminderDate = reminderDate;
	}

	/* toString */
	@Override
	public String toString() {
		return "AppointmentReminder [id=" + id + ", appointment=" + appointment.getId() + ", notificationType="
				+ notificationType + ", mailsToNotify=" + mailsToNotify + ", mobilesToNotify=" + mobilesToNotify
				+ ", reminderDate=" + reminderDate + "]";
	}

}