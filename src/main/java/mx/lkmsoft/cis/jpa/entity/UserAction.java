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
 * Persistent class for entity stored in table "user_action"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_action", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.user_action_id_seq", allocationSize = 1)
public class UserAction extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "access_level_id", referencedColumnName = "id")
    private AccessLevel accessLevel;
    
    @Column(name = "action")
    private Integer action;

    /* Getters and Setters */
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}
	
    public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	/* toString */
	@Override
	public String toString() {
		return "UserAction [id=" + id + ", accessLevel=" + accessLevel.getId() + ", action=" + action + "]";
	}

}