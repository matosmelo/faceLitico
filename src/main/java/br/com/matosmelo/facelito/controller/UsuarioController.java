package br.com.matosmelo.facelito.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.matosmelo.facelitico.dao.UsuarioDao;
import br.com.matosmelo.facelitico.model.Usuario;

@Resource
public class UsuarioController {
	private final UsuarioDao dao;
	private final Result result;
	private final Validator validator;

	// Construtor
	public UsuarioController(UsuarioDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	// Usuarios
	@Get("usuarios")
	public List<Usuario> usuarios() {
		return dao.listaTudo();
	}

	// Mostra o formulario usuario
	@Get("/usuario/novo")
	public void formulario() {
	}

	// Adiciona usuario
	@Post("/usuario/novo")
	public void adiciona(final Usuario usuario) {
		validator.validate(usuario);
		validator.onErrorUsePageOf(UsuarioController.class).formulario();
		dao.salva(usuario);
		// Retorna para lista apos adicao
		result.redirectTo(this).usuarios();
	}
//
//	// Edita litico
//	@Get("/liticos/{id}")
//	public Litico edita(Long id) {
//		return dao.carrega(id);
//
//	}
//
//	// Altera litico
//	@Put("/liticos/{litico.id}")
//	public void altera(Litico litico) {
//		validator.validate(litico);
//		validator.onErrorUsePageOf(UsuarioController.class)
//				.edita(litico.getId());
//
//		dao.atualiza(litico);
//		result.redirectTo(this).lista();
//	}
//
//	// Remove litico
//	@Delete("/liticos/{id}")
//	public void remove(Long id) {
//		Litico litico = dao.carrega(id);
//		dao.remove(litico);
//		result.redirectTo(this).lista();
//	}
//
	@Get("/usuario/pesquisa")
	public void pesquisa() {
	}

	@Get
	@Path("/usuario/busca")
	public List<Usuario> busca(String nome) {
		return dao.busca(nome);

	}
}
