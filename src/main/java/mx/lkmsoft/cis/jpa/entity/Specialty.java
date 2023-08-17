package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "specialty"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "specialties", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.specialty_id_seq", allocationSize = 1)
public class Specialty extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "icon")
	private String icon;

	@Column(name = "image")
	private String image;

	@Column(name = "value")
	private String value;

	@Column(name = "visible")
	private boolean visible;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty", targetEntity = DoctorSpecialty.class)
	private List<DoctorSpecialty> doctorSpecialties;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty", targetEntity = HealthcareCenterSpecialty.class)
	private List<HealthcareCenterSpecialty> healthcareCenterSpecialties;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<DoctorSpecialty> getDoctorSpecialties() {
		if (doctorSpecialties == null) {
			doctorSpecialties = new ArrayList<>();
		}
		return doctorSpecialties;
	}

	public void setDoctorSpecialties(List<DoctorSpecialty> doctorSpecialties) {
		this.doctorSpecialties = doctorSpecialties;
	}

	public List<HealthcareCenterSpecialty> getHealthcareCenterSpecialties() {
		if (healthcareCenterSpecialties == null) {
			healthcareCenterSpecialties = new ArrayList<>();
		}
		return healthcareCenterSpecialties;
	}

	public void setHealthcareCenterSpecialties(List<HealthcareCenterSpecialty> healthcareCenterSpecialties) {
		this.healthcareCenterSpecialties = healthcareCenterSpecialties;
	}

	/* toString */
	@Override
	public String toString() {
		return "Specialty [id=" + id + ", code=" + code + ", icon=" + icon + ", image=" + image + ", value=" + value
				+ ", visible=" + visible + ", active=" + active + "]";
	}

}