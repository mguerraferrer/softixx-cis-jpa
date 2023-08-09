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
 * Persistent class for entity stored in table "clinical_entity_connection_info"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "clinical_entity_connection_info", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_connection_info_id_seq", allocationSize = 1)
public class ClinicalEntityConnectionInfo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_access_info_id", referencedColumnName = "id")
	private ClinicalEntityAccessInfo clinicalEntityAccessInfo;

	@Column(name = "ip")
	private String ip;

	@Column(name = "ip_range_start")
	private String ipRangeStart;

	@Column(name = "ip_range_end")
	private String ipRangeEnd;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ClinicalEntityAccessInfo getClinicalEntityAccessInfo() {
		return clinicalEntityAccessInfo;
	}

	public void setClinicalEntityAccessInfo(ClinicalEntityAccessInfo clinicalEntityAccessInfo) {
		this.clinicalEntityAccessInfo = clinicalEntityAccessInfo;
	}

	/* toString */
	@Override
	public String toString() {
		return "ClinicalEntityConnectionInfo [id=" + id + ", clinicalEntityAccessInfo="
				+ clinicalEntityAccessInfo.getId() + ", ip=" + ip + ", ipRangeStart=" + ipRangeStart + ", ipRangeEnd="
				+ ipRangeEnd + ", active=" + active + "]";
	}

}