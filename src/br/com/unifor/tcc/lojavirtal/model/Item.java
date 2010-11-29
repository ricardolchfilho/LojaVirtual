package br.com.unifor.tcc.lojavirtal.model;

import java.io.Serializable;


public class Item implements Serializable{
	private Produto produto;
	private Integer quantidade;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
