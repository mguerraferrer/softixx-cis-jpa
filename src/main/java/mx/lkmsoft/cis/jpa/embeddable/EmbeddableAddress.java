package mx.lkmsoft.cis.jpa.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Embeddable
@Getter
@Setter
public class EmbeddableAddress {
	
	@Column(name = "street")
	@Convert(converter = AttributeEncryptor.class)
	protected String street;

	@Column(name = "btw_street")
	@Convert(converter = AttributeEncryptor.class)
	protected String btwStreet;

	@Column(name = "outside_number")
	@Convert(converter = AttributeEncryptor.class)
	protected String outsideNumber;

	@Column(name = "inside_number")
	@Convert(converter = AttributeEncryptor.class)
	protected String insideNumber;

	@Column(name = "reference")
	@Convert(converter = AttributeEncryptor.class)
	protected String reference;
	
	@Column(name = "lat")
	@Convert(converter = AttributeEncryptor.class)
	protected String lat;

	@Column(name = "lon")
	@Convert(converter = AttributeEncryptor.class)
	protected String lon;
	
	@Column(name = "code")
	protected String code;
	
}