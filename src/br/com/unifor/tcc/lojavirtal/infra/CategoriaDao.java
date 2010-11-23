package br.com.unifor.tcc.lojavirtal.infra;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.unifor.tcc.lojavirtal.model.Categoria;
import br.com.unifor.tcc.lojavirtal.model.TodasCategorias;

import com.googlecode.objectify.Objectify;

@Component
public class CategoriaDao implements TodasCategorias {

	private final Objectify objectify;

	public CategoriaDao(Objectify objectify) {
		this.objectify = objectify;
	}

	public void adicionar(Categoria categoria) {
		objectify.put(categoria);
	}

	public List<Categoria> listar() {
		return objectify.query(Categoria.class).list();
	}

}
