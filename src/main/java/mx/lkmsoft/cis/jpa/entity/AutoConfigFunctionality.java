package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "auto_config_functionality"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "auto_config_functionality", schema = "config")
@SequenceGenerator(name = "default_gen", sequenceName = "config.auto_config_functionality_id_seq", allocationSize = 1)
public class AutoConfigFunctionality extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "functionality_id", referencedColumnName = "id")
	private Functionality functionality;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_type_id", referencedColumnName = "id")
	private LicenseType licenseType;

	@Column(name = "private_practice")
	private boolean privatePractice;

	@Column(name = "clinical_entity")
	private boolean clinicalEntity;

	@Column(name = "active")
	private boolean active;

	public AutoConfigFunctionality() {		
	}
	
	public AutoConfigFunctionality(Functionality functionality, LicenseType licenseType, boolean privatePractice,
			boolean clinicalEntity) {
		this.functionality = functionality;
		this.licenseType = licenseType;
		this.privatePractice = privatePractice;
		this.clinicalEntity = clinicalEntity;
		this.active = true;
	}

	/* Getters and Setters */
	public Functionality getFunctionality() {
		return functionality;
	}

	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}

	public LicenseType getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(LicenseType licenseType) {
		this.licenseType = licenseType;
	}

	public boolean isPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(boolean privatePractice) {
		this.privatePractice = privatePractice;
	}

	public boolean isClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(boolean clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* toString */
	@Override
	public String toString() {
		return "AutoConfigFunctionality [id=" + id + ", functionality=" + functionality.getId() + ", licenseType="
				+ licenseType.getId() + ", privatePractice=" + privatePractice + ", clinicalEntity=" + clinicalEntity
				+ ", active=" + active + "]";
	}

}