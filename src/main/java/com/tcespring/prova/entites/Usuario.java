package com.tcespring.prova.entites;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nome_completo")
	private String nome;
	@Id
	@Column(unique = true)
	private Long numero_documento;
	@Column(unique = true)
	private String email;
	private String password;
	protected Double saldo;
	
	public Usuario() {
		
	}

	public Usuario(String nome, Long numero_documento, String email, String password, Double saldo) {
		super();
		this.nome = nome;
		this.numero_documento = numero_documento;
		this.email = email;
		this.password = password;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(Long numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void recebeTransaction(Double quantia) {
		this.saldo += quantia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, nome, numero_documento, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& numero_documento == other.numero_documento && Objects.equals(password, other.password);
	}
}
