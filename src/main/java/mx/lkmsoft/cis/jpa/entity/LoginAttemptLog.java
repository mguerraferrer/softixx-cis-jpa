package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "login_attempt_log"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "login_attempt_log", schema = "trace")
@SequenceGenerator(name = "default_gen", sequenceName = "trace.login_attempt_log_id_seq", allocationSize = 1)
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
	
	/* Getters and Setters */
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
		return "AuthErrorLog [id=" + id + ", detailMessage=" + detailMessage + ", logTime=" + logTime + "]";
	}

}