package br.com.unifor.tcc.lojavirtal.infra;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.unifor.tcc.lojavirtal.model.Usuario;

@Component
@SessionScoped
public class UsuarioWeb {
	private Usuario logado;

	public UsuarioWeb(Usuario usuario) {
		this.logado = usuario;
	}
	
	public String getNickName(){
		return logado.getNickName();
	}
	public boolean isLogado(){
		return logado != null;
	}
	public void logout(){
		this.logado = null;
	}
	
}
