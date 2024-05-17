package com.tcespring.prova.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcespring.prova.entites.Lojista;
import com.tcespring.prova.entites.Usuario;
import com.tcespring.prova.entites.UsuarioComum;
import com.tcespring.prova.repository.LojistaRepository;
import com.tcespring.prova.repository.UsuarioComumRepository;

@Service
public class ValidationServices {

	@Autowired
	private UsuarioComumRepository uCRepository;

	@Autowired
	private LojistaRepository lRepository;
	
	public boolean findByCpf(Long cpf) {
			Optional<UsuarioComum> usuarioComum = uCRepository.findById(cpf);
			if(usuarioComum.isPresent()) {
				return true;
			} else {
				Optional<Lojista> lojista = lRepository.findById(cpf);
				if(lojista.isPresent()) {
					return true;
				}
				return false;
			}
	}
	
}
