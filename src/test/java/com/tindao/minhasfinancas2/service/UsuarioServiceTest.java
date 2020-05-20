package com.tindao.minhasfinancas2.service;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tindao.minhasfinancas2.exception.RegraNegocioException;
import com.tindao.minhasfinancas2.model.entity.Usuario;
import com.tindao.minhasfinancas2.model.repository.UsuarioRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioServiceTest 
{
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test(expected = Test.None.class)
	public void deveValidarEmail()
	{
		//cenário
		usuarioRepository.deleteAll();
		
		//ação
		usuarioService.validarEmail("email@email.com");
		
	}
	
	@Test(expected = RegraNegocioException.class)
	public void deveLancarErroAoValidarQuandoExistirEmailCadastrado()
	{
		//cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("test@gmail.com").senha("123456").data(LocalDate.of(2020, 10, 05)).build();
		usuarioRepository.save(usuario);
		
		//ação
		usuarioService.validarEmail("test@gmail.com");
		
	}
	
}
