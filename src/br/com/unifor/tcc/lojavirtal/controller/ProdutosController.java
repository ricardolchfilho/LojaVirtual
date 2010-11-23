package br.com.unifor.tcc.lojavirtal.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.unifor.tcc.lojavirtal.interceptor.Public;
import br.com.unifor.tcc.lojavirtal.model.EstoqueDeProdutos;
import br.com.unifor.tcc.lojavirtal.model.Produto;

@Resource
public class ProdutosController {

	private final EstoqueDeProdutos estoque;

	private final Result result;

	public ProdutosController(EstoqueDeProdutos estoque, Result result) {
		this.estoque = estoque;
		this.result = result;
	}

	@Public
	@Get
	@Path("/produtos/{codigo}")
	public void mostrar(Long codigo) {
		result.include("produto", estoque.obter(codigo));
	}
	
	@Get
	public List<Produto> lista(){
		return estoque.todos();
	}

}
