package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * Persistent class for entity stored in table "clinical_entity_preferences"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "clinical_entity_preferences", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_preferences_id_seq", allocationSize = 1)
public class ClinicalEntityPreferences extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
    private ClinicalEntity clinicalEntity;
	
    @Column(name = "paged")
    private Integer paged;

    @Column(name = "ip")
    @Convert(converter = AttributeEncryptor.class)
    private String ip;

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

    public ClinicalEntityPreferences() {    	
    }
    
    public ClinicalEntityPreferences(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
		this.paged = 10;
		this.active = true;
    }
    
    /* Getters and Setters */
	public Integer getPaged() {
		return paged;
	}

	public void setPaged(Integer paged) {
		this.paged = paged;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	/* toString */
	public String toString() { 
        var sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(paged);
        sb.append("|");
        sb.append(ip);
        sb.append("|");
        sb.append(ipRangeStart);
        sb.append("|");
        sb.append(ipRangeEnd);
        sb.append("|");
        sb.append(pwdExpiration);
        sb.append("|");
        sb.append(active);
        return sb.toString();
    }

}