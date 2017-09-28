package com.iheartmeadia.POC.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Contact entity.
 */
@Entity
@Table(name = "lead", schema = "salesforce")

public class Lead {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
	@Column(name ="status", nullable = false)
	String status;

	@Column(name = "lastname", nullable = false)
	String lastname;

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "firstname", nullable = false)
	String firstname;

	@Column(name = "dse__demo_id__c", nullable = false)
	String dse__demo_id__c;

	@Column(name = "state", nullable = false)
	String state;

	@Column(name = "country", nullable = false)
	String country;

	@Column(name = "city", nullable = false)
	String city;

	@Column(name = "company", nullable = false)
	String company;

	@Column(name = "leadsource", nullable = false)
	String leadsource;

	@Column(name = "street", nullable = false)
	String street;

	@Column(name = "postalcode", nullable = false)
	String postalcode;

	@Column(name = "phone", nullable = false)
	String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
    
    
    
}
