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
 * Persistent class for entity stored in table "auth_error_log"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "auth_error_log", schema = "errors")
@SequenceGenerator(name = "default_gen", sequenceName = "errors.auth_error_log_seq", allocationSize = 1)
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

	/* Getters and Setters */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public LocalDateTime getLogTime() {
		return logTime;
	}

	public void setLogTime(LocalDateTime logTime) {
		this.logTime = logTime;
	}

	@Override
	public String toString() {
		return "AuthErrorLog [id=" + id + ", user=" + user.getId() + ", cause=" + cause + ", errorCode=" + errorCode
				+ ", httpStatus=" + httpStatus + ", detailMessage=" + detailMessage + ", logTime=" + logTime + "]";
	}

}