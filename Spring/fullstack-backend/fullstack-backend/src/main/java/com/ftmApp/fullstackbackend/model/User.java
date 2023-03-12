package com.ftmApp.fullstackbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity   //will automatically create the table User when we connect Spring to MySQL database
public class User {
	
	@Id
	@GeneratedValue //to create the id automatically
	private Long productId;
	private String productName;
	private int productCost;
	private int nBreaks;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	public int getnBreaks() {
		return nBreaks;
	}
	public void setnBreaks(int nBreaks) {
		this.nBreaks = nBreaks;
	}
	
	
}
