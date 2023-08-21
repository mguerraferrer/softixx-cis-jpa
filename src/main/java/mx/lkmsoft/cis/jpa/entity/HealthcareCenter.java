package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.common.uuid.UuidGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableAccess;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableContact;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableSocial;

/**
 * Persistent class for entity stored in table "healthcare_center"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "healthcare_center", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.healthcare_center_id_seq", allocationSize = 1)
public class HealthcareCenter extends BaseEntity {

	@Column(name = "name")
	@Convert(converter = AttributeEncryptor.class)
	private String name;

	@Column(name = "business_name")
	@Convert(converter = AttributeEncryptor.class)
	private String businessName;

	@Column(name = "logo")
	private String logo;

	@Column(name = "code")
	private String code;

	@Column(name = "pwd_expiration")
	private Integer pwdExpiration;

	@Embedded
	private EmbeddableAccess access;

	@Embedded
	private EmbeddableSocial social;

	@Embedded
	protected EmbeddableContact contact;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = HealthcareCenterAddress.class)
	private List<HealthcareCenterAddress> healthcareCenterAddresses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = HealthcareCenterAccess.class)
	private List<HealthcareCenterAccess> healthcareCenterAccesses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = HealthcareCenterSpecialty.class)
	private List<HealthcareCenterSpecialty> healthcareCenterSpecialties;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = MasterAccount.class)
	private List<MasterAccount> masterAccounts;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = ConsultationProcedure.class)
	private List<ConsultationProcedure> consultationProcedures;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = MedicalSchedule.class)
	private List<MedicalSchedule> medicalSchedules;

	public HealthcareCenter() {
	}

	public HealthcareCenter(String name, String businessName) {
		this.name = name;
		this.businessName = businessName;
		this.logo = null;
		this.code = UuidGeneratorUtils.asStringCode();
		this.active = true;
	}

	/* Getters and Setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPwdExpiration() {
		return pwdExpiration;
	}

	public void setPwdExpiration(Integer pwdExpiration) {
		this.pwdExpiration = pwdExpiration;
	}

	public EmbeddableAccess getAccess() {
		return access;
	}

	public void setAccess(EmbeddableAccess access) {
		this.access = access;
	}

	public EmbeddableSocial getSocial() {
		return social;
	}

	public void setSocial(EmbeddableSocial social) {
		this.social = social;
	}

	public EmbeddableContact getContact() {
		return contact;
	}

	public void setContact(EmbeddableContact contact) {
		this.contact = contact;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<HealthcareCenterAddress> getHealthcareCenterAddresses() {
		if (healthcareCenterAddresses == null) {
			healthcareCenterAddresses = new ArrayList<>();
		}
		return healthcareCenterAddresses;
	}

	public void setHealthcareCenterAddresses(List<HealthcareCenterAddress> healthcareCenterAddresses) {
		this.healthcareCenterAddresses = healthcareCenterAddresses;
	}

	public List<HealthcareCenterAccess> getHealthcareCenterAccesses() {
		if (healthcareCenterAccesses == null) {
			healthcareCenterAccesses = new ArrayList<>();
		}
		return healthcareCenterAccesses;
	}

	public void setHealthcareCenterAccesses(List<HealthcareCenterAccess> healthcareCenterAccesses) {
		this.healthcareCenterAccesses = healthcareCenterAccesses;
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

	public List<MasterAccount> getMasterAccounts() {
		if (masterAccounts == null) {
			masterAccounts = new ArrayList<>();
		}
		return masterAccounts;
	}

	public void setMasterAccounts(List<MasterAccount> masterAccounts) {
		this.masterAccounts = masterAccounts;
	}

	public List<ConsultationProcedure> getConsultationProcedures() {
		if (consultationProcedures == null) {
			consultationProcedures = new ArrayList<>();
		}
		return consultationProcedures;
	}

	public void setConsultationProcedures(List<ConsultationProcedure> consultationProcedures) {
		this.consultationProcedures = consultationProcedures;
	}

	public List<MedicalSchedule> getMedicalSchedules() {
		if (medicalSchedules == null) {
			medicalSchedules = new ArrayList<>();
		}
		return medicalSchedules;
	}

	public void setMedicalSchedules(List<MedicalSchedule> medicalSchedules) {
		this.medicalSchedules = medicalSchedules;
	}

	/* toString */
	@Override
	public String toString() {
		return "HealthcareCenter [id=" + id + ", name=" + name + ", businessName=" + businessName + ", logo=" + logo
				+ ", code=" + code + ", access=" + access + ", pwdExpiration=" + pwdExpiration + ", contact=" + contact
				+ ", social=" + social + ", active=" + active + "]";
	}

}