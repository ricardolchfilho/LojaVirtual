package br.com.unifor.tcc.lojavirtal.controller;

import com.google.appengine.api.users.UserService;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.unifor.tcc.lojavirtal.model.Carrinho;
import br.com.unifor.tcc.lojavirtal.model.CarrinhoRepositorio;

@Resource
public class UsuariosController {
	
	private Result result;
	private CarrinhoRepositorio carrinhoRepositorio;
	private UserService userService;
	
	public UsuariosController(Result result,
			CarrinhoRepositorio carrinhoRepositorio, UserService userService) {
		this.result = result;
		this.carrinhoRepositorio = carrinhoRepositorio;
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
		carrinhoRepositorio.destroy();
		result.redirectTo(userService.createLogoutURL("/")) ;
	}
}
