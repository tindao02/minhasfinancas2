package com.tindao.minhasfinancas2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindao.minhasfinancas2.exception.RegraNegocioException;
import com.tindao.minhasfinancas2.model.entity.Usuario;
import com.tindao.minhasfinancas2.model.repository.UsuarioRepository;
import com.tindao.minhasfinancas2.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

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
		boolean existeEmail = usuarioRepository.existsByEmail(email);
		
		if(existeEmail)
		{
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
		}
		
	}

}
