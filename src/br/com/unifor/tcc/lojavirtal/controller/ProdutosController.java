package br.com.unifor.tcc.lojavirtal.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;
import br.com.unifor.tcc.lojavirtal.model.EstoqueDeProdutos;
import br.com.unifor.tcc.lojavirtal.model.Produto;

import com.google.appengine.api.users.UserService;

@Resource
public class ProdutosController {

	private final EstoqueDeProdutos estoque;
	private final Result result;
	private final Validator validator;
	private final UserService userService;

	public ProdutosController(EstoqueDeProdutos estoque, Result result,
			Validator validator, UserService userService) {
		this.estoque = estoque;
		this.result = result;
		this.validator = validator;
		this.userService = userService;
	}

	// Não pode ser usado por causa das restrições do GAE
	@Get
	@Path("/produtos/busca.json")
	public void buscaJson(String q) {
		result.use(Results.json()).withoutRoot().from(estoque.obter(q))
				.exclude("codigo", "descricao").serialize();
	}

	@Get
	@Path("/produtos/busca")
	public List<Produto> busca(String nome) {

		List<Produto> produtoList = estoque.obter(nome); 
		result.include("nome", nome)
				.include("user", userService.getCurrentUser())
				.include("logoutUrl", userService.createLogoutURL("/produtos"));
		if (produtoList.isEmpty()) {
			result.include("aviso", "Nenhum produto com o nome '" + nome
					+ "' encontrado!");
		}
		return produtoList;
	}

	@Get
	@Path("/produtos/novo")
	public void adicionarProduto() {
		result.include("user", userService.getCurrentUser()).include(
				"logoutUrl", userService.createLogoutURL("/produtos"));
	}

	@Post
	@Path("/produtos")
	public void adicionarProduto(final Produto produto) {
		validar(produto);
		validator.onErrorRedirectTo(getClass()).adicionarProduto();
		estoque.adicionarEditar(produto);
		result.include("aviso", produto.getNome() + " adicionado com sucesso!")
				.redirectTo(getClass()).lista();
	}

	@Delete
	@Path("/produtos/{codigo}")
	public void deletarProduto(Long codigo) {
		estoque.deletar(codigo);
		result.include("aviso", "Produto deletado com sucesso!")
				.forwardTo(getClass()).lista();
	}

	@Get
	@Path("/produtos/{codigo}")
	public Produto editarProduto(Long codigo) {
		result.include("user", userService.getCurrentUser()).include(
				"logoutUrl", userService.createLogoutURL("/produtos"));
		return estoque.obter(codigo);
	}

	@Put
	@Path("/produtos/{produto.codigo}")
	public void editarProduto(Produto produto) {
		validar(produto);
		validator.onErrorRedirectTo(getClass()).editarProduto(
				produto.getCodigo());
		estoque.adicionarEditar(produto);
		result.include("aviso", produto.getNome() + " alterado com sucesso!")
				.redirectTo(getClass()).lista();
	}

	@Get
	@Path("/produtos")
	public void lista() {
		result.include("produtos", estoque.todos())
				.include("user", userService.getCurrentUser())
				.include("logoutUrl", userService.createLogoutURL("/produtos"));
	}

	private void validar(final Produto produto) {
		validator.checking(new Validations() {

			{
				that(produto.getNome() != null
						&& produto.getNome().length() >= 3, "produto.nome",
						"nome.obrigatorio");
				that(produto.getDescricao() != null
						&& (produto.getDescricao().length() > 0 && produto
								.getDescricao().length() <= 40),
						"produto.descricao", "descricao.obrigatoria");
				that(produto.getPreco() != null && produto.getPreco() > 0.0,
						"produto.preco", "preco.positivo");
			}

		});
	}
	
}
