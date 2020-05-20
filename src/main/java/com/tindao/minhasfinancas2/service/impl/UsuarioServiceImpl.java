package com.tindao.minhasfinancas2.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindao.minhasfinancas2.exception.ErroAutenticacao;
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
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		
		if(!usuario.isPresent())
		{
			throw new ErroAutenticacao("Email não encontrado.");
		}
		
		if(usuario.get().getSenha().equals(senha))
		{
			throw new ErroAutenticacao("Senha incorreta.");
		}
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvar(Usuario usuario) 
	{
		validarEmail(usuario.getEmail());
		return usuarioRepository.save(usuario);
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
