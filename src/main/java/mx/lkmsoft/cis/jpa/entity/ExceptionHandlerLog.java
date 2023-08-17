package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "exception_handler_log"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "exception_handler_log", schema = "trace")
@SequenceGenerator(name = "default_gen", sequenceName = "trace.exception_handler_log_id_seq", allocationSize = 1)
public class ExceptionHandlerLog extends BaseEntity {

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

	@Column(name = "code")
	private String code;

	public ExceptionHandlerLog() {
	}

	public ExceptionHandlerLog(String handlerMethod, 
							   String exceptionClass, 
							   String exceptionMessage,
							   String requestUrl) {
		this.handlerMethod = handlerMethod;
		this.exceptionClass = exceptionClass;
		this.exceptionMessage = exceptionMessage;
		this.requestUrl = requestUrl;
		this.logTime = LocalDateTime.now();
		this.code = UUID.randomUUID().toString();
	}

	public ExceptionHandlerLog(String handlerMethod, 
							   String exceptionClass, 
							   String exceptionMessage, 
							   String requestUrl,
							   String code) {
		this.handlerMethod = handlerMethod;
		this.exceptionClass = exceptionClass;
		this.exceptionMessage = exceptionMessage;
		this.requestUrl = requestUrl;
		this.logTime = LocalDateTime.now();
		this.code = code;
	}

	/* Getters and Setters */
	public String getHandlerMethod() {
		return handlerMethod;
	}

	public void setHandlerMethod(String handlerMethod) {
		this.handlerMethod = handlerMethod;
	}

	public String getExceptionClass() {
		return exceptionClass;
	}

	public void setExceptionClass(String exceptionClass) {
		this.exceptionClass = exceptionClass;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public LocalDateTime getLogTime() {
		return logTime;
	}

	public void setLogTime(LocalDateTime logTime) {
		this.logTime = logTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "AuthErrorLog [id=" + id + ", handlerMethod=" + handlerMethod + ", exceptionClass=" + exceptionClass
				+ ", exceptionMessage=" + exceptionMessage + ", requestUrl=" + requestUrl + ", logTime=" + logTime
				+ ", code=" + code + "]";
	}

}