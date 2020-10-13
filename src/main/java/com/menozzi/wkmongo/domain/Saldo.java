package com.menozzi.wkmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.menozzi.wkmongo.dto.OwnerDTO;
import com.menozzi.wkmongo.dto.TransferDTO;


@Document
public class Saldo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date date;
	private Double value;
	private OwnerDTO owner;
	
	
	private List<TransferDTO> transfers = new ArrayList<>();
	
	public Saldo(){
		
	}

	public Saldo(String id, Date date, Double value, OwnerDTO owner) {
		super();
		this.id = id;
		this.date = date;
		this.value = value;
		this.owner = owner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public OwnerDTO getOwner() {
		return owner;
	}

	public void setOwner(OwnerDTO owner) {
		this.owner = owner;
	}

	
	public List<TransferDTO> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<TransferDTO> transfers) {
		this.transfers = transfers;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saldo other = (Saldo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
