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
import jakarta.persistence.Version;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.AuditableEntity;

/**
 * Persistent class for entity stored in table "consultation_procedure"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "consultation_procedure", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.consultation_procedure_seq", allocationSize = 1)
public class ConsultationProcedure extends AuditableEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "planning_id", referencedColumnName = "id")
	private Planning planning;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;

	@Column(name = "default_procedure")
	private boolean defaultProcedure;

	@Column(name = "subtotal")
	private BigDecimal subtotal;

	@Column(name = "tax")
	private boolean tax;

	@Column(name = "discount")
	private Integer discount;

	@Column(name = "total")
	private BigDecimal total;

	@Column(name = "discount_start_date")
	private LocalDateTime discountStartDate;

	@Column(name = "discount_due_date")
	private LocalDateTime discountDueDate;

	@Version
	private Long version;

	@Column(name = "active")
	private boolean active;

	public ConsultationProcedure() {
	}

	public ConsultationProcedure(Planning planning, String description, BigDecimal subtotal, BigDecimal total) {
		this.planning = planning;
		this.code = CodeGeneratorUtils.asString();
		this.description = description;
		this.defaultProcedure = true;
		this.subtotal = subtotal;
		this.total = total;
		this.createOn = LocalDateTime.now(); // For cache purposes
		this.updateOn = LocalDateTime.now(); // For cache purposes
		this.active = true;
	}

	public ConsultationProcedure(Planning planning, String description, BigDecimal subtotal, boolean tax,
			Integer discount, BigDecimal total) {
		this.planning = planning;
		this.code = CodeGeneratorUtils.asString();
		this.description = description;
		this.defaultProcedure = false;
		this.subtotal = subtotal;
		this.tax = tax;
		this.discount = discount;
		this.total = total;
		this.createOn = LocalDateTime.now(); // For cache purposes
		this.updateOn = LocalDateTime.now(); // For cache purposes
		this.active = true;
	}

	/* Getters and Setters */
	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

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

	public boolean isDefaultProcedure() {
		return defaultProcedure;
	}

	public void setDefaultProcedure(boolean defaultProcedure) {
		this.defaultProcedure = defaultProcedure;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public boolean isTax() {
		return tax;
	}

	public void setTax(boolean tax) {
		this.tax = tax;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* toString */
	@Override
	public String toString() {
		return "ConsultationProcedure [id=" + id + ", planning=" + planning.getId() + ", code=" + code
				+ ", description=" + description + ", defaultProcedure=" + defaultProcedure + ", subtotal=" + subtotal
				+ ", tax=" + tax + ", discount=" + discount + ", total=" + total + ", discountStartDate="
				+ discountStartDate + ", discountDueDate=" + discountDueDate + ", version=" + version + ", creatOn="
				+ createOn + ", updateOn=" + updateOn + ", active=" + active + "]";
	}

}