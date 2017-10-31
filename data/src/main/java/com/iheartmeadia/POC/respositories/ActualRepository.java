package com.iheartmeadia.POC.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.iheartmeadia.POC.model.Actual;

@Component 
public interface ActualRepository extends CrudRepository< Actual, Integer>{

}
