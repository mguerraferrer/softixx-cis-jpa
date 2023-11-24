package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "error_log"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "error_log", schema = "errors")
@SequenceGenerator(name = "default_gen", sequenceName = "errors.error_log_seq", allocationSize = 1)
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

	/* Getters and Setters */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getServletName() {
		return servletName;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public LocalDateTime getLogTime() {
		return logTime;
	}

	public void setLogTime(LocalDateTime logTime) {
		this.logTime = logTime;
	}

	/* toString */
	@Override
	public String toString() {
		return "ErrorLog [id=" + id + ", user=" + user + ", exception=" + exception + ", exceptionType=" + exceptionType
				+ ", message=" + message + ", requestUri=" + requestUri + ", servletName=" + servletName
				+ ", statusCode=" + statusCode + ", logTime=" + logTime + "]";
	}

}