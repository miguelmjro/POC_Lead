package com.iheartmeadia.POC.respositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.iheartmeadia.POC.model.Lead;

@Component 
public interface LeadRepository extends CrudRepository< Lead, Integer> {

}
