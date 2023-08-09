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

	@Column(name = "specialized_sheet_code")
	private String specializedSheetCode;

	@Column(name = "icon")
	private String icon;

	@Column(name = "image")
	private String image;

	@Column(name = "available_for_private_practice")
	private boolean availableForPrivatePractice;

	@Column(name = "available_for_clinical_entity")
	private boolean availableForClinicalEntity;

	@Column(name = "value")
	private String value;

	@Column(name = "visible")
	private boolean visible;

	@Column(name = "active")
	private boolean active;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty", targetEntity = DoctorSpecialty.class)
	private List<DoctorSpecialty> doctorSpecialties;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty", targetEntity = DoctorClinicalEntitySpecialty.class)
	private List<DoctorClinicalEntitySpecialty> doctorClinicalEntitySpecialties;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty", targetEntity = ClinicalEntitySpecialty.class)
	private List<ClinicalEntitySpecialty> clinicalEntitySpecialties;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSpecializedSheetCode() {
		return specializedSheetCode;
	}

	public void setSpecializedSheetCode(String specializedSheetCode) {
		this.specializedSheetCode = specializedSheetCode;
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

	public boolean isAvailableForPrivatePractice() {
		return availableForPrivatePractice;
	}

	public void setAvailableForPrivatePractice(boolean availableForPrivatePractice) {
		this.availableForPrivatePractice = availableForPrivatePractice;
	}

	public boolean isAvailableForClinicalEntity() {
		return availableForClinicalEntity;
	}

	public void setAvailableForClinicalEntity(boolean availableForClinicalEntity) {
		this.availableForClinicalEntity = availableForClinicalEntity;
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

	public List<DoctorClinicalEntitySpecialty> getDoctorClinicalEntitySpecialties() {
		if (doctorClinicalEntitySpecialties == null) {
			doctorClinicalEntitySpecialties = new ArrayList<>();
		}
		return doctorClinicalEntitySpecialties;
	}

	public void setDoctorClinicalEntitySpecialties(List<DoctorClinicalEntitySpecialty> doctorClinicalEntitySpecialties) {
		this.doctorClinicalEntitySpecialties = doctorClinicalEntitySpecialties;
	}

	public List<ClinicalEntitySpecialty> getClinicalEntitySpecialties() {
		if (clinicalEntitySpecialties == null) {
			clinicalEntitySpecialties = new ArrayList<>();
		}
		return clinicalEntitySpecialties;
	}

	public void setClinicalEntitySpecialties(List<ClinicalEntitySpecialty> clinicalEntitySpecialties) {
		this.clinicalEntitySpecialties = clinicalEntitySpecialties;
	}

	/* toString */
	@Override
	public String toString() {
		return "Specialty [id=" + id + ", code=" + code + ", specializedSheetCode=" + specializedSheetCode + ", icon="
				+ icon + ", image=" + image + ", availableForPrivatePractice=" + availableForPrivatePractice
				+ ", availableForClinicalEntity=" + availableForClinicalEntity + ", value=" + value + ", visible="
				+ visible + ", active=" + active + "]";
	}

}