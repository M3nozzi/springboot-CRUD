package com.menozzi.wkmongo.dto;

import java.io.Serializable;

import com.menozzi.wkmongo.domain.Client;

public class ClientDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String cpf;
	
	public ClientDTO() {
		
	}

	public ClientDTO(Client obj) {
		id = obj.getId();
		name = obj.getName();
		cpf = obj.getCpf();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
