package com.iheartmeadia.POC.respositories;

import org.springframework.data.repository.CrudRepository;

import com.iheartmeadia.POC.model.Lead;

public interface LeadRepository extends CrudRepository<Lead, Integer> {

}
