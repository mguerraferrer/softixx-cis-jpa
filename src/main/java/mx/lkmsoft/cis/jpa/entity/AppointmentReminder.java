package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.collection.ListUtils;
import mx.lkmsoft.cis.jpa.enumtype.NotificationMethod;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "appointment_reminder"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "appointment_reminder", schema = "agenda")
@Getter
@Setter
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

	@Version
	private Long version;

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

	public AppointmentReminder(Appointment appointment, List<NotificationMethod> notificationTypes,
			List<String> notifiedEmails, List<String> notifiedMobiles, LocalDateTime reminderDate) {
		this.appointment = appointment;
		this.notificationType = ListUtils.toString(notificationTypes.stream().map(NotificationMethod::name).toList());
		this.mailsToNotify = ListUtils.toString(notifiedEmails);
		this.mobilesToNotify = ListUtils.toString(notifiedMobiles);
		this.reminderDate = reminderDate;
	}

	public List<NotificationMethod> getNotificationTypes() {
		if (this.notificationType != null) {
			return ListUtils.toList(this.notificationType).stream().map(NotificationMethod::valueOf).toList();
		}
		return Collections.emptyList();
	}

	public void setNotificationType(List<NotificationMethod> notificationTypes) {
		if (notificationTypes != null) {
			this.notificationType = ListUtils.toString(notificationTypes.stream().map(NotificationMethod::name).toList());
		}
	}

	/* toString */
	@Override
	public String toString() {
		return "AppointmentReminder [id=" + id + ", appointment=" + appointment.getId() + ", notificationType="
				+ notificationType + ", mailsToNotify=" + mailsToNotify + ", mobilesToNotify=" + mobilesToNotify
				+ ", reminderDate=" + reminderDate + ", version= " + version + "]";
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
		AppointmentReminder that = (AppointmentReminder) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
				? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
				: getClass().hashCode();
	}

}