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
 * Persistent class for entity stored in table "payment_source"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "payment_source", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.payment_source_id_seq", allocationSize = 1)
public class PaymentSource extends NomenclatorEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentSource", targetEntity = UserLicensePaymentHistory.class)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentSource", targetEntity = LicenseCommission.class)
	private List<LicenseCommission> licenseCommissions;

	/* Getters and Setters */
	public List<UserLicensePaymentHistory> getUserLicensePaymentHistories() {
		if (userLicensePaymentHistories == null) {
			userLicensePaymentHistories = new ArrayList<>();
		}
		return userLicensePaymentHistories;
	}

	public void setUserLicensePaymentHistories(List<UserLicensePaymentHistory> userLicensePaymentHistories) {
		this.userLicensePaymentHistories = userLicensePaymentHistories;
	}

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
		return "PaymentSource [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
	}

}