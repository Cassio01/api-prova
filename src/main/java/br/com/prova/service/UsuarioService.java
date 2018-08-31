package br.com.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.prova.entity.Usuario;
import br.com.prova.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario inserir(Usuario usuario) {
		return this.repository.save(usuario);
	}
	
	public Page<Usuario> listar(int page, int count){
		Pageable paginas = PageRequest.of(page, count);
		return this.repository.findAll(paginas);
	}
}
