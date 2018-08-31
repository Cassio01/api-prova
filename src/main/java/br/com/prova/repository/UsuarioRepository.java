package br.com.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prova.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
