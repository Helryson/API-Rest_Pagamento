package com.tcespring.prova.services;

import org.springframework.stereotype.Service;

import com.tcespring.prova.entites.Email;

@Service
public class EmailService {
	
	private Email email;
	
	public Email enviaEmail(String emailAddressDestino, String msg) {
		email = new Email(emailAddressDestino, msg);
		return email;
	}
	
}
