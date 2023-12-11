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
 * Persistent class for entity stored in table "error_log"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "error_log", schema = "errors")
@SequenceGenerator(name = "default_gen", sequenceName = "errors.error_log_seq", allocationSize = 1)
@Getter
@Setter
public class ErrorLog extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "exception")
	private String exception;

	@Column(name = "exception_type")
	private String exceptionType;

	@Column(name = "message")
	private String message;

	@Column(name = "request_uri")
	private String requestUri;

	@Column(name = "servlet_name")
	private String servletName;

	@Column(name = "status_code")
	private String statusCode;

	@Column(name = "log_time")
	private LocalDateTime logTime;

	public ErrorLog() {
	}

	public ErrorLog(User user, 
					String exception, 
					String exceptionType, 
					String message, 
					String requestUri,
					String servletName, 
					String statusCode) {
		this.user = user;
		this.exception = exception;
		this.exceptionType = exceptionType;
		this.message = message;
		this.requestUri = requestUri;
		this.servletName = servletName;
		this.statusCode = statusCode;
		this.logTime = LocalDateTime.now();
	}

	/* toString */
	@Override
	public String toString() {
		return "ErrorLog [id=" + id + ", user=" + user + ", exception=" + exception + ", exceptionType=" + exceptionType
				+ ", message=" + message + ", requestUri=" + requestUri + ", servletName=" + servletName
				+ ", statusCode=" + statusCode + ", logTime=" + logTime + "]";
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
		ErrorLog errorLog = (ErrorLog) o;
		return getId() != null && Objects.equals(getId(), errorLog.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}