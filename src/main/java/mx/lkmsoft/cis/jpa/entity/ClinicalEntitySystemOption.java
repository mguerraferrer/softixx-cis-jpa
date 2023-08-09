package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
 * Persistent class for entity stored in table "clinical_entity_system_option"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "clinical_entity_system_option", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_system_option_id_seq", allocationSize = 1)
public class ClinicalEntitySystemOption extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
    private ClinicalEntity clinicalEntity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_config_system_option_id", referencedColumnName = "id")
    private AutoConfigSystemOption autoConfigSystemOption;

    @Column(name = "hash")
    private String hash;

    @Column(name = "active")
    private boolean active;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntitySystemOption", targetEntity = SecureAccess.class)
	private List<SecureAccess> secureAccesses;

    public ClinicalEntitySystemOption() {
    }
    
    public ClinicalEntitySystemOption(ClinicalEntity clinicalEntity, AutoConfigSystemOption autoConfigSystemOption) {
		this.clinicalEntity = clinicalEntity;
		this.autoConfigSystemOption = autoConfigSystemOption;
		this.hash = UUID.randomUUID().toString().replace("-", "");
		this.active = true;
    }

    /* Getters and Setters */
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

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}
    
    public AutoConfigSystemOption getAutoConfigSystemOption() {
		return autoConfigSystemOption;
	}

	public void setAutoConfigSystemOption(AutoConfigSystemOption autoConfigSystemOption) {
		this.autoConfigSystemOption = autoConfigSystemOption;
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
		return "ClinicalEntitySystemOption [id=" + id + ", clinicalEntity=" + clinicalEntity.getId() + ", autoConfigSystemOption="
				+ autoConfigSystemOption.getId() + ", hash=" + hash + ", active=" + active + "]";
	}

}