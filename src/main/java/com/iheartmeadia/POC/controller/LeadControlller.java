package com.iheartmeadia.POC.controller;

import java.util.ArrayList;
import java.util.List;

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
    	Lead lead = createSampleLead(0L,"");
        return new ResponseEntity<Lead>(lead,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/ListStructure", method = RequestMethod.GET)
    public ResponseEntity<List<Lead>> leadListModel() {
    	List<Lead> lstLead = new ArrayList<Lead>();
    	for(long id=0;id<5;id++) {
    		Lead lead = createSampleLead(id,""+id);
    		lstLead.add(lead);
    	}
        return new ResponseEntity<List<Lead>>(lstLead,HttpStatus.OK);
    }
    @RequestMapping(value = "/lead", method = RequestMethod.POST)
    public ResponseEntity<Lead> saveLead(@RequestBody Lead lead) {
    	leadRepository.save(lead);
        return new ResponseEntity<Lead>(lead,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/leads", method = RequestMethod.POST)
    public ResponseEntity<List<Lead>> saveLeads(@RequestBody List<Lead> leads) {
    	leadRepository.save(leads);
        return new ResponseEntity<List<Lead>>(leads,HttpStatus.OK);
    }
    
    private Lead createSampleLead(String sufix) {
    	Lead lead = new Lead();
    	lead.setId(null);
    	String text="Text"+sufix;
    	lead.setStatus(text);
    	lead.setLastname(text);
    	lead.setFirstname(text);
    	lead.setDse__demo_id__c(text);
    	lead.setState("TX");
    	lead.setCity("San Antonio");
    	lead.setCompany(text);
    	lead.setLeadsource(text);
    	lead.setStreet(text);
    	lead.setPostalcode(text);
    	lead.setPhone(text);
    	return lead;
    }
}
