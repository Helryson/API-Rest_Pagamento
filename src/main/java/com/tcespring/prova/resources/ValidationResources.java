package com.tcespring.prova.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcespring.prova.entites.Usuario;
import com.tcespring.prova.services.ValidationServices;

@RestController
@RequestMapping(value = "/validarUsuario")
public class ValidationResources {

	@Autowired
    private ValidationServices validationServices;
	
	@GetMapping(value = "/{cpf}")
    public boolean validaUsuario(@PathVariable String cpf) {
		Long cpfInt = Long.valueOf(cpf);
        boolean usuarioExiste = validationServices.findByCpf(cpfInt);
        return usuarioExiste;
    }
	
	
}
