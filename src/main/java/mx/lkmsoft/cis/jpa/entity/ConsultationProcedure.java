package mx.lkmsoft.cis.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.AuditableEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "consultation_procedure"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "consultation_procedure", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.consultation_procedure_seq", allocationSize = 1)
@Getter
@Setter
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
		this.createOn = LocalDateTime.now();
		this.updateOn = LocalDateTime.now();
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
		this.createOn = LocalDateTime.now();
		this.updateOn = LocalDateTime.now();
		this.active = true;
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

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		ConsultationProcedure that = (ConsultationProcedure) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}
}