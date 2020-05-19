package com.tindao.minhasfinancas2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tindao.minhasfinancas2.model.entity.Usuario;
import com.tindao.minhasfinancas2.model.repository.UsuarioRepository;
import com.tindao.minhasfinancas2.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService
{
	@Autowired
	private UsuarioRepository UsuarioRepository;

	@Override
	public Usuario autenticar(String email, String senha) 
	{
		return null;
	}

	@Override
	public Usuario salvar(Usuario usuario) 
	{
		return null;
	}

	@Override
	public void validarEmail(String email) 
	{
		
	}

}
