package com.tindao.minhasfinancas2.api.dto;

import javax.validation.constraints.Email;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDTO 
{
	private String email;
	private String nome;
	private String senha;
}
