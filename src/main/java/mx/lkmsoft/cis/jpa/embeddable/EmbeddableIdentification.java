package mx.lkmsoft.cis.jpa.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Embeddable
public class EmbeddableIdentification {
	
	@Column(name = "rfc")
	@Convert(converter = AttributeEncryptor.class)
	private String rfc;

	@Column(name = "curp")
	@Convert(converter = AttributeEncryptor.class)
	private String curp;
	
	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}
	
}