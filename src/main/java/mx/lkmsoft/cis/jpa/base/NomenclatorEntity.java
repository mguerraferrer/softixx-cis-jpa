package mx.lkmsoft.cis.jpa.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@MappedSuperclass
public class NomenclatorEntity extends BaseEntity {
	
	@Column(name = "code")
	protected String code;

	@Column(name = "value")
	protected String value;

	@Column(name = "active")
	protected boolean active;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}