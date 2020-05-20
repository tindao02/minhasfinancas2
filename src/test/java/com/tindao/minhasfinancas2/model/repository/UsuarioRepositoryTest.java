package com.tindao.minhasfinancas2.model.repository;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tindao.minhasfinancas2.model.entity.Usuario;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioRepositoryTest 
{
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail()
	{
		//Cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("test@gmail.com").senha("123456").data(LocalDate.of(2020, 10, 05)).build();
		usuarioRepository.save(usuario);
		
		//Reação/execução
		boolean result = usuarioRepository.existsByEmail("test@gmail.com");
		
		//Verificação
		Assertions.assertThat(result).isTrue();
		
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail()
	{
		//Canário
		usuarioRepository.deleteAll();
		
		//Reação/execução
		boolean result = usuarioRepository.existsByEmail("test@test.com");
		
		//verificação
		Assertions.assertThat(result).isFalse();
	}
	
}
