package com.tcespring.prova.entites;

import jakarta.persistence.Entity;

@Entity
public class Lojista extends Usuario{
	private static final long serialVersionUID = 1L;

	public Lojista() {
		
	}

	public Lojista(String nome, Long numero_documento, String email, String password, Double saldo) {
		super(nome, numero_documento, email, password, saldo);
	}
	
}
