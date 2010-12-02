package br.com.unifor.tcc.lojavirtal.model;

public interface CarrinhoRepositorio {
	
	void adiciona(Item item);
	
	void remove(int indiceItem);
	
	void destroy();
	
}
