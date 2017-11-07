package com.iheartmedia.POC;

import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iheartmeadia.POC.Consumer.ActualConsumer;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.iheartmeadia.POC.*"})
@EnableAutoConfiguration
@EntityScan(basePackages={"com.iheartmeadia.POC"})
public class OneOffProcess{
	@Autowired
	ActualConsumer actualConsumer;
	private static final Logger log = LoggerFactory.getLogger(OneOffProcess.class);
    public static void main(String[] args) {
    	final ApplicationContext context =
                new ClassPathXmlApplicationContext("springDataConfig.xml");
    	OneOffProcess process = (OneOffProcess) context.getBean("OneOffProcess");
    	process.doJob();
    }
    
    public void doJob()  {
    	actualConsumer.consumeActuals();
    }
}
