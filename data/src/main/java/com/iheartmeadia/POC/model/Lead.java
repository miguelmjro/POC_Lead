package com.iheartmeadia.POC.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Contact entity.
 */
@Entity
@Table(name = "lead", schema = "salesforce")
@Component 
public class Lead {
	@Id
	@SequenceGenerator(name = "lead_id_seq", sequenceName = "lead_id_seq", allocationSize = 1)  
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lead_id_seq")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
	@Column(name ="status", nullable = true)
	String status;

	@Column(name = "lastname", nullable = true)
	String lastname;

	@Column(name = "firstname", nullable = true)
	String firstname;
	
	@Column(name = "dse__demo_id__c", unique = true, nullable = false)
	String dse__demo_id__c;

	@Column(name = "country", nullable = true)
	String country;

	@Column(name = "state", nullable = true)
	String state;

	@Column(name = "city", nullable = true)
	String city;

	@Column(name = "company", nullable = true)
	String company;

	@Column(name = "leadsource", nullable = true)
	String leadsource;

	@Column(name = "street", nullable = true)
	String street;

	@Column(name = "postalcode", nullable = true)
	String postalcode;

	@Column(name = "phone", nullable = true)
	String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getDse__demo_id__c() {
		return dse__demo_id__c;
	}

	public void setDse__demo_id__c(String dse__demo_id__c) {
		this.dse__demo_id__c = dse__demo_id__c;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLeadsource() {
		return leadsource;
	}

	public void setLeadsource(String leadsource) {
		this.leadsource = leadsource;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    
}
