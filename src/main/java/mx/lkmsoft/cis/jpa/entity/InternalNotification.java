package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.proxy.HibernateProxy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.datetime.YearMonthUtils;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.InternalNotificationType;

/**
 * Persistent class for entity stored in table "internal_notifications"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "internal_notifications", schema = "notifications")
@SequenceGenerator(name = "default_gen", sequenceName = "notifications.internal_notifications_seq", allocationSize = 1)
@Getter
@Setter
public class InternalNotification extends BaseEntity {

	@Column(name = "sender")
	private String sender;

	@Column(name = "notification_type")
	@Enumerated(EnumType.STRING)
	private InternalNotificationType notificationType;

	@Column(name = "notification_data")
	private String notificationData;

	@Column(name = "notification_date")
	private LocalDateTime datetime;

	@Column(name = "month")
	private Integer month;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "internalNotification", targetEntity = InternalNotificationDetail.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@Getter(AccessLevel.NONE)
	private List<InternalNotificationDetail> notificationDetails;

	public InternalNotification() {
	}

	public InternalNotification(String sender, InternalNotificationType notificationType, String notificationData) {
		this.sender = sender;
		this.notificationType = notificationType;
		this.notificationData = notificationData;
		this.datetime = LocalDateTime.now();
		this.month = YearMonthUtils.currentMonthValue();
	}

	public List<InternalNotificationDetail> getNotificationDetails() {
		if (notificationDetails == null) {
			return new ArrayList<>();
		}
		return notificationDetails;
	}

	public void addNotificationDetail(InternalNotificationDetail notificationDetail) {
		if (this.notificationDetails == null) {
			this.notificationDetails = new ArrayList<>();
		}
		this.notificationDetails.add(notificationDetail);
		notificationDetail.setInternalNotification(this);
	}

	public void addNotificationDetails(List<InternalNotificationDetail> notificationDetails) {
		if (this.notificationDetails == null) {
			this.notificationDetails = new ArrayList<>();
		} else {
			this.notificationDetails.clear();
		}
		this.notificationDetails.addAll(notificationDetails);
	}

	/* toString */
	@Override
	public String toString() {
		return "InternalNotification [id=" + id + ", sender=" + sender + ", notificationType=" + notificationType
				+ ", notificationData=" + notificationData + ", datetime=" + datetime + "]";
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
		InternalNotification that = (InternalNotification) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}