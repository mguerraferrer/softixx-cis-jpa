package mx.lkmsoft.cis.jpa.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Embeddable
public class EmbeddableContact {
	
	@Column(name = "phone1")
	@Convert(converter = AttributeEncryptor.class)
	protected String phone1;

	@Column(name = "phone2")
	@Convert(converter = AttributeEncryptor.class)
	protected String phone2;

	@Column(name = "phone3")
	@Convert(converter = AttributeEncryptor.class)
	protected String phone3;
	
	@Column(name = "email1")
	@Convert(converter = AttributeEncryptor.class)
	protected String email1;

	@Column(name = "email2")
	@Convert(converter = AttributeEncryptor.class)
	protected String email2;

	@Column(name = "email3")
	@Convert(converter = AttributeEncryptor.class)
	protected String email3;

	/* Getters and Setters */
	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getPhones() {
		if (StringUtils.hasValue(phone1)) {
			var phoneBuilder = new StringBuilder(phone1);
			if (StringUtils.hasValue(phone2)) {
				phoneBuilder.append(", ").append(phone2);
			}
			if (StringUtils.hasValue(phone3)) {
				phoneBuilder.append(", ").append(phone3);
			}
			return phoneBuilder.toString();
		}
		return null;
	}

	public String getEmails() {
		if (StringUtils.hasValue(email1)) {
			var emailBuilder = new StringBuilder(email1);
			if (StringUtils.hasValue(email2)) {
				emailBuilder.append(", ").append(email2);
			}
			if (StringUtils.hasValue(email3)) {
				emailBuilder.append(", ").append(email3);
			}
			return emailBuilder.toString();
		}
		return null;
	}

	@Override
	public String toString() {
		return "EmbeddableContact [phone1=" + phone1 + ", phone2=" + phone2 + ", phone3=" + phone1
				+ ", email1=" + email1 + ", email2=" + email2 + ", email3=" + email3 + "]";
	}
}