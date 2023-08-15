package mx.lkmsoft.cis.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
 * Persistent class for entity stored in table
 * "private_practice_consultation_procedure"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "private_practice_consultation_procedure", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.private_practice_consultation_procedure_id_seq", allocationSize = 1)
public class PrivatePracticeConsultationProcedure extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_id", referencedColumnName = "id")
	private PrivatePractice privatePractice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_specialty_id", referencedColumnName = "id")
	private DoctorSpecialty doctorSpecialty;

	@Column(name = "hash")
	private String hash;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privatePracticeProcedure", targetEntity = Appointment.class)
	private List<Appointment> appointments;

	public PrivatePracticeConsultationProcedure() {
	}

	public PrivatePracticeConsultationProcedure(PrivatePractice privatePractice, DoctorSpecialty doctorSpecialty,
			String hash, String description, BigDecimal subtotal, BigDecimal total) {
		this.privatePractice = privatePractice;
		this.doctorSpecialty = doctorSpecialty;
		this.hash = hash;
		this.description = description;
		this.subtotal = subtotal;
		this.total = total;
		this.active = true;
	}

	/* Getters and Setters */
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
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

	public PrivatePractice getPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(PrivatePractice privatePractice) {
		this.privatePractice = privatePractice;
	}

	public DoctorSpecialty getDoctorSpecialty() {
		return doctorSpecialty;
	}

	public void setDoctorSpecialty(DoctorSpecialty doctorSpecialty) {
		this.doctorSpecialty = doctorSpecialty;
	}

	public List<Appointment> getAppointments() {
		if (appointments == null) {
			appointments = new ArrayList<>();
		}
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	/* toString */
	@Override
	public String toString() {
		return "PrivatePracticeConsultationProcedure [id=" + id + ", privatePractice=" + privatePractice.getId()
				+ ", doctorSpecialty=" + doctorSpecialty.getId() + ", hash=" + hash + ", description=" + description
				+ ", subtotal=" + subtotal + ", tax=" + tax + ", discount=" + discount + ", total=" + total
				+ ", discountStartDate=" + discountStartDate + ", discountDueDate=" + discountDueDate + ", active="
				+ active + "]";
	}

}