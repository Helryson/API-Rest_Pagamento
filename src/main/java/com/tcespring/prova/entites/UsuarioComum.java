package com.tcespring.prova.entites;

import jakarta.persistence.Entity;

@Entity
public class UsuarioComum extends Usuario{
	private static final long serialVersionUID = 1L;

	public UsuarioComum() {
		
	}

	public UsuarioComum(String nome, Long numero_documento, String email, String password, Double saldo) {
		super(nome, numero_documento, email, password, saldo);
	}
	
	public void fazTransaction(Double quantia) {
		this.saldo -= quantia;
	}
	
}
