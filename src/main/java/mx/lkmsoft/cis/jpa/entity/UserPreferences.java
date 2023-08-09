package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "preferences"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "preferences", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.preferences_id_seq", allocationSize = 1)
public class UserPreferences extends BaseEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_profile_id", referencedColumnName = "id")
	private UserProfile userProfile;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "notification_method_id", referencedColumnName = "id")
	private NotificationMethod notificationMethod;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "language_id", referencedColumnName = "id")
	private Language language;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "theme_id", referencedColumnName = "id")
	private Theme theme;

	@Column(name = "private_practice")
	private boolean privatePractice;

	@Column(name = "paged")
	private Integer paged;

	@Column(name = "notifications")
	private boolean notifications;

	@Column(name = "alerts")
	private boolean alerts;

	@Column(name = "password_change")
	private boolean passwordChange;

	@Column(name = "password_change_period")
	private Integer passwordChangePeriod;

	@Column(name = "last_password_change")
	private LocalDate lastPasswordChange;

	@Column(name = "next_password_change")
	private LocalDate nextPasswordChange;

	@Column(name = "appointment_duration")
	private Integer appointmentDuration;

	@Column(name = "notify_appointment")
	private boolean notifyAppointment;

	@Column(name = "active")
	private boolean active;

	public UserPreferences() {
		super();
	}

	public UserPreferences(Theme theme, Language language, Integer paged) {
		this.theme = theme;
		this.language = language;
		this.paged = paged;
		this.privatePractice = false;
		this.notifications = true;
		this.alerts = true;
		this.passwordChange = false;
		this.notifyAppointment = true;
		this.active = true;
	}

	/* Getters and Setters */
	public UserProfile getProfile() {
		return userProfile;
	}

	public void setProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public NotificationMethod getNotificationMethod() {
		return notificationMethod;
	}

	public void setNotificationMethod(NotificationMethod notificationMethod) {
		this.notificationMethod = notificationMethod;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public boolean isPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(boolean privatePractice) {
		this.privatePractice = privatePractice;
	}

	public Integer getPaged() {
		return paged;
	}

	public void setPaged(Integer paged) {
		this.paged = paged;
	}

	public boolean isNotifications() {
		return notifications;
	}

	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}

	public boolean isAlerts() {
		return alerts;
	}

	public void setAlerts(boolean alerts) {
		this.alerts = alerts;
	}

	public boolean isPasswordChange() {
		return passwordChange;
	}

	public void setPasswordChange(boolean passwordChange) {
		this.passwordChange = passwordChange;
	}

	public Integer getPasswordChangePeriod() {
		return passwordChangePeriod;
	}

	public void setPasswordChangePeriod(Integer passwordChangePeriod) {
		this.passwordChangePeriod = passwordChangePeriod;
	}

	public LocalDate getLastPasswordChange() {
		return lastPasswordChange;
	}

	public void setLastPasswordChange(LocalDate lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public LocalDate getNextPasswordChange() {
		return nextPasswordChange;
	}

	public void setNextPasswordChange(LocalDate nextPasswordChange) {
		this.nextPasswordChange = nextPasswordChange;
	}

	public Integer getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(Integer appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	public boolean isNotifyAppointment() {
		return notifyAppointment;
	}

	public void setNotifyAppointment(boolean notifyAppointment) {
		this.notifyAppointment = notifyAppointment;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(privatePractice);
		sb.append("|");
		sb.append(paged);
		sb.append("|");
		sb.append(notifications);
		sb.append("|");
		sb.append(alerts);
		sb.append("|");
		sb.append(passwordChange);
		sb.append("|");
		sb.append(passwordChangePeriod);
		sb.append("|");
		sb.append(lastPasswordChange);
		sb.append("|");
		sb.append(nextPasswordChange);
		sb.append("|");
		sb.append(appointmentDuration);
		sb.append("|");
		sb.append(notifyAppointment);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}