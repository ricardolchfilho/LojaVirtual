package br.com.unifor.tcc.lojavirtal.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.unifor.tcc.lojavirtal.model.EstoqueDeProdutos;
import br.com.unifor.tcc.lojavirtal.model.Produto;
import br.com.unifor.tcc.lojavirtal.model.TodasCategorias;

import com.google.appengine.api.users.UserService;

@Resource
public class AdminController {

	private final EstoqueDeProdutos estoque;

	private final Result result;

	private final TodasCategorias categorias;

	private final UserService userService;

	public AdminController(EstoqueDeProdutos estoque, Result result,
			TodasCategorias categorias, UserService userService) {
		this.estoque = estoque;
		this.result = result;
		this.categorias = categorias;
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
		result.include("categorias", categorias.listar());
	}

	@Post
	@Path("/admin/produto/adiciona")
	public void adicionarProduto(final Produto produto) {
		estoque.adicionar(produto);

		result.include("aviso", produto.getNome() + " adicionado com sucesso!")
				.use(Results.logic()).redirectTo(getClass()).index();
	}

	@Get
	@Path("/admin/produto/excluir")
	public void deletarProduto(Long codigo) {
		estoque.deletar(codigo);

		result.include("aviso", "Produto deletado com sucesso!")
				.use(Results.logic()).redirectTo(getClass()).index();
	}

	@Get
	@Path("/admin/produto/editar")
	public void editarProduto(Long codigo){
		Produto produto = estoque.obter(codigo);
		result.include("produto", produto);
	
	}
}
