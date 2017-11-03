package com.iheartmeadia.POC.respositories.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource( "classpath*:*springDataConfig.xml" )
public class PersistenceJPAConfig {

}
