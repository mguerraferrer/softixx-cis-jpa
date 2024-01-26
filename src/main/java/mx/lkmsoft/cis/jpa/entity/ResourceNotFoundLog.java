package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Persistent class for entity stored in table "resource_not_found_log"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "resource_not_found_log", schema = "errors")
@SequenceGenerator(name = "default_gen", sequenceName = "errors.resource_not_found_log_seq", allocationSize = 1)
@Getter
@Setter
public class ResourceNotFoundLog extends BaseEntity {

	@Column(name = "handler_method")
	private String handlerMethod;

	@Column(name = "exception_class")
	private String exceptionClass;

	@Column(name = "exception_message")
	private String exceptionMessage;

	@Column(name = "request_url")
	private String requestUrl;

	@Column(name = "log_time")
	private LocalDateTime logTime;

	public ResourceNotFoundLog() {
	}

	public ResourceNotFoundLog(String handlerMethod, String exceptionClass, String exceptionMessage, String requestUrl) {
		this.handlerMethod = handlerMethod;
		this.exceptionClass = exceptionClass;
		this.exceptionMessage = exceptionMessage;
		this.requestUrl = requestUrl;
		this.logTime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "AuthErrorLog [id=" + id + ", handlerMethod=" + handlerMethod + ", exceptionClass=" + exceptionClass
				+ ", exceptionMessage=" + exceptionMessage + ", requestUrl=" + requestUrl + ", logTime=" + logTime + "]";
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
		ResourceNotFoundLog that = (ResourceNotFoundLog) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}