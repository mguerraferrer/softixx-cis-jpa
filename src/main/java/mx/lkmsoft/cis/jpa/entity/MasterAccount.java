package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * Persistent class for entity stored in table "master_account"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "master_account", schema = "security")
@Getter
@Setter
public class MasterAccount {

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcare_center_id", referencedColumnName = "id")
	private HealthcareCenter healthcareCenter;

	@Column(name = "active")
	private boolean active;

	public MasterAccount() {
	}

	public MasterAccount(User user, HealthcareCenter healthcareCenter) {
		this.user = user;
		this.healthcareCenter = healthcareCenter;
		this.active = true;
	}

	/* toString */
	@Override
	public String toString() {
		return "MasterAccount [id=" + id + ", user=" + user + ", healthcareCenter=" + healthcareCenter + ", active="
				+ active + "]";
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
		MasterAccount that = (MasterAccount) o;
		return id != null && Objects.equals(id, that.id);
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}