package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.NomenclatorEntity;

/**
 * Persistent class for entity stored in table "online_payment"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "online_payment", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.online_payment_id_seq", allocationSize = 1)
public class OnlinePayment extends NomenclatorEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "onlinePayment", targetEntity = LicenseCommission.class)
	private List<LicenseCommission> licenseCommissions;

	/* Getters and Setters */
	public List<LicenseCommission> getLicenseCommissions() {
		if (licenseCommissions == null) {
			licenseCommissions = new ArrayList<>();
		}
		return licenseCommissions;
	}

	public void setLicenseCommissions(List<LicenseCommission> licenseCommissions) {
		this.licenseCommissions = licenseCommissions;
	}

	/* toString */
	@Override
	public String toString() {
		return "PaymentMode [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
	}

}