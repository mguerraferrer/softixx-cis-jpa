package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * Persistent class for entity stored in table "clinical_entity_address"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "clinical_entity_address", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_id_seq", allocationSize = 1)
public class ClinicalEntityAddress extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
    private ClinicalEntity clinicalEntity;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colony_id", referencedColumnName = "id")
    private Colony colony;
    
	@Column(name = "street")
	@Convert(converter = AttributeEncryptor.class)
    private String street;

    @Column(name = "btw_street")
    @Convert(converter = AttributeEncryptor.class)
    private String btwStreet;

    @Column(name = "outside_number")
    @Convert(converter = AttributeEncryptor.class)
    private String outsideNumber;

    @Column(name = "inside_number")
    @Convert(converter = AttributeEncryptor.class)
    private String insideNumber;

    @Column(name = "reference")
    @Convert(converter = AttributeEncryptor.class)
    private String reference;

    @Column(name = "lat")
    @Convert(converter = AttributeEncryptor.class)
    private String lat;

    @Column(name = "lon")
    @Convert(converter = AttributeEncryptor.class)
    private String lon;

    @Column(name = "active")
    private boolean active;

    /* Getters and Setters */
	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public Colony getColony() {
		return colony;
	}

	public void setColony(Colony colony) {
		this.colony = colony;
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	/* toString */
	@Override
	public String toString() {
		return "ClinicalEntityAddress [id=" + id + ", clinicalEntity=" + clinicalEntity.getId() + ", colony="
				+ colony.getId() + ", street=" + street + ", btwStreet=" + btwStreet + ", outsideNumber="
				+ outsideNumber + ", insideNumber=" + insideNumber + ", reference=" + reference + ", lat=" + lat
				+ ", lon=" + lon + ", active=" + active + "]";
	}

}