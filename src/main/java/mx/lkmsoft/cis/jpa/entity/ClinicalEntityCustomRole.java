package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "clinical_entity_custom_role"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "clinical_entity_custom_role", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_custom_role_id_seq", allocationSize = 1)
public class ClinicalEntityCustomRole extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@Column(name = "code")
	private String code;

	@Column(name = "value")
	private String value;

	@Column(name = "active")
	private boolean active;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntityCustomRole", targetEntity = SecureAccess.class)
	private List<SecureAccess> secureAccesses;

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

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}
	
	public List<SecureAccess> getSecureAccesses() {
		if (secureAccesses == null) {
			secureAccesses = new ArrayList<>();
		}
		return secureAccesses;
	}

	public void setSecureAccesses(List<SecureAccess> secureAccesses) {
		this.secureAccesses = secureAccesses;
	}

	/* toString */
	@Override
	public String toString() {
		return "ClinicalEntityCustomRole [id=" + id + ", clinicalEntity=" + clinicalEntity.getId() + ", code=" + code
				+ ", value=" + value + ", active=" + active + "]";
	}

}