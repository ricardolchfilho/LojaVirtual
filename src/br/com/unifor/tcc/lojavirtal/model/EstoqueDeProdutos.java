package br.com.unifor.tcc.lojavirtal.model;

import java.util.List;

public interface EstoqueDeProdutos {
	
	void adicionarEditar(Produto produto);
	
	void deletar (Long  codigo);
	
	Produto obter(Long codigo);

	List<Produto> todos();

	List<Produto> obter(String nome);

	void recarrega(Produto produto);
	
}
