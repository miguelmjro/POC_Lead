package com.iheartmeadia.POC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iheartmeadia.POC.model.Actual;
import com.iheartmeadia.POC.respositories.ActualRepository;

@RestController
public class ActualController {
	@Autowired
	ActualRepository actualRepository;
	
	@RequestMapping(value = "/getActuals", method = RequestMethod.GET)
    public ResponseEntity<String> actualExample() {
    	String json = "[{\"Id\":\"a1z440000006mKzAAI\",\"Gross_Amount_Fulfilled\":11360,\"Total_Gross_Fulfilled_Scheduled\":40896},{\"Id\":\"a1z440000006mLdAAI\",\"Gross_Amount_Fulfilled\":944.5,\"Total_Gross_Fulfilled_Scheduled\":1183.25},{\"Id\":\"a1z440000006mLiAAI\",\"Gross_Amount_Fulfilled\":4655,\"Total_Gross_Fulfilled_Scheduled\":4980},{\"Id\":\"a1z44000001mff5AAA\",\"Gross_Amount_Fulfilled\":40335,\"Total_Gross_Fulfilled_Scheduled\":47390},{\"Id\":\"a1z44000001mfghAAA\",\"Gross_Amount_Fulfilled\":32080,\"Total_Gross_Fulfilled_Scheduled\":39855},{\"Id\":\"a1z44000001mfgSAAQ\",\"Gross_Amount_Fulfilled\":32120,\"Total_Gross_Fulfilled_Scheduled\":39200},{\"Id\":\"a1z44000001mfhQAAQ\",\"Gross_Amount_Fulfilled\":15980,\"Total_Gross_Fulfilled_Scheduled\":19139},{\"Id\":\"a1z44000001mfixAAA\",\"Gross_Amount_Fulfilled\":25017,\"Total_Gross_Fulfilled_Scheduled\":30286},{\"Id\":\"a1z44000001mfjWAAQ\",\"Gross_Amount_Fulfilled\":51300,\"Total_Gross_Fulfilled_Scheduled\":62100},{\"Id\":\"a1z44000001mfkKAAQ\",\"Gross_Amount_Fulfilled\":12780,\"Total_Gross_Fulfilled_Scheduled\":15100},{\"Id\":\"a1z44000001mfl8AAA\",\"Gross_Amount_Fulfilled\":29330,\"Total_Gross_Fulfilled_Scheduled\":32050}]";
        return new ResponseEntity<String>(json,HttpStatus.OK);
    }
	
	@RequestMapping(value = "/getActualsNoMatched", method = RequestMethod.GET)
    public ResponseEntity<List<Actual>> noMatched() {
		List<Actual> lstActual = actualRepository.findByNoMatched();
        return new ResponseEntity<List<Actual>>(lstActual,HttpStatus.OK);
    }
}
