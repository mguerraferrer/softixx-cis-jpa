package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.AuditableEntity;

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

	@Version
	private Long version;

	private boolean read;

	public InternalNotificationDetail() {
	}

	public InternalNotificationDetail(InternalNotification internalNotification, String recipient) {
		this.internalNotification = internalNotification;
		this.recipient = recipient;
		this.code = CodeGeneratorUtils.asString();
		this.read = false;
	}

	/* toString */
	@Override
	public String toString() {
		return "InternalNotification [id=" + id + ", internalNotification=" + internalNotification.getId()
				+ ", recipient=" + recipient + ", code=" + code + ", version=" + version
				+ ", read=" + read + ", createOn=" + createOn + ", updateOn=" + updateOn + "]";
	}

}