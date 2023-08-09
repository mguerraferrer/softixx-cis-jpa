package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "webapp_config"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "settings_bag", schema = "config")
@SequenceGenerator(name = "default_gen", sequenceName = "config.settings_bag_id_seq", allocationSize = 1)
public class SettingsBag extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private String value;

    @Column(name = "active")
    private boolean active;

    public SettingsBag() {
    }
    
    public SettingsBag(String code, String value) {
		this.code = code;
		this.value = value;
		this.active = true;
	}

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* toString */
    public String toString() { 
        var sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(code);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(active);
        return sb.toString();
    }

}