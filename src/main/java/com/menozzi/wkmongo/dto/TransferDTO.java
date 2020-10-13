package com.menozzi.wkmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class TransferDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double value;
	private Date date;
	private OwnerDTO owner;

	public TransferDTO() {
		
	}

	public TransferDTO(Double value, Date date, OwnerDTO owner) {
		super();
		this.value = value;
		this.date = date;
		this.owner = owner;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OwnerDTO getOwner() {
		return owner;
	}

	public void setOwner(OwnerDTO owner) {
		this.owner = owner;
	}
	
	
	
}
