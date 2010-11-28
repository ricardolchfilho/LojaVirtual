package br.com.unifor.tcc.lojavirtal.controller;

import com.google.appengine.api.users.UserService;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.unifor.tcc.lojavirtal.model.Carrinho;

@Resource
public class UsuariosController {
	
	private Result result;
	private Carrinho carrinho;
	private UserService userService;
	
	public UsuariosController(Result result, Carrinho carrinho,
			UserService userService) {
		this.result = result;
		this.carrinho = carrinho;
		this.userService = userService;
	}

	@Get
	@Path("/")
	public void login() {
		result.redirectTo(userService.createLoginURL("/produtos"));
	}
	
	@Get
	@Path("/logout")
	public void logout() {
		carrinho.destroy();
		result.redirectTo(userService.createLogoutURL("/")) ;
	}
}
