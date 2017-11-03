package com.iheartmeadia.POC.Consumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iheartmeadia.POC.model.Actual;
import com.iheartmeadia.POC.model.Opportunity;
import com.iheartmeadia.POC.respositories.ActualRepository;
import com.iheartmeadia.POC.respositories.OpportunityRepository;

@Component
public class ActualConsumer {
	final int CHUNK_SIZE=150;

	@Autowired
	private OpportunityRepository opportunityRepository;
	@Autowired
	private ActualRepository actualRepository;
	
	@Autowired
	public void setOpportunityRepository(OpportunityRepository opportunityRepository) {
		this.opportunityRepository = opportunityRepository;
	}
	
	private static final Logger log = LoggerFactory.getLogger(ActualConsumer.class);
	public void consumeActuals() throws JsonParseException, JsonMappingException, IOException{
    	ObjectMapper obj = new ObjectMapper();

    	RestTemplate restTemplate = new RestTemplate();
    	//String response = restTemplate.getForObject("https://iheart-poc.herokuapp.com/getActuals", String.class);
        String response = restTemplate.getForObject("https://ra4egm67j2.execute-api.us-east-1.amazonaws.com/ci/viero/getActuals", String.class);
        log.info(response);
        if(response!=null&&!response.isEmpty()) {
    		List<Actual> lstActuals = obj.readValue(response, new TypeReference<List<Actual>>() {});
			log.info("lstActual size:"+lstActuals.size());
			for(int i=0;i<lstActuals.size();i+=CHUNK_SIZE) {
				// wrap the objects in a ServiceRequest
	        	int toIndex = i+CHUNK_SIZE;
	        	toIndex = toIndex>lstActuals.size()?lstActuals.size():toIndex; 
	        	List<Actual> subLstActuals = lstActuals.subList(i, toIndex);
	    		HashMap<String,Actual> mapActuals = new HashMap<String,Actual>();
	        	for(Actual objActual:subLstActuals)
	        		mapActuals.put(objActual.getId(), objActual);
			
			
				List<Opportunity> oppList = opportunityRepository.findBySynced_proposal__cIn(mapActuals.keySet());
				if(oppList==null) {
					log.info("listNull");
				}else {
					log.info("listSize:"+oppList.size());
					String stIds = "(";
					for(Opportunity objOpp : oppList) {
						if(mapActuals.containsKey(objOpp.getSynced_proposal__c())) {
							Actual objActual= mapActuals.get(objOpp.getSynced_proposal__c());
							objActual.setMatched(true);
							objOpp.setGross_amount_fulfilled__c(objActual.getGross_amount_fulfilled());
							objOpp.setGross_amount_fulfilled_scheduled__c(objActual.getTotal_Gross_Fulfilled_Scheduled());
							stIds += '\''+objActual.getId()+"',";
						}
					}
					log.info(stIds+")");
					opportunityRepository.save(oppList);
					actualRepository.save(mapActuals.values());
				}
			}
		}
    }
}
