package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "auth_error_log"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "auth_error_log", schema = "errors")
@SequenceGenerator(name = "default_gen", sequenceName = "errors.auth_error_log_seq", allocationSize = 1)
@Getter
@Setter
public class AuthErrorLog extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "cause")
	private String cause;

	@Column(name = "error_code")
	private String errorCode;

	@Column(name = "http_status")
	private String httpStatus;

	@Column(name = "detail_message")
	private String detailMessage;

	@Column(name = "log_time")
	private LocalDateTime logTime;

	public AuthErrorLog() {
	}

	public AuthErrorLog(User user) {
		this.user = user;
		this.logTime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "AuthErrorLog [id=" + id + ", user=" + user.getId() + ", cause=" + cause + ", errorCode=" + errorCode
				+ ", httpStatus=" + httpStatus + ", detailMessage=" + detailMessage + ", logTime=" + logTime + "]";
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
		AuthErrorLog that = (AuthErrorLog) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
				? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
				: getClass().hashCode();
	}
}