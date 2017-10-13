package com.iheartmeadia.POC;

import java.io.IOException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iheartmeadia.POC.model.json.Quote;

public class OneOffProcess
{
	private static final Logger log = LoggerFactory.getLogger(OneOffProcess.class);
    public static void main(String[] args){
    	ObjectMapper obj = new ObjectMapper();
    	
    	RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
        log.info(response);
        if(response!=null&&!response.isEmpty()) {
        	try {
        		Quote quote = obj.readValue(response, Quote.class);
				log.info(quote.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }    
}
