package com.iheartmeadia.POC.respositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.iheartmeadia.POC.model.Actual;
import com.iheartmeadia.POC.model.Opportunity;

@Component 
public interface ActualRepository extends CrudRepository< Actual, Integer>{
	@Query("SELECT op FROM Opportunity op where op.synced_proposal__c IN :ids")
	List<Actual> findByNoMatched(@Param("ids")Set<String> proposals);	

}
