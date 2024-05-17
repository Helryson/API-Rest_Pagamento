package com.tcespring.prova.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcespring.prova.entites.Email;
import com.tcespring.prova.entites.Usuario;
import com.tcespring.prova.exception.TransactionException;
import com.tcespring.prova.exception.ValidationException;
import com.tcespring.prova.services.EmailService;
import com.tcespring.prova.services.TransactionServices;

@RestController
@RequestMapping
public class TransactionResources {
	
	private boolean transacaoConcluida = false;
	private Usuario beneficiario;
	
	@Autowired
	private TransactionServices transactionServices;
	
	@Autowired 
	private EmailService emailService;
	
	@PostMapping(value = "/transaction")
	public void transactionConcluida(@RequestParam Double quantia, @RequestParam String CpfPagador, @RequestParam String CpfRecebedor){
		
		try {
			beneficiario = transactionServices.fazTransacao(quantia, CpfPagador, CpfRecebedor);
			transacaoConcluida = true;
		} catch(ValidationException e) {
			e.getMessage();
		} catch(TransactionException e) {
			e.getMessage();
		}
	}
	
	 @PostMapping(value = "/envio")
	    public ResponseEntity<Email> enviaEmail() {
		 	if(transacaoConcluida) {
		 		emailService.enviaEmail(beneficiario.getEmail(), "Transação concluída com sucesso");
		 		return ResponseEntity.ok().body(emailService.enviaEmail(beneficiario.getEmail(), "Transação concluída com sucesso"));
		 	}
		 	return null;
	    }
	
}
