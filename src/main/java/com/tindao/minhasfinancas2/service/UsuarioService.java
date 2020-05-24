package com.tindao.minhasfinancas2.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.tindao.minhasfinancas2.model.entity.Usuario;

public interface UsuarioService 
{
	Usuario autenticar(String email, String senha);
	
	Usuario salvar(Usuario usuario);
	
	void validarEmail(String email);
	
	Optional<Usuario> obterPorId(Long id);
	
	
}

