package com.tcespring.prova.entites;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Email implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String emailAddressDestino;
	private String mensagem;
	
	public Email() {
		
	}
	
	public Email(String emailAddressDestino, String mensagem) {
		super();
		this.emailAddressDestino = emailAddressDestino;
		this.mensagem = mensagem;
	}
	
	public String getEmailAddressDestino() {
		return emailAddressDestino;
	}

	public void setEmailAddressDestino(String emailAddressDestino) {
		this.emailAddressDestino = emailAddressDestino;
	}

	public String getMsg() {
		return mensagem;
	}

	public void setMsg(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
