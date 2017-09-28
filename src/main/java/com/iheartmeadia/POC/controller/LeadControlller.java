package com.iheartmeadia.POC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iheartmeadia.POC.model.Lead;
import com.iheartmeadia.POC.respositories.LeadRepository;


@RestController
public class LeadControlller {
	
	private LeadRepository leadRepository;
	
	@Autowired
    public void setContactService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }
	/**
     * Save Lead to database.
     *
     * @param Lead
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Lead> leadModel() {
    	Lead lead = new Lead();
    	lead.setId(0);
    	lead.setStatus("Text");
    	lead.setLastname("Text");
    	lead.setFirstname("Text");
    	lead.setDse__demo_id__c("Text");
    	lead.setState("Text");
    	lead.setCountry("Text");
    	lead.setCity("Text");
    	lead.setCompany("Text");
    	lead.setLeadsource("Text");
    	lead.setStreet("Text");
    	lead.setPostalcode("Text");
    	lead.setPhone("Text");
        return new ResponseEntity<Lead>(lead,HttpStatus.OK);
    }
    @RequestMapping(value = "/lead", method = RequestMethod.POST)
    public ResponseEntity<Lead> saveContact(@RequestBody Lead lead) {
    	leadRepository.save(lead);
        return new ResponseEntity<Lead>(lead,HttpStatus.OK);
    }
}
