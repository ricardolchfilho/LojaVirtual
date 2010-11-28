package br.com.unifor.tcc.lojavirtal.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.SessionScoped;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Component
@ApplicationScoped
public class UserServiceComponentFactory implements
		ComponentFactory<UserService> {

	private UserService userService;

	@PostConstruct
	public void create() {
		this.userService = UserServiceFactory.getUserService();
	}
	
	@Override
	public UserService getInstance() {
		return userService;
	}

}
