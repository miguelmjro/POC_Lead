package com.iheartmedia.POC;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iheartmeadia.POC.model.Actual;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.iheartmeadia.POC.*"})
@EnableAutoConfiguration
@EntityScan(basePackages={"com.iheartmeadia.POC.model"})
public class OneOffProcess{
	private static final Logger log = LoggerFactory.getLogger(OneOffProcess.class);
    public static void main(String[] args){
    	ObjectMapper obj = new ObjectMapper();
    	
    	RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8080/getActuals", String.class);
        log.info(response);
        if(response!=null&&!response.isEmpty()) {
        	try {
        		List<Actual> quote = obj.readValue(response, new TypeReference<List<Actual>>() {});
				log.info(quote.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }    
}
