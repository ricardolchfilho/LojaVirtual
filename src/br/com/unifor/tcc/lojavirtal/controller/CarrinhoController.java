package br.com.unifor.tcc.lojavirtal.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.unifor.tcc.lojavirtal.model.Carrinho;
import br.com.unifor.tcc.lojavirtal.model.EstoqueDeProdutos;
import br.com.unifor.tcc.lojavirtal.model.Item;

import com.google.appengine.api.users.UserService;

@Resource
public class CarrinhoController {
	private Result result;
	private Carrinho carrinho;
	private Validator validator;
	private UserService userService;
	private EstoqueDeProdutos estoqueDeProdutos;

	public CarrinhoController(Result result, Carrinho carrinho,
			Validator validator, UserService userService,
			EstoqueDeProdutos estoqueDeProdutos) {
		this.result = result;
		this.carrinho = carrinho;
		this.validator = validator;
		this.userService = userService;
		this.estoqueDeProdutos = estoqueDeProdutos;
	}

	@Post
	@Path("/carrinho")
	public void adiciona(final Item item) {

		validator.checking(new Validations() {
			{
				that(item.getQuantidade() != null && item.getQuantidade() > 0,
						"item.getQuantidade", "quantidade.positiva");
			}
		});
		validator.onErrorRedirectTo(ProdutosController.class).lista();

		item.setProduto(estoqueDeProdutos.obter(item.getProduto().getCodigo()));
		carrinho.adiciona(item);

		result.include(
				"aviso",
				"Produto '" + item.getProduto().getNome()
						+ "' adicionado com sucesso no carrinho!")
				.redirectTo(ProdutosController.class).lista();
	}

	@Get
	@Path("/carrinho")
	public void visualiza() {
		result.include("userService", userService);
	}

	@Delete
	@Path("/carrinho/{indiceItem}")
	public void remove(int indiceItem) {
		carrinho.remove(indiceItem);
		result.redirectTo(getClass()).visualiza();
	}

}
