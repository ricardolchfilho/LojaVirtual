package br.com.unifor.tcc.lojavirtal.model;

import java.util.List;

public interface TodasCategorias {

	void adicionar(Categoria categoria);
	
	List<Categoria> listar();

}
