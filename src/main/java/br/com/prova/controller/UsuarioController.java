package br.com.prova.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prova.entity.Usuario;
import br.com.prova.response.Response;
import br.com.prova.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping
	public ResponseEntity<Response<Usuario>> salvar(HttpServletRequest request, @RequestBody Usuario usuario,
			BindingResult result) {
		Response<Usuario> response = new Response<Usuario>();
		response.setData(this.service.inserir(usuario));
		System.out.println("Salvo com sucesso!");
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "{page}/{count}")
	public ResponseEntity<Response<Page<Usuario>>> listarTodos(@PathVariable int page, @PathVariable int count){
		Response<Page<Usuario>> response = new Response<Page<Usuario>>();
		Page<Usuario> usuarios = this.service.listar(page, count);
		response.setData(usuarios);
		return ResponseEntity.ok(response);
	}
}
