package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * Persistent class for entity stored in table "clinical_entity"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "clinical_entity", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_id_seq", allocationSize = 1)
public class ClinicalEntity extends BaseEntity {

	@Column(name = "name")
	@Convert(converter = AttributeEncryptor.class)
	private String name;

	@Column(name = "business_name")
	@Convert(converter = AttributeEncryptor.class)
	private String businessName;

	@Column(name = "logo")
	private String logo;

	@Column(name = "hash")
	private String hash;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = ClinicalEntityContactInfo.class)
	private List<ClinicalEntityContactInfo> clinicalEntityContactInfos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = ClinicalEntitySpecialty.class)
	private List<ClinicalEntitySpecialty> clinicalEntitySpecialties;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = ClinicalEntitySystemOption.class)
	private List<ClinicalEntitySystemOption> clinicalEntitySystemOptions;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = ClinicalEntityFunctionality.class)
	private List<ClinicalEntityFunctionality> clinicalEntityFunctionalities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = ClinicalEntityAddress.class)
	private List<ClinicalEntityAddress> clinicalEntityAddresses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = ClinicalEntityAccessInfo.class)
	private List<ClinicalEntityAccessInfo> clinicalEntityAccessInfos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = ClinicalEntityPreferences.class)
	private List<ClinicalEntityPreferences> clinicalEntityPreferenceses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = ClinicalEntityCustomRole.class)
	private List<ClinicalEntityCustomRole> clinicalEntityCustomRoles;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = DoctorClinicalEntity.class)
	private List<DoctorClinicalEntity> doctorClinicalEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = AssistantClinicalEntity.class)
	private List<AssistantClinicalEntity> assistantClinicalEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = NurseClinicalEntity.class)
	private List<NurseClinicalEntity> nurseClinicalEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = MasterAccount.class)
	private List<MasterAccount> masterAccounts;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntity", targetEntity = PersonAccess.class)
	private List<PersonAccess> personAccesses;

	public ClinicalEntity() {
	}

	public ClinicalEntity(String name, String businessName) {
		this.name = name;
		this.businessName = businessName;
		this.logo = null;
		this.hash = UUID.randomUUID().toString().replace("-", "");
		this.active = false;
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

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<ClinicalEntityContactInfo> getClinicalEntityContactInfos() {
		if (clinicalEntityContactInfos == null) {
			clinicalEntityContactInfos = new ArrayList<>();
		}
		return clinicalEntityContactInfos;
	}

	public void setClinicalEntityContactInfos(List<ClinicalEntityContactInfo> clinicalEntityContactInfos) {
		this.clinicalEntityContactInfos = clinicalEntityContactInfos;
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

	public List<ClinicalEntitySystemOption> getClinicalEntitySystemOptions() {
		if (clinicalEntitySystemOptions == null) {
			clinicalEntitySystemOptions = new ArrayList<>();
		}
		return clinicalEntitySystemOptions;
	}

	public void setClinicalEntitySystemOptions(List<ClinicalEntitySystemOption> clinicalEntitySystemOptions) {
		this.clinicalEntitySystemOptions = clinicalEntitySystemOptions;
	}

	public List<ClinicalEntityFunctionality> getClinicalEntityFunctionalities() {
		if (clinicalEntityFunctionalities == null) {
			clinicalEntityFunctionalities = new ArrayList<>();
		}
		return clinicalEntityFunctionalities;
	}

	public void setClinicalEntityFunctionalities(List<ClinicalEntityFunctionality> clinicalEntityFunctionalities) {
		this.clinicalEntityFunctionalities = clinicalEntityFunctionalities;
	}

	public List<ClinicalEntityAddress> getClinicalEntityAddresses() {
		if (clinicalEntityAddresses == null) {
			clinicalEntityAddresses = new ArrayList<>();
		}
		return clinicalEntityAddresses;
	}

	public void setClinicalEntityAddresses(List<ClinicalEntityAddress> clinicalEntityAddresses) {
		this.clinicalEntityAddresses = clinicalEntityAddresses;
	}

	public List<ClinicalEntityAccessInfo> getClinicalEntityAccessInfos() {
		if (clinicalEntityAccessInfos == null) {
			clinicalEntityAccessInfos = new ArrayList<>();
		}
		return clinicalEntityAccessInfos;
	}

	public void setClinicalEntityAccessInfos(List<ClinicalEntityAccessInfo> clinicalEntityAccessInfos) {
		this.clinicalEntityAccessInfos = clinicalEntityAccessInfos;
	}

	public List<ClinicalEntityPreferences> getClinicalEntityPreferenceses() {
		if (clinicalEntityPreferenceses == null) {
			clinicalEntityPreferenceses = new ArrayList<>();
		}
		return clinicalEntityPreferenceses;
	}

	public void setClinicalEntityPreferenceses(List<ClinicalEntityPreferences> clinicalEntityPreferenceses) {
		this.clinicalEntityPreferenceses = clinicalEntityPreferenceses;
	}

	public List<ClinicalEntityCustomRole> getClinicalEntityCustomRoles() {
		if (clinicalEntityCustomRoles == null) {
			clinicalEntityCustomRoles = new ArrayList<>();
		}
		return clinicalEntityCustomRoles;
	}

	public void setClinicalEntityCustomRoles(List<ClinicalEntityCustomRole> clinicalEntityCustomRoles) {
		this.clinicalEntityCustomRoles = clinicalEntityCustomRoles;
	}

	public List<DoctorClinicalEntity> getDoctorClinicalEntities() {
		if (doctorClinicalEntities == null) {
			doctorClinicalEntities = new ArrayList<>();
		}
		return doctorClinicalEntities;
	}

	public void setDoctorClinicalEntities(List<DoctorClinicalEntity> doctorClinicalEntities) {
		this.doctorClinicalEntities = doctorClinicalEntities;
	}

	public List<AssistantClinicalEntity> getAssistantClinicalEntities() {
		if (assistantClinicalEntities == null) {
			assistantClinicalEntities = new ArrayList<>();
		}
		return assistantClinicalEntities;
	}

	public void setAssistantClinicalEntities(List<AssistantClinicalEntity> assistantClinicalEntities) {
		this.assistantClinicalEntities = assistantClinicalEntities;
	}

	public List<NurseClinicalEntity> getNurseClinicalEntities() {
		if (nurseClinicalEntities == null) {
			nurseClinicalEntities = new ArrayList<>();
		}
		return nurseClinicalEntities;
	}

	public void setNurseClinicalEntities(List<NurseClinicalEntity> nurseClinicalEntities) {
		this.nurseClinicalEntities = nurseClinicalEntities;
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

	public List<PersonAccess> getPersonAccesses() {
		if (personAccesses == null) {
			personAccesses = new ArrayList<>();
		}
		return personAccesses;
	}

	public void setPersonAccesses(List<PersonAccess> personAccesses) {
		this.personAccesses = personAccesses;
	}

	/* toString */
	@Override
	public String toString() {
		return "ClinicalEntity [id=" + id + ", name=" + name + ", businessName=" + businessName + ", logo=" + logo
				+ ", hash=" + hash + ", active=" + active + "]";
	}

}