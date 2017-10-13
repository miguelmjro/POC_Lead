package com.iheartmeadia.POC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Contact entity.
 */
@Entity
@Table(name = "opportunity", schema = "salesforce")

public class Opportunity {
	@Id
	@SequenceGenerator(name = "oppSequence", sequenceName = "opp_id_seq", allocationSize = 1)  
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oppSequence")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
	
	@Column(name ="type", nullable = true)
	private String type;
	
	@Column(name ="name", nullable = true)
	private String name;
	
	@Column(name ="closedate", nullable = true)
	private String closedate;
	
	@Column(name ="agency_or_direct__c", nullable = true)
	private String agency_or_direct__c;
	
	@Column(name ="population_type__c", nullable = true)
	private String population_type__c;
	
	@Column(name ="accountid", nullable = true)
	private String accountid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClosedate() {
		return closedate;
	}

	public void setClosedate(String closedate) {
		this.closedate = closedate;
	}

	public String getAgency_or_direct__c() {
		return agency_or_direct__c;
	}

	public void setAgency_or_direct__c(String agency_or_direct__c) {
		this.agency_or_direct__c = agency_or_direct__c;
	}

	public String getPopulation_type__c() {
		return population_type__c;
	}

	public void setPopulation_type__c(String population_type__c) {
		this.population_type__c = population_type__c;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
		
}
