package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

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

	@Column(name = "ip_range_start")
	@Convert(converter = AttributeEncryptor.class)
	private String ipRangeStart;

	@Column(name = "ip_range_end")
	@Convert(converter = AttributeEncryptor.class)
	private String ipRangeEnd;

	@Column(name = "pwd_expiration")
	private Integer pwdExpiration;

	@Column(name = "active")
	private boolean active;

	@OneToOne(mappedBy = "healthcareCenter", cascade = CascadeType.ALL)
	private HealthcareCenterContact healthcareCenterContact;

	@OneToOne(mappedBy = "healthcareCenter", cascade = CascadeType.ALL)
	private HealthcareCenterAddress healthcareCenterAddress;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = HealthcareCenterAccess.class)
	private List<HealthcareCenterAccess> healthcareCenterAccesses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = HealthcareCenterSpecialty.class)
	private List<HealthcareCenterSpecialty> healthcareCenterSpecialties;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = MasterAccount.class)
	private List<MasterAccount> masterAccounts;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = ConsultationProcedure.class)
	private List<ConsultationProcedure> consultationProcedures;

	public HealthcareCenter() {
	}

	public HealthcareCenter(String name, String businessName) {
		this.name = name;
		this.businessName = businessName;
		this.logo = null;
		this.code = UUID.randomUUID().toString().toUpperCase().replace("-", "");
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

	public String getIpRangeStart() {
		return ipRangeStart;
	}

	public void setIpRangeStart(String ipRangeStart) {
		this.ipRangeStart = ipRangeStart;
	}

	public String getIpRangeEnd() {
		return ipRangeEnd;
	}

	public void setIpRangeEnd(String ipRangeEnd) {
		this.ipRangeEnd = ipRangeEnd;
	}

	public Integer getPwdExpiration() {
		return pwdExpiration;
	}

	public void setPwdExpiration(Integer pwdExpiration) {
		this.pwdExpiration = pwdExpiration;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public HealthcareCenterContact getHealthcareCenterContact() {
		return healthcareCenterContact;
	}

	public void setHealthcareCenterContact(HealthcareCenterContact healthcareCenterContact) {
		this.healthcareCenterContact = healthcareCenterContact;
		this.healthcareCenterContact.setHealthcareCenter(this);
	}

	public HealthcareCenterAddress getHealthcareCenterAddress() {
		return healthcareCenterAddress;
	}

	public void setHealthcareCenterAddress(HealthcareCenterAddress healthcareCenterAddress) {
		this.healthcareCenterAddress = healthcareCenterAddress;
		this.healthcareCenterAddress.setHealthcareCenter(this);
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

	/* toString */
	@Override
	public String toString() {
		return "HealthcareCenter [id=" + id + ", name=" + name + ", businessName=" + businessName + ", logo=" + logo
				+ ", code=" + code + ", ipRangeStart=" + ipRangeStart + ", ipRangeEnd=" + ipRangeEnd
				+ ", pwdExpiration=" + pwdExpiration + ", active=" + active + "]";
	}

}