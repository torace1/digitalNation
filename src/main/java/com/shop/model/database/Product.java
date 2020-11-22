package com.shop.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer id;
	
	private String denumireProdus;
	
	private String pret;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDenumireProdus() {
		return denumireProdus;
	}

	public void setDenumireProdus(String denumireProdus) {
		this.denumireProdus = denumireProdus;
	}

	public String getPret() {
		return pret;
	}

	public void setPret(String pret) {
		this.pret = pret;
	}
	
	
	
	

}
