package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "license_direct_promo"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_direct_promo", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_direct_promo_seq", allocationSize = 1)
@Getter
@Setter
public class LicenseDirectPromo extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "discount")
	private Integer discount;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "due_date")
	private LocalDateTime dueDate;

	@Column(name = "used_in")
	private LocalDateTime usedIn;

	@Column(name = "available")
	private boolean available;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "licenseDirectPromo", targetEntity = UserLicensePaymentHistory.class)
	@Getter(AccessLevel.NONE)
	private List<UserLicensePaymentHistory> userLicensePaymentHistories;

	public List<UserLicensePaymentHistory> getUserLicensePaymentHistories() {
		if (userLicensePaymentHistories == null) {
			userLicensePaymentHistories = new ArrayList<>();
		}
		return userLicensePaymentHistories;
	}

	/* toString */
	public String toString() {
		return "LicenseDirectPromo [id=" + id + ", code=" + code + ", discount=" + discount + ", startDate=" + startDate
				+ ", dueDate=" + dueDate + ", usedIn=" + usedIn + ", available=" + available + ",  active=" + active + "]";
	}

}