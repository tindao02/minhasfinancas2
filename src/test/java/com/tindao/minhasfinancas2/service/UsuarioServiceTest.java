package com.tindao.minhasfinancas2.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tindao.minhasfinancas2.exception.RegraNegocioException;
import com.tindao.minhasfinancas2.model.repository.UsuarioRepository;
import com.tindao.minhasfinancas2.service.impl.UsuarioServiceImpl;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UsuarioServiceTest 
{
	private UsuarioService service;
	
	@MockBean
	private UsuarioRepository repository;
	
	@Before
	public void setUp()
	{
		service = new UsuarioServiceImpl(repository);
	}
	
	@Test(expected = Test.None.class)
	public void deveValidarEmail()
	{
		//cenário
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);

		//ação
		service.validarEmail("email@email.com");
	}
	
	@Test(expected = RegraNegocioException.class)
	public void deveLancarErroAoValidarQuandoExistirEmailCadastrado()
	{
		//cenário
		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);
		
		//execução
		service.validarEmail("test@gmail.com");
	}
	
}
