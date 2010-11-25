package br.com.unifor.tcc.lojavirtal.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.unifor.tcc.lojavirtal.model.EstoqueDeProdutos;
import br.com.unifor.tcc.lojavirtal.model.Produto;

import com.google.appengine.api.users.UserService;

@Resource
public class AdminController {

	private final EstoqueDeProdutos estoque;

	private final Result result;


	private final UserService userService;

	public AdminController(EstoqueDeProdutos estoque, Result result,
			UserService userService) {
		this.estoque = estoque;
		this.result = result;
		this.userService = userService;
	}

	@Get
	@Path("/admin")
	public void index() {
		result.include("produtos", estoque.todos())
				.include("user", userService.getCurrentUser())
				.include("logoutUrl", userService.createLogoutURL("/admin"));
	}

	@Get
	@Path("/admin/produto/adiciona")
	public void adicionarProduto() {
		result.include("user", userService.getCurrentUser())
		.include("logoutUrl", userService.createLogoutURL("/admin"));
	}

	@Post
	@Path("/admin/produto/adiciona")
	public void adicionarProduto(final Produto produto) {
		estoque.adicionarEditar(produto);

		result.include("aviso", produto.getNome() + " adicionado com sucesso!")
				.use(Results.logic()).redirectTo(getClass()).index();
	}

	@Get
	@Path("/admin/produto/exclui")
	public void deletarProduto(Long codigo) {
		estoque.deletar(codigo);

		result.include("aviso", "Produto deletado com sucesso!")
				.use(Results.logic()).redirectTo(getClass()).index();
	}

	@Get
	@Path("/admin/produto/edita")
	public Produto editarProduto(Long codigo){
		
		result.include("user", userService.getCurrentUser())
		.include("logoutUrl", userService.createLogoutURL("/admin"));
		
		return estoque.obter(codigo);
	}
	
	@Post
	@Path("/admin/produto/edita")
	public void editarProduto(Produto produto){
		estoque.adicionarEditar(produto);
		
		result.include("aviso",produto.getNome() + " alterado com sucesso!")
		.use(Results.logic()).redirectTo(getClass()).index();
	}
	
}
