package com.iheartmeadia.POC.respositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iheartmeadia.POC.model.Opportunity;
@Transactional
@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
	@Query("SELECT op FROM Opportunity op where op.synced_proposal__c IN :ids")
	List<Opportunity> findBySynced_proposal__cIn(@Param("ids")Set<String> proposals);	
}
