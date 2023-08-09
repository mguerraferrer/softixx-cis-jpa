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
 * Persistent class for entity stored in table "associated_account"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "associated_account", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.associated_account_id_seq", allocationSize = 1)
public class AssociatedAccount extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "master_account_id", referencedColumnName = "id")
	private MasterAccount masterAccount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "active")
	private boolean active;

	public AssociatedAccount() {
	}

	public AssociatedAccount(MasterAccount masterAccount, User user) {
		this.masterAccount = masterAccount;
		this.user = user;
		this.active = false;
	}

	/* Getters and Setters */
	public MasterAccount getMasterAccount() {
		return masterAccount;
	}

	public void setMasterAccount(MasterAccount masterAccount) {
		this.masterAccount = masterAccount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "AssociatedAccount [id=" + id + ", masterAccount=" + masterAccount.getId() + ", user=" + user.getId()
				+ ", active=" + active + "]";
	}

}