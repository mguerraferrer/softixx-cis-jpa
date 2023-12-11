package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "non_working_day"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "non_working_day", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.non_working_day_seq", allocationSize = 1)
@Getter
@Setter
public class NonWorkingDay extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medical_schedule_id", referencedColumnName = "id")
	private MedicalSchedule medicalSchedule;

	@Column(name = "nw_date")
	private LocalDate date;

	public NonWorkingDay() {
	}

	public NonWorkingDay(MedicalSchedule medicalSchedule, LocalDate date) {
		this.medicalSchedule = medicalSchedule;
		this.date = date;
	}

	/* toString */
	@Override
	public String toString() {
		return "NonWorkingDay [id=" + id + ", medicalSchedule=" + medicalSchedule.getId() + ", date=" + date + "]";
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
		NonWorkingDay that = (NonWorkingDay) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}
}