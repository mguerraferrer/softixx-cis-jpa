package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.enumtype.LocaleCode;
import mx.lkmsoft.cis.jpa.enumtype.NotificationMethod;
import mx.lkmsoft.cis.jpa.enumtype.Pagination;
import mx.lkmsoft.cis.jpa.enumtype.PasswordChangePeriod;
import mx.lkmsoft.cis.jpa.enumtype.Theme;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "preferences"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "preferences", schema = "security")
@Getter
@Setter
public class UserPreferences {

	@Id
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private User user;

	@Column(name = "notification_method")
	@Enumerated(EnumType.STRING)
	private NotificationMethod notificationMethod;

	@Column(name = "language")
	@Enumerated(EnumType.STRING)
	private LocaleCode language;

	@Column(name = "theme")
	@Enumerated(EnumType.STRING)
	private Theme theme;

	@Column(name = "pagination")
	@Enumerated(EnumType.STRING)
	private Pagination pagination;

	@Column(name = "notifications")
	private boolean notifications;

	@Column(name = "alerts")
	private boolean alerts;

	@Column(name = "password_change")
	private boolean passwordChange;

	@Column(name = "password_change_period")
	@Enumerated(EnumType.STRING)
	private PasswordChangePeriod passwordChangePeriod;

	@Column(name = "last_password_change")
	private LocalDate lastPasswordChange;

	@Column(name = "next_password_change")
	private LocalDate nextPasswordChange;

	@Column(name = "active")
	private boolean active;

	public UserPreferences() {
		super();
	}

	public UserPreferences(User user, Pagination pagination, boolean notifications, NotificationMethod notificationMethod) {
		this.user = user;
		this.theme = Theme.PRIMARY;
		this.language = LocaleCode.ES_MX;
		this.pagination = pagination;
		this.notifications = notifications;
		this.notificationMethod = notificationMethod;
		this.alerts = true;
		this.passwordChange = false;
		this.active = true;
	}

	@Transient
	public Integer getPeriod(PasswordChangePeriod passwordChangePeriod) {
		return PasswordChangePeriod.getValue(this.passwordChangePeriod);
	}

	/* toString */
	@Override
	public String toString() {
		return "UserPreferences [id=" + id + ", user=" + user.getId() + ", notificationMethod=" + notificationMethod
				+ ", language=" + language + ", theme=" + theme + ", pagination=" + pagination + ", notifications="
				+ notifications + ", alerts=" + alerts + ", passwordChange=" + passwordChange
				+ ", passwordChangePeriod=" + passwordChangePeriod + ", lastPasswordChange=" + lastPasswordChange
				+ ", nextPasswordChange=" + nextPasswordChange + "]";
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
		UserPreferences that = (UserPreferences) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}