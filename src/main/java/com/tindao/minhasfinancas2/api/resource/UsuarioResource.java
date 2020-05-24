package com.tindao.minhasfinancas2.api.resource;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tindao.minhasfinancas2.api.dto.UsuarioDTO;
import com.tindao.minhasfinancas2.exception.ErroAutenticacao;
import com.tindao.minhasfinancas2.exception.RegraNegocioException;
import com.tindao.minhasfinancas2.model.entity.Usuario;
import com.tindao.minhasfinancas2.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioResource 
{
	private final UsuarioService service;
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar( @RequestBody UsuarioDTO dto)
	{
		try
		{
			Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
			return ResponseEntity.ok(usuarioAutenticado);
		}
		catch(ErroAutenticacao e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity salvar( @RequestBody UsuarioDTO dto)
	{
		Usuario usuario = Usuario
						.builder()
						.nome(dto.getNome())
						.email(dto.getEmail())
						.senha(dto.getSenha())
						.data(LocalDate.now())
						.build();
		
		try
		{
			Usuario usuarioSalvo = service.salvar(usuario);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		}
		catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
