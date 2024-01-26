package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Persistent class for entity stored in table "stripe_error_log"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "stripe_error_log", schema = "errors")
@SequenceGenerator(name = "default_gen", sequenceName = "errors.stripe_error_log_seq", allocationSize = 1)
@Getter
@Setter
public class StripeErrorLog extends BaseEntity {

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "exception_type")
	private String type;

	@Column(name = "exception_code")
	private String code;

	@Column(name = "exception_message")
	private String message;

	@Column(name = "log_time")
	private LocalDateTime logTime;

	public StripeErrorLog() {
	}

	public StripeErrorLog(String userEmail, String exceptionType, String exceptionCode, String exceptionMessage) {
		this.userEmail = userEmail;
		this.type = exceptionType;
		this.code = exceptionCode;
		this.message = exceptionMessage;
		this.logTime = LocalDateTime.now();
	}

	/* toString */
	@Override
	public String toString() {
		return "ErrorLog [id=" + id + ", userEmail=" + userEmail + ", type=" + type + ", code=" + code
				+ ", message=" + message + ", logTime=" + logTime + "]";
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
		StripeErrorLog errorLog = (StripeErrorLog) o;
		return getId() != null && Objects.equals(getId(), errorLog.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}