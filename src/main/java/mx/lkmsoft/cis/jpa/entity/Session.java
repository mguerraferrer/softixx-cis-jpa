package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

@Entity
@Table(name = "sessions", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.session_seq_id", allocationSize = 1)
public class Session extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "session_key", unique = true)
	private String sessionKey;
	
	@Column(name="session_date")
	private LocalDateTime sessionDate;
	
	@Column(name = "url", unique = true)
	private String url;
	
	@Column(name = "ip", unique = true)
	private String ip;
	
	/* Getters and Setters */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	
	public LocalDateTime getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(LocalDateTime sessionDate) {
		this.sessionDate = sessionDate;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Session [user=" + user.getEmail() + ", sessionKey=" + sessionKey + ", sessionDate=" + sessionDate
				+ ", url=" + url + ", ip="
				+ ip + "]";
	}

}