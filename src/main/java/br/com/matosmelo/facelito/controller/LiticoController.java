package br.com.matosmelo.facelito.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.matosmelo.facelitico.dao.LiticoDao;
import br.com.matosmelo.facelitico.model.Litico;

@Resource
public class LiticoController {
	private final LiticoDao dao;
	private final Result result;
	private final Validator validator;

	// Construtor
	public LiticoController(LiticoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	// Index
	@Get("liticos")
	public void index() {
	}

	// Lista os liticos
	@Get("/liticos/lista")
	public List<Litico> lista() {
		return dao.listaTudo();
	}

	// Mostra o formulario
	@Get("/liticos/novo")
	public void formulario() {
	}

	// Adiciona litico
	@Post("/liticos")
	public void adiciona(final Litico litico) {
		// if (litico.getNome() == null) {
		// validator.add(new ValidationMessage("O nome não pode ser nulo",
		// "nome.descricao"));
		// }
		//
		// if (litico.getPartido() == null) {
		// validator.add(new ValidationMessage("O partido não pode ser nulo",
		// "partido.descricao"));
		// }
		//
		// validator.onErrorUsePageOf(LiticoController.class).formulario();

		validator.validate(litico);
		validator.onErrorUsePageOf(LiticoController.class).formulario();
		dao.salva(litico);
		// Retorna para lista apos adicao
		result.redirectTo(this).lista();
	}

	// Edita litico
	@Get("/liticos/{id}")
	public Litico edita(Long id) {
		return dao.carrega(id);

	}

	// Altera litico
	@Put("/liticos/{litico.id}")
	public void altera(Litico litico) {
		validator.validate(litico);
		validator.onErrorUsePageOf(LiticoController.class)
				.edita(litico.getId());

		dao.atualiza(litico);
		result.redirectTo(this).lista();
	}

	// Remove litico
	@Delete("/liticos/{id}")
	public void remove(Long id) {
		Litico litico = dao.carrega(id);
		dao.remove(litico);
		result.redirectTo(this).lista();
	}
	
	@Get("/liticos/pesquisa")
	public void pesquisa() {
	}
	
	@Get
	@Path("/liticos/busca")
	public List<Litico> busca(String nome){
		System.out.println(nome);
		return dao.busca(nome);
			
	}
}
