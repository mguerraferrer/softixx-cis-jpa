package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * Persistent class for entity stored in table "settings_bag"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "application_settings", schema = "config")
@SequenceGenerator(name = "default_gen", sequenceName = "config.application_settings_seq", allocationSize = 1)
@Getter
@Setter
public class ApplicationSetting extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private String value;

    @Column(name = "active")
    private boolean active;

    public ApplicationSetting() {
    }
    
    public ApplicationSetting(String code, String value) {
		this.code = code;
		this.value = value;
		this.active = true;
	}

	/* toString */
	@Override
	public String toString() {
		return "SettingsBag [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
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
		ApplicationSetting that = (ApplicationSetting) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}