package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "login_attempt_log"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "login_attempt_log", schema = "errors")
@SequenceGenerator(name = "default_gen", sequenceName = "errors.login_attempt_log_seq", allocationSize = 1)
@Getter
@Setter
public class LoginAttemptLog extends BaseEntity {

	@Column(name = "detail_message")
	private String detailMessage;

	@Column(name = "log_time")
	private LocalDateTime logTime;

	public LoginAttemptLog() {
	}

	public LoginAttemptLog(String detailMessage) {
		this.detailMessage = detailMessage;
		this.logTime = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "AuthErrorLog [id=" + id + ", detailMessage=" + detailMessage + ", logTime=" + logTime + "]";
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
		LoginAttemptLog that = (LoginAttemptLog) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}
}