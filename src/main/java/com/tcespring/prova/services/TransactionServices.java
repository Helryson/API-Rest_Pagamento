package com.tcespring.prova.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcespring.prova.entites.Lojista;
import com.tcespring.prova.entites.Usuario;
import com.tcespring.prova.entites.UsuarioComum;
import com.tcespring.prova.exception.TransactionException;
import com.tcespring.prova.exception.ValidationException;
import com.tcespring.prova.repository.LojistaRepository;
import com.tcespring.prova.repository.UsuarioComumRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionServices {
	
	
	
	@Autowired
	private ValidationServices validationService;
	
	@Autowired
	private LojistaRepository lojistaRepo;
	
	@Autowired
	private UsuarioComumRepository usuarioComumRepo;
	
	
	
	@Transactional
	public Usuario fazTransacao(Double quantia, String CpfPagador, String CpfRecebedor) throws TransactionException, ValidationException {
		
		Long CpfPagador1 = Long.valueOf(CpfPagador);
		Long CpfRecebedor1 = Long.valueOf(CpfRecebedor);
		
		if(validationService.findByCpf(CpfPagador1) && validationService.findByCpf(CpfRecebedor1)) {
		
			if(instanciaUsuario(CpfPagador1) instanceof Lojista) {
				throw new TransactionException("Lojistas não podem fazer trasnsações");
			}
			if(verificaSaldo(quantia, instanciaUsuario(CpfPagador1))) {
				
				UsuarioComum remetente = (UsuarioComum) instanciaUsuario(CpfPagador1);
				remetente.fazTransaction(quantia);
				
				if(instanciaUsuario(CpfRecebedor1) instanceof Lojista) {
					Lojista destinatario = (Lojista) instanciaUsuario(CpfRecebedor1);
					destinatario.recebeTransaction(quantia);
					
					lojistaRepo.save(destinatario);
					usuarioComumRepo.save(remetente);
					
					return destinatario;
				}
				else {
					UsuarioComum destinatario = (UsuarioComum) instanciaUsuario(CpfRecebedor1);
					
					usuarioComumRepo.save(destinatario);
					usuarioComumRepo.save(remetente);
					
					return destinatario;
				}
			}
			else {
				throw new TransactionException("Saldo insuficiente para transferência");
			}
		}
		throw new ValidationException("Transação não pôde ser efetuada com êxito pois usuário não existe");
	}

	public boolean verificaSaldo(Double quantia, Usuario user) {
		if(quantia > user.getSaldo()) {
			return false;
		}
		return true;
	}
	
	public Usuario instanciaUsuario(Long cpf) {
		Optional<UsuarioComum> usuarioComum = usuarioComumRepo.findById(cpf);
		if(usuarioComum.isPresent()) {
			return usuarioComum.get();
		} else {
			Optional<Lojista> lojista = lojistaRepo.findById(cpf);
			if(lojista.isPresent()) {
				return lojista.get();
			}
			return null;
		}
	}
}
