package com.tindao.minhasfinancas2.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tindao.minhasfinancas2.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{

}
