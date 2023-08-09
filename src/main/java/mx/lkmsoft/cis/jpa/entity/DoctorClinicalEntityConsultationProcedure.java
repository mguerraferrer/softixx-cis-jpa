package mx.lkmsoft.cis.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "doctor_clinical_entity_consultation_procedure"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "doctor_clinical_entity_consultation_procedure", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_clinical_entity_consultation_procedure_id_seq", allocationSize = 1)
public class DoctorClinicalEntityConsultationProcedure extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_clinical_entity_specialty_id", referencedColumnName = "id")
	private DoctorClinicalEntitySpecialty doctorClinicalEntitySpecialty;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;

	@Column(name = "subtotal")
	private BigDecimal subtotal;

	@Column(name = "tax")
	private BigDecimal tax;

	@Column(name = "discount")
	private BigDecimal discount;

	@Column(name = "total")
	private BigDecimal total;

	@Column(name = "discount_start_date")
	private LocalDateTime discountStartDate;

	@Column(name = "discount_due_date")
	private LocalDateTime discountDueDate;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public LocalDateTime getDiscountStartDate() {
		return discountStartDate;
	}

	public void setDiscountStartDate(LocalDateTime discountStartDate) {
		this.discountStartDate = discountStartDate;
	}

	public LocalDateTime getDiscountDueDate() {
		return discountDueDate;
	}

	public void setDiscountDueDate(LocalDateTime discountDueDate) {
		this.discountDueDate = discountDueDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public DoctorClinicalEntitySpecialty getDoctorClinicalEntitySpecialty() {
		return doctorClinicalEntitySpecialty;
	}

	public void setDoctorClinicalEntitySpecialty(DoctorClinicalEntitySpecialty doctorClinicalEntitySpecialty) {
		this.doctorClinicalEntitySpecialty = doctorClinicalEntitySpecialty;
	}

	/* toString */
	@Override
	public String toString() {
		return "DoctorClinicalEntityConsultationProcedure [id=" + id + ", doctorClinicalEntitySpecialty="
				+ doctorClinicalEntitySpecialty.getId() + ", code=" + code + ", description=" + description
				+ ", subtotal=" + subtotal + ", tax=" + tax + ", discount=" + discount + ", total=" + total
				+ ", discountStartDate=" + discountStartDate + ", discountDueDate=" + discountDueDate + ", active="
				+ active + "]";
	}

}