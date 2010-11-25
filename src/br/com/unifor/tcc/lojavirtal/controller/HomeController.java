package br.com.unifor.tcc.lojavirtal.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.unifor.tcc.lojavirtal.interceptor.Public;
import br.com.unifor.tcc.lojavirtal.model.EstoqueDeProdutos;

@Resource
public class HomeController {
	
	private final Result result;
	
	private final EstoqueDeProdutos estoque;

	public HomeController(Result result, EstoqueDeProdutos estoque) {
		this.result = result;
		this.estoque = estoque;
	}
	
	@Get
	@Path("/user")
	@Public
	public void index() {
		result.include("produtos", estoque.produtosAVenda());
	}

}
