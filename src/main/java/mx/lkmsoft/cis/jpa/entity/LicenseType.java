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
 * Persistent class for entity stored in table "license_type"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_type", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_type_id_seq", allocationSize = 1)
public class LicenseType extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "value")
	private String value;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licenseType", targetEntity = License.class)
	private List<License> licenses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licenseType", targetEntity = AutoConfigFunctionality.class)
	private List<AutoConfigFunctionality> autoConfigFunctionalities;

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

	public List<License> getLicenses() {
		if (licenses == null) {
			licenses = new ArrayList<>();
		}
		return licenses;
	}

	public void setLicenses(List<License> licenses) {
		this.licenses = licenses;
	}
	
	public List<AutoConfigFunctionality> getAutoConfigFunctionalities() {
		if (autoConfigFunctionalities == null) {
			autoConfigFunctionalities = new ArrayList<>();
		}
		return autoConfigFunctionalities;
	}

	public void setAutoConfigFunctionalities(List<AutoConfigFunctionality> autoConfigFunctionalities) {
		this.autoConfigFunctionalities = autoConfigFunctionalities;
	}

	/* toString */
	@Override
	public String toString() {
		return "LicenseType [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
	}

}