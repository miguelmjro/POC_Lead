package com.iheartmeadia.POC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Actual")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Actual {
	@Id
	@SequenceGenerator(name = "actualSeq", sequenceName = "actuals_id_seq", allocationSize = 1)  
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actualSeq")
    @Column(name = "actualId", unique = true, nullable = false)
    private Long actualId;
	
	@Column(name ="Id", nullable = true)
	private String id;
	
	@Column(name ="Total_Gross_Fulfilled_Scheduled", nullable = true)
	//@Type(type="double precision")
	private double total_Gross_Fulfilled_Scheduled;
	
	@Column(name ="Gross_Amount_Fulfilled", nullable = true)
	//@Type(type="double precision")
	private double gross_amount_fulfilled;

	@Column(name ="mactched", nullable = true)
	private boolean mactched = false;
	
	public Long getActualId() {
		return actualId;
	}

	public void setActualId(Long actualId) {
		this.actualId = actualId;
	}

	public String getId() {
		return id;
	}

	@JsonProperty("Id")
	public void setId(String id) {
		this.id = id;
	}

	public double getTotal_Gross_Fulfilled_Scheduled() {
		return total_Gross_Fulfilled_Scheduled;
	}

	@JsonProperty("Total_Gross_Fulfilled_Scheduled")
	public void setTotal_Gross_Fulfilled_Scheduled(double total_Gross_Fulfilled_Scheduled) {
		this.total_Gross_Fulfilled_Scheduled = total_Gross_Fulfilled_Scheduled;
	}

	public double getGross_amount_fulfilled() {
		return gross_amount_fulfilled;
	}

	@JsonProperty("Gross_Amount_Fulfilled")
	public void setGross_amount_fulfilled(double gross_amount_fulfilled) {
		this.gross_amount_fulfilled = gross_amount_fulfilled;
	}

	public boolean isMactched() {
		return mactched;
	}
	
	@JsonProperty("Mactched")
	public void setMactched(boolean mactched) {
		this.mactched = mactched;
	}
    @Override
    public String toString() {
        return "Actual{" +
                "actualId=" + actualId +
                ", id=" + id +
                ", total_Gross_Fulfilled_Scheduled='" + total_Gross_Fulfilled_Scheduled +
                ", gross_amount_fulfilled=" + gross_amount_fulfilled +
                ", mactched=" + mactched +
                '}';
    }

}
