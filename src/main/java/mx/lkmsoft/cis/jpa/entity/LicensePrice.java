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
 * Persistent class for entity stored in table "license_price"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_price", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_price_seq", allocationSize = 1)
public class LicensePrice extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_id", referencedColumnName = "id")
	private License license;

	@Column(name = "subtotal")
	private Double subtotal;

	@Column(name = "tax")
	private boolean tax;

	@Column(name = "tax_rate")
	private Integer taxRate;

	@Column(name = "total")
	private Double total;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public boolean isTax() {
		return tax;
	}

	public void setTax(boolean tax) {
		this.tax = tax;
	}

	public Integer getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	/* toString */
	@Override
	public String toString() {
		return "LicensePrice [id=" + id + ", license=" + license.getId() + ", subtotal=" + subtotal + ", tax=" + tax
				+ ", taxRate=" + taxRate + ", total=" + total + ", active=" + active + "]";
	}

}