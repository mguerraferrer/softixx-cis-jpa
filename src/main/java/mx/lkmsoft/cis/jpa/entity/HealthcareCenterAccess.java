package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableAccess;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * Persistent class for entity stored in table "participant"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "healthcare_center_access", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.healthcare_center_access_seq", allocationSize = 1)
@Getter
@Setter
public class HealthcareCenterAccess extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcare_center_id", referencedColumnName = "id")
	private HealthcareCenter healthcareCenter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Embedded
	private EmbeddableAccess access;
	
	@Column(name = "ip")
	@Convert(converter = AttributeEncryptor.class)
	private String ip;

	@Column(name = "active")
	private boolean active;

	public HealthcareCenterAccess() {
	}

	public HealthcareCenterAccess(HealthcareCenter healthcareCenter, User user) {
		this.healthcareCenter = healthcareCenter;
		this.user = user;
		this.active = true;
	}

	/* toString */
	@Override
	public String toString() {
		return "HealthcareCenterAccess [id=" + id + ", healthcareCenter=" + healthcareCenter + ", user=" + user
				+ ", access=" + access + ", ip=" + ip + ", active=" + active + "]";
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
		HealthcareCenterAccess that = (HealthcareCenterAccess) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}
}