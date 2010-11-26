package br.com.unifor.tcc.lojavirtal.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.unifor.tcc.lojavirtal.model.Carrinho;
import br.com.unifor.tcc.lojavirtal.model.EstoqueDeProdutos;
import br.com.unifor.tcc.lojavirtal.model.Item;

@Resource
public class CarrinhoController {
	private Result result;
	private Carrinho carrinho;
	private Validator validator;
	private EstoqueDeProdutos estoqueDeProdutos;

	public CarrinhoController(Result result, Carrinho carrinho,
			Validator validator, EstoqueDeProdutos estoqueDeProdutos) {
		this.result = result;
		this.carrinho = carrinho;
		this.validator = validator;
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
		validator.onErrorUsePageOf(ProdutosController.class).lista();
		
		item.setProduto(estoqueDeProdutos.obter(item.getProduto().getCodigo()));
		carrinho.adiciona(item);

		result.redirectTo(ProdutosController.class).lista();
	}

}
