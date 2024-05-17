package com.tcespring.prova.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tcespring.prova.entites.Lojista;
import com.tcespring.prova.entites.UsuarioComum;
import com.tcespring.prova.repository.LojistaRepository;
import com.tcespring.prova.repository.UsuarioComumRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Autowired
	private LojistaRepository lojistaRepository;

	@Autowired
	private UsuarioComumRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Lojista lojista = new Lojista("Maria", 11111111111L, "maria@gmail.com", "123", 40.0);
		UsuarioComum userComum = new UsuarioComum("Carlos", 21111111112L, "carlos@gmail.com", "321", 50.0);
		
		lojistaRepository.save(lojista);
		userRepository.save(userComum);
	}
}
