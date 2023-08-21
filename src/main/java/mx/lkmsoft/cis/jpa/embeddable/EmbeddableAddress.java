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
	
	/* Getters and Setters */
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBtwStreet() {
		return btwStreet;
	}

	public void setBtwStreet(String btwStreet) {
		this.btwStreet = btwStreet;
	}

	public String getOutsideNumber() {
		return outsideNumber;
	}

	public void setOutsideNumber(String outsideNumber) {
		this.outsideNumber = outsideNumber;
	}

	public String getInsideNumber() {
		return insideNumber;
	}

	public void setInsideNumber(String insideNumber) {
		this.insideNumber = insideNumber;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}