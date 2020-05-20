package com.tindao.minhasfinancas2.model.repository;

import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tindao.minhasfinancas2.model.entity.Usuario;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest 
{
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	TestEntityManager entityMagager;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail()
	{
		//Cenário
		Usuario usuario = criarUsuario();
		entityMagager.persist(usuario);
		
		//Reação/execução
		boolean result = repository.existsByEmail("test@test.com");
		
		//Verificação
		Assertions.assertThat(result).isTrue();
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail()
	{
		//Reação/execução
		boolean result = repository.existsByEmail("test@test.com");
		
		//verificação
		Assertions.assertThat(result).isFalse();
	}
	
	@Test
	public void devePersistirUmUsuarioNaBaseDeDados()
	{
		//cenário
		Usuario usuario = criarUsuario();
		
		//execução
		Usuario usuarioSalvo = repository.save(usuario);
		
		//verificação
		Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
	}
	
	@Test
	public void deveBuscarUmUsuarioPorEmail()
	{
		//cenário
		Usuario usuario = criarUsuario();
		entityMagager.persist(usuario);
		
		//verificação
		Optional<Usuario> result = repository.findByEmail("test@test.com");
		Assertions.assertThat(result.isPresent()).isTrue();
	}
	
	@Test
	public void deveRetornarVazioAoBuscarUsuarioPorEmailQuandoNaoExisteNaBase()
	{		
		//verificação
		Optional<Usuario> result = repository.findByEmail("test@test.com");
		Assertions.assertThat(result.isPresent()).isFalse();
	}
	
	public static Usuario criarUsuario()
	{
		return  Usuario
				.builder()
				.nome("usuario")
				.email("test@test.com")
				.senha("123456")
				.data(LocalDate.of(2020, 10, 05))
				.build();
	}
	
}
