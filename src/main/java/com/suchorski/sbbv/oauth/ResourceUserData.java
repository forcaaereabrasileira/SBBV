package com.suchorski.sbbv.oauth;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceUserData {
	
	private boolean valid;
	private String message;
	private String cpf;
	private String saram;
	private String nomeCompleto;
	private String nomeGuerra;
	private String patente;
	private String om;
	private String zimbra;
	private List<String> perfis;
	
	public ResourceUserData(String message) {
		this.valid = false;
		this.message = message;
	}
	
}
