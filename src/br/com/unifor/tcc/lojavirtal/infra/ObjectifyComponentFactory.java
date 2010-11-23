package br.com.unifor.tcc.lojavirtal.infra;

import javax.annotation.PostConstruct;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.unifor.tcc.lojavirtal.model.Categoria;
import br.com.unifor.tcc.lojavirtal.model.Produto;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

@Component
@ApplicationScoped
public class ObjectifyComponentFactory implements ComponentFactory<Objectify> {

	private Objectify objectify;

	@PostConstruct
	public void create() {
		ObjectifyFactory factory = new ObjectifyFactory();
		factory.register(Produto.class);
		factory.register(Categoria.class);

		objectify = factory.begin();
	}

	@Override
	public Objectify getInstance() {
		return objectify;
	}

}
