package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.AuditableEntity;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * Persistent class for entity stored in table "internal_notification_details"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "internal_notification_details", schema = "notifications")
@SequenceGenerator(name = "default_gen", sequenceName = "notifications.internal_notification_details_seq", allocationSize = 1)
@Getter
@Setter
public class InternalNotificationDetail extends AuditableEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "internal_notification_id", referencedColumnName = "id")
	private InternalNotification internalNotification;

	@Column(name = "recipient")
	private String recipient;

	@Column(name = "code")
	private String code;

	@Column(name = "notified")
	private boolean notified;

	@Column(name = "read")
	private boolean read;

	@Version
	private Long version;

	public InternalNotificationDetail() {
	}

	public InternalNotificationDetail(InternalNotification internalNotification, String recipient) {
		this.internalNotification = internalNotification;
		this.recipient = recipient;
		this.code = CodeGeneratorUtils.asString();
		this.notified = false;
		this.read = false;
	}

	@Transient
	public void markAsNotified() {
		this.notified = true;
	}

	@Transient
	public void markAsRead() {
		this.read = true;
	}

	@Transient
	public void markAsReadAndNotified() {
		this.notified = true;
		this.read = true;
	}

	/* toString */
	@Override
	public String toString() {
		return "InternalNotification [id=" + id + ", internalNotification=" + internalNotification.getId()
				+ ", recipient=" + recipient + ", code=" + code + ", version=" + version +  ", notified=" + notified
				+ ", read=" + read + ", createOn=" + createOn + ", updateOn=" + updateOn + "]";
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
		InternalNotificationDetail that = (InternalNotificationDetail) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}